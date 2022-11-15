package android.realproject.trackerm3.model

import androidx.compose.ui.graphics.Brush

data class CategoryItemData(
    val id: Int,
    val icon: Int,
    val text: String,
    val bgColor: Brush,
    val imageBg: Int? = null,
    val descToAddiction: Int,
    var likePost: Boolean? = null,
    val quote: Int? = null
)


