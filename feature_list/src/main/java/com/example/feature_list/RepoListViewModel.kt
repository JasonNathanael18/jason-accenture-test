package com.example.feature_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.usecase.GetUser
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val getUser: GetUser
) : ViewModel() {
    val action: (RepoListUiAction) -> Unit

    private val viewModelState = MutableStateFlow(RepoListViewModelState(isLoading = true))
    val uiState = viewModelState
        .map(RepoListViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        action = {
            when (it) {
                RepoListUiAction.FetchRepoList -> fetchRepoList()
            }
        }
        fetchRepoList()
    }

    private fun fetchRepoList() {
        viewModelScope.launch {
            getUser.getUserList().collect { response ->
                when (response) {
                    is Resource.Error -> viewModelState.update {
                        it.copy(error = response.message.orEmpty())
                    }
                    is Resource.Loading -> viewModelState.update {
                        it.copy(error = "", isLoading = true)
                    }
                    is Resource.Success ->
                        response.data?.let { list ->
                            viewModelState.update {
                                it.copy(repoList = list, isLoading = false)
                            }
                        }
                }
            }
        }
    }

}

private data class RepoListViewModelState(
    val isLoading: Boolean = false,
    val error: String = "",
    val repoList: List<User> = listOf()
) {
    fun toUiState(): RepoListUiState =
        if (repoList.isEmpty()) RepoListUiState.RepoListEmpty(isLoading = isLoading, error = error)
        else RepoListUiState.HasRepoList(isLoading = isLoading, error = error, repoList = repoList)
}

sealed interface RepoListUiState {
    val isLoading: Boolean
    val error: String

    data class HasRepoList(
        val repoList: List<User>,
        override val isLoading: Boolean,
        override val error: String
    ) : RepoListUiState

    data class RepoListEmpty(
        override val isLoading: Boolean,
        override val error: String
    ) : RepoListUiState
}

sealed class RepoListUiAction {
    object FetchRepoList : RepoListUiAction()
}