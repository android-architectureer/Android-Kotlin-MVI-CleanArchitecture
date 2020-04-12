package com.mi.mvi.domain.main.blogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.mi.mvi.data.models.AuthToken
import com.mi.mvi.data.repository.main.BlogRepository
import com.mi.mvi.data.response_handler.DataState
import com.mi.mvi.ui.main.blog.state.BlogViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn


@ExperimentalCoroutinesApi
class IsAuthorBlogPostUseCase(val repository: BlogRepository) {

    fun invoke(
        token: AuthToken,
        slug: String
    ): LiveData<DataState<BlogViewState>> {
        return repository.isAuthorOfBlogPosts(token, slug)
            .flowOn(Dispatchers.IO)
            .asLiveData()
    }
}