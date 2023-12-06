package com.example.feature_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.common.compose.ApplicationAppbar
import com.example.common.compose.CircularProgressBar
import com.example.common.compose.NetworkErrorMessage
import com.example.domain.model.User

@Composable
fun RepoListScreen(
    uiState: RepoListUiState,
    onNavigateProfile: () -> Unit,
    onRefreshRepoList: () -> Unit
) {
    RepoListScreen(
        uiState = uiState,
        hasRepoList = { repoItem, modifier ->
            RepoListItem(
                modifier = modifier,
                repoItem = repoItem,
                onItemClick = onNavigateProfile
            )
        },
        onRefreshRepoList = onRefreshRepoList
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RepoListScreen(
    uiState: RepoListUiState,
    hasRepoList: @Composable (repoItem: User, modifier: Modifier) -> Unit,
    onRefreshRepoList: () -> Unit
) {
    Scaffold(
        topBar = { ApplicationAppbar(title = "Repo List") },
    ) {
        val modifier = Modifier.padding(it)
        FullScreenLoading(
            isLoading = uiState.isLoading,
            loadingContent = { CircularProgressBar() },
            content = {
                when (uiState) {

                    is RepoListUiState.HasRepoList -> {
                        LazyColumn {
                            items(items = uiState.repoList) { repoItem ->
                                hasRepoList(repoItem = repoItem, modifier = modifier)
                            }
                        }
                    }

                    is RepoListUiState.RepoListEmpty -> {
                        if (uiState.error.isNotEmpty()) {
                            NetworkErrorMessage(
                                message = uiState.error,
                                onClickRefresh = onRefreshRepoList
                            )
                        } else {
                            Text(text = "You have no repo list right now")
                        }
                    }
                }
            }
        )


    }
}

@Composable
private fun FullScreenLoading(
    isLoading: Boolean,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    if (isLoading) loadingContent()
    else content()
}

@Composable
private fun RepoListItem(
    modifier: Modifier = Modifier,
    repoItem: User,
    onItemClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(bottom = 1.dp)
            .clickable {
                onItemClick()
            },
        shape = RoundedCornerShape(size = 0.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = repoItem.avatarUrl),
                    contentDescription = "",
                    modifier = modifier
                        .size(80.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .border(2.dp, Color.Gray, CircleShape)
                )
                Spacer(modifier = modifier.width(16.dp))
                Column {
                    Text(text = repoItem.login, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}



