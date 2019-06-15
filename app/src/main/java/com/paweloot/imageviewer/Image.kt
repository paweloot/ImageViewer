package com.paweloot.imageviewer

data class Image(val title: String, val imageUrl: String) {
    companion object {
        const val IMAGE_TITLE = "IMAGE_TITLE"
        const val IMAGE_URL = "IMAGE_URL"
    }
}


