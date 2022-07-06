package dev.carlesav.contactapp.presentation.contact_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dev.carlesav.contactapp.R
import dev.carlesav.contactapp.domain.model.Contact
import dev.carlesav.contactapp.presentation.components.ContactImageComponent
import kotlinx.coroutines.launch

@Destination
@Composable
fun ContactDetailScreen(
    navigator: DestinationsNavigator,
    contact: Contact,
) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = contact.name) },
                navigationIcon = {
                    IconButton(onClick = { navigator.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.Center) {

                ContactImageComponent(
                    imageUrl = contact.image_url,
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                )
            }

            Text(text = contact.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("detail-${contact.name}"),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center)

            Text(text = contact.location,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center)

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center) {

                IconButton(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(context.resources.getString(R.string.perform_call))
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null
                    )
                }

                IconButton(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(context.resources.getString(R.string.perform_email))
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
