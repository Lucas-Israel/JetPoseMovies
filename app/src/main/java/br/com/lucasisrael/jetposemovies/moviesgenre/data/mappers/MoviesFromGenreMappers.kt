package br.com.lucasisrael.jetposemovies.moviesgenre.data.mappers

import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.domain.MovieFromGenre
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.local.MovieFromGenreEntity
import br.com.lucasisrael.jetposemovies.moviesgenre.data.models.remote.MovieFromGenreDto

fun MovieFromGenreDto.toMoviesFromGenreEntity(): MovieFromGenreEntity {
    return MovieFromGenreEntity(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        id = id,
        original_language = original_language,
        original_Title = original_Title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}

fun MovieFromGenreEntity.toMovieFromGenre(): MovieFromGenre {
    return MovieFromGenre(
        adult = adult,
        backdrop_path = backdrop_path,
        genre_ids = genre_ids,
        id = id,
        original_language = original_language,
        original_Title = original_Title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}
