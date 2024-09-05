package br.com.lucasisrael.jetposemovies.common.coroutines

import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.models.ClientResult
import br.com.lucasisrael.jetposemovies.common.models.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

/**
 * A helper function to make safe API calls.
 * @param dispatcher The coroutine dispatcher to use for making the API call.
 * @param apiCall The suspend function representing the API call.
 * @return A [Resource] indicating the success or failure of the API call.
 * @throws CancellationException if the API call is cancelled.
 */
@SuppressWarnings("TooGenericExceptionCaught")
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): Resource<T?> {
    return withContext(dispatcher) {
        try {
            val response = apiCall()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(data = null, message = e.message!!)
            throw e
        }
    }
}
