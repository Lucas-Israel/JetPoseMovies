package br.com.lucasisrael.jetposemovies.genres.data.remote

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import br.com.lucasisrael.jetposemovies.genres.data.api.GenresApi
import br.com.lucasisrael.jetposemovies.genres.data.local.GenreDataBase
import br.com.lucasisrael.jetposemovies.genres.data.mappers.toGenresEntity
import br.com.lucasisrael.jetposemovies.genres.data.models.local.GenreEntity
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class GenreRemoteMediator(
    private val genreDb: GenreDataBase,
    private val genreApi: GenresApi
) : RemoteMediator<Int, GenreEntity>() {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GenreEntity>
    ): MediatorResult {
        return try {

            val genres = genreApi.getGenres().genres

            genreDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    genreDb.dao.clearAll()
                }
                val genreEntities = genres.map { it.toGenresEntity() }
                genreDb.dao.upsertAll(genreEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = genres.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
