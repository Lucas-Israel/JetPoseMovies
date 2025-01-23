@file:Suppress("FunctionNaming")

package br.com.lucasisrael.jetposemovies.details.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LocalLifecycleOwner
import br.com.lucasisrael.jetposemovies.R
import br.com.lucasisrael.jetposemovies.common.presentation.components.CustomButton
import br.com.lucasisrael.jetposemovies.common.utils.constants.Constants.YOUTUBE_PLAYER_LANDSCAPE_MULTIPLIER
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback

@Composable
fun VideosPlayer(
    videos: List<VideosItem>,
) {
    val isLandScape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
    val ytPlayerSize = remember { if (isLandScape) YOUTUBE_PLAYER_LANDSCAPE_MULTIPLIER else 1f }
    if (videos.isNotEmpty()) {
        var videoId by remember { mutableStateOf(videos[0].key) }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyRow(
                contentPadding = PaddingValues(bottom = 6.dp),
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(count = videos.size.coerceAtMost(maximumValue = 3)) { index ->
                    VideoKeySelector(
                        index = index,
                        onClick = { videoId = videos[index].key },
                        modifier = Modifier
                            .padding(start = 4.dp, end = 4.dp)
                    )
                }
            }
            YouTubePlayer(
                videoId = videoId,
                modifier = Modifier
                    .fillMaxSize(ytPlayerSize)
                    .clip(shape = RoundedCornerShape(12.dp))
            )
        }
    }
}

@Composable
private fun VideoKeySelector(
    onClick: () -> Unit,
    index: Int,
    modifier: Modifier
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier
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
