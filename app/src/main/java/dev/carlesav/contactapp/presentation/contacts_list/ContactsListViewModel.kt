package dev.carlesav.contactapp.presentation.contacts_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.carlesav.contactapp.core.Resource
import dev.carlesav.contactapp.domain.use_case.GetContactsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ContactsListViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase,
) : ViewModel() {
    var state by mutableStateOf(ContactListState())
        private set

    init {
        getContacts()
    }

    private fun getContacts() {
        getContactsUseCase().onEach { response ->
            state = when (response) {
                is Resource.Loading -> {
                    state.copy(isLoading = true)
                }
                is Resource.Success -> {
                    state.copy(
                        isLoading = false,
                        items = response.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        isLoading = false,
                        error = response.message.toString()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
