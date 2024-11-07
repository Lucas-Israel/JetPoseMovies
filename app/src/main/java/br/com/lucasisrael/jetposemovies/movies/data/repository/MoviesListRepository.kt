package br.com.lucasisrael.jetposemovies.movies.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.RemoteMediator
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.movies.data.datasource.local.SearchType
import br.com.lucasisrael.jetposemovies.movies.data.models.local.MovieEntity
import br.com.lucasisrael.jetposemovies.movies.data.models.query.MovieApiQuery
import br.com.lucasisrael.jetposemovies.movies.data.models.remote.MovieDto

@OptIn(ExperimentalPagingApi::class)
abstract class MoviesListRepository<T: Any>: RemoteMediator<Int, T>()
