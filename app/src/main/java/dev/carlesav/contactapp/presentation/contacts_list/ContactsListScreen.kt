package dev.carlesav.contactapp.presentation.contacts_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.carlesav.contactapp.R
import dev.carlesav.contactapp.presentation.components.ErrorComponent
import dev.carlesav.contactapp.presentation.components.LoadingComponent
import dev.carlesav.contactapp.presentation.contacts_list.components.ContactsComponent
import dev.carlesav.contactapp.presentation.destinations.ContactDetailScreenDestination

@Destination(start = true)
@Composable
fun ContactsListScreen(
    viewModel: ContactsListViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {
    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.contacts)) }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when {
                state.isLoading -> {
                    LoadingComponent(modifier = Modifier.fillMaxSize())
                }
                state.error.isNotEmpty() -> {
                    ErrorComponent(message = state.error)
                }
                state.items.isNotEmpty() -> {
                    ContactsComponent(
                        contacts = state.items,
                        onContactClick = { contact ->
                            navigator.navigate(
                                ContactDetailScreenDestination(
                                    contact = contact
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}
