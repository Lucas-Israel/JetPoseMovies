package br.com.lucasisrael.jetposemovies.genres.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.GenresWithImgUrl
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.datasource.GenresDataSource
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.MoviesFromGenreDataSource
import javax.inject.Inject

class GenresRepositoryImpl @Inject constructor(
    private val genresDataSource: GenresDataSource,
    private val moviesFromGenreDataSource: MoviesFromGenreDataSource
) : GenresRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getGenres(): Resource<MutableList<GenresWithImgUrl>?> {
        return safeApiCall {
            val payload: MutableList<GenresWithImgUrl> = mutableListOf()
            val genres = genresDataSource.getGenres()
            genres.genres.forEach {
                val id = it.id.toString()
                val movies = moviesFromGenreDataSource.getMoviesFromGenre(id, page = 1)
                payload.add(GenresWithImgUrl(it.id, it.name, movies.results[0].poster_path))
            }

            return@safeApiCall payload
        }
    }
}
