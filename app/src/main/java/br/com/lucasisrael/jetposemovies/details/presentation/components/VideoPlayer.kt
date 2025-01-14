@file:Suppress("FunctionNaming")

package br.com.lucasisrael.jetposemovies.details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import br.com.lucasisrael.jetposemovies.details.models.remote.VideosItem
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LocalLifecycleOwner
import br.com.lucasisrael.jetposemovies.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback

@Composable
fun VideosPlayer(
    videos: List<VideosItem>,
) {
    if (videos.isNotEmpty()) {
        var videoId by remember { mutableStateOf(videos[0].key) }
        Column {
            LazyRow(
                contentPadding = PaddingValues(bottom = 6.dp),
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(count = videos.size.coerceAtMost(maximumValue = 3)) { index ->
                    VideoKeySelector(
                        index = index,
                        onClick = { videoId = videos[index].key }
                    )
                }
            }
        }
        YouTubePlayer(
            videoId = videoId,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(12.dp))
        )
    }
}

@Composable
private fun VideoKeySelector(
    onClick: () -> Unit,
    index: Int,
) {
    Button(
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledContentColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(6.dp),
        onClick = onClick,
        modifier = Modifier
            .padding(6.dp)
    ) {
        Text(
            text = stringResource(R.string.video_index, index + 1),
            modifier = Modifier
        )
    }
}

@Composable
private fun YouTubePlayer(
    videoId: String,
    modifier: Modifier,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    AndroidView(
        modifier = modifier,
        factory = { context ->
            YouTubePlayerView(context).apply {
                lifecycleOwner.lifecycle.addObserver(this)
                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.cueVideo(
                            videoId = videoId,
                            startSeconds = 0f
                        )
                    }
                })
            }
        },
        update = { youTubePlayerView ->
            youTubePlayerView.apply {
                getYouTubePlayerWhenReady(
                    youTubePlayerCallback = YTCallback(
                        videoId = videoId,
                        startSeconds = 0f
                    )
                )
            }
        }
    )
}

private class YTCallback(
    private val videoId: String,
    private val startSeconds: Float,
) : YouTubePlayerCallback {
    override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
        youTubePlayer.cueVideo(videoId = videoId, startSeconds = startSeconds)
    }
}
