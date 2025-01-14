package br.com.lucasisrael.jetposemovies.details.models.remote

data class VideosResponse(
    val results: List<VideosItem>
)

data class VideosItem(
    val name: String,
    val key: String,
    val type: String,
)
