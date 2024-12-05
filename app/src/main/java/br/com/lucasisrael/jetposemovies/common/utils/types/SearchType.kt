package br.com.lucasisrael.jetposemovies.common.utils.types

sealed class SearchType {

    fun toApiQuery(): ApiQuery {
        return when (this) {
            is GenreId -> ApiQuery(
                genreId = this.genreId,
                page = this.page
            )

            is Popular -> ApiQuery(
                sortBy = this.sortBy,
                page = this.page
            )

            is TopRated -> ApiQuery(
                sortBy = this.sortBy,
                voteCount = this.voteCount,
                page = this.page
            )

            is Upcoming -> ApiQuery(
                releaseType = this.releaseType,
                releaseDateGte = this.releaseDateGte,
                releaseDateLte = this.releaseDateLte,
                page = this.page
            )
        }
    }

    data class GenreId(
        val genreId: String,
        val page: Int
    ) : SearchType()

    data class Upcoming(
        val releaseType: Int = 2,
        val releaseDateGte: String = "{min_date}",
        val releaseDateLte: String = "{max_date}",
        val page: Int
    ) : SearchType()

    data class Popular(
        val sortBy: String = "popularity.desc",
        val page: Int
    ) : SearchType()

    data class TopRated(
        val sortBy: String = "vote_average.desc",
        val voteCount: Double = 200.00,
        val page: Int
    ) : SearchType()
}

data class ApiQuery(
    val genreId: String? = null,
    val sortBy: String? = "popularity.desc",
    val releaseType: Int? = null,
    val releaseDateGte: String? = null,
    val releaseDateLte: String? = null,
    val voteCount: Double? = null,
    val page: Int? = 1
)
