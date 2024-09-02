package br.com.lucasisrael.jetposemovies.common.corroutines

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import br.com.lucasisrael.jetposemovies.common.models.ClientResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException

/**
 * A helper function to make safe API calls.
 * @param dispatcher The coroutine dispatcher to use for making the API call.
 * @param apiCall The suspend function representing the API call.
 * @return A [ClientResult] indicating the success or failure of the API call.
 * @throws CancellationException if the API call is cancelled.
 */
@SuppressWarnings("TooGenericExceptionCaught")
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): ClientResult<T> {
    return withContext(dispatcher) {
        try {
            val response = apiCall()
            ClientResult.ClientSuccess(response)
        } catch (e: Exception) {
            when (e) {
                is CancellationException -> {
                    // Rethrow cancellation exception to ensure coroutines are cancelled correctly
                    throw e
                }

                is HttpException -> {
                    // Handle HTTP errors, assuming it's a server error
                    ClientResult.ClientError(
                        isNetworkError = true,
                        isServerError = false
                    )
                }

                is IOException -> {
                    // Handle network errors (e.g., no connectivity)
                    ClientResult.ClientError(
                        isNetworkError = false,
                        isServerError = true
                    )
                }

                else -> {
                    // Handle any other unexpected exceptions
                    ClientResult.ClientError(
                        isNetworkError = true,
                        isServerError = false
                    )
                }
            }
        }
    }
}
