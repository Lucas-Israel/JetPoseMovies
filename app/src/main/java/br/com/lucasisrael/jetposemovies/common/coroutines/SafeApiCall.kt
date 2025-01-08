package br.com.lucasisrael.jetposemovies.common.coroutines

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * A helper function to make safe API calls.
 * @param dispatcher The coroutine dispatcher to use for making the API call.
 * @param apiCall The suspend function representing the API call.
 * @return The API call.
 * @throws Exception
 */
@SuppressWarnings("TooGenericExceptionCaught")
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T,
): T? {
    return withContext(dispatcher) {
        try {
            delay(timeMillis = 500)
            apiCall()
        } catch (e: Exception) {
            Log.e(e.message, e.cause.toString())
            throw e
        }
    }
}
