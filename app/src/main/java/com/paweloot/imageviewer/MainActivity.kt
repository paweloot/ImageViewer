package com.paweloot.imageviewer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openImageActivity(image: Image) {
        val intent = Intent(this, ImageActivity::class.java)
        intent.putExtra(Image.IMAGE_URL, image.imageUrl)
        startActivity(intent)
    }
}
