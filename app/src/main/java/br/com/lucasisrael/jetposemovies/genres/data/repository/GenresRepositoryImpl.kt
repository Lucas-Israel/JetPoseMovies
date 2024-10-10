package br.com.lucasisrael.jetposemovies.genres.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.coroutines.safeApiCall
import br.com.lucasisrael.jetposemovies.common.models.GenresWithImgUrl
import br.com.lucasisrael.jetposemovies.common.models.Resource
import br.com.lucasisrael.jetposemovies.genres.data.datasource.database.GenreDao
import br.com.lucasisrael.jetposemovies.genres.data.datasource.local.GenresLocal
import br.com.lucasisrael.jetposemovies.genres.data.datasource.remote.GenresRemote
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenresEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.datasource.MoviesFromGenreDataSource
import javax.inject.Inject

class GenresRepositoryImpl @Inject constructor(
    private val genresRemote: GenresRemote,
    private val moviesFromGenreDataSource: MoviesFromGenreDataSource,
    private val genresLocal: GenresLocal
) : GenresRepository {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getGenresWithImage(): Resource<List<GenresWithImgUrl>?> {

        return safeApiCall {
            refreshGenres()
            val genres = genresLocal.getGenresFromDataBase()

            genres.map {
                val id = it.id.toString()
                val movies = moviesFromGenreDataSource.getMoviesFromGenre(id, page = 1)
                val imageUrlForGenre = movies.results[0].poster_path
                GenresWithImgUrl(it.id, it.name, imageUrlForGenre)
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun refreshGenres() {

        safeApiCall {
            val genresRemote = genresRemote.getGenres()
            genresLocal.saveGenresToDataBase(
                genresRemote.map {
                    it.toGenresEntity()
                }
            )
        }
    }
}
