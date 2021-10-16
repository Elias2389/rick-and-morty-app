package com.ae.rickandmortyapp.data.datasource.characterlist.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ae.rickandmortyapp.data.service.CharacterService
import com.ae.rickandmortyapp.dto.ResultsItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersPagingDataSource @Inject constructor(
    private val service: CharacterService
) : PagingSource<Int, ResultsItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getCharactersByPage(pageNumber)
            val pagedResponse = response.body()
            val data = pagedResponse?.results

            var nextPageNumber: Int? = null
            if (pagedResponse?.info?.next != null) {
                val uri = Uri.parse(pagedResponse.info.next)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int = 1
}