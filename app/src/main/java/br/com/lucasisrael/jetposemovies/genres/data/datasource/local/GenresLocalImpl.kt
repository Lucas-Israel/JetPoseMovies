package br.com.lucasisrael.jetposemovies.genres.data.datasource.local

import br.com.lucasisrael.jetposemovies.genres.data.datasource.database.GenreDao
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import javax.inject.Inject

class GenresLocalImpl @Inject constructor(
    private val genreDao: GenreDao
) : GenresLocal {

    override suspend fun saveGenresToDataBase(genres: List<GenreEntity>) {
        genreDao.insertGenres(genres)
    }

    override suspend fun getGenresFromDataBase(): List<GenreEntity> {
        return genreDao.getAllGenres()
    }

}
