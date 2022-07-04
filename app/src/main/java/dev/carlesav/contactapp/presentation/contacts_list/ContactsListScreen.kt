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
import androidx.hilt.navigation.compose.hiltViewModel
import dev.carlesav.contactapp.presentation.components.ErrorComponent
import dev.carlesav.contactapp.presentation.components.LoadingComponent
import dev.carlesav.contactapp.presentation.contacts_list.components.ContactsComponent

@Composable
fun ContactsListScreen(
    viewModel: ContactsListViewModel = hiltViewModel(),
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
                title = { Text("Contacts") }
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
                    ContactsComponent(state.items)
                }
            }
        }
    }
}
