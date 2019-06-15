package com.paweloot.imageviewer

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        (fullscreen_image_fragment as ImageFragment).loadImage(intent.getStringExtra(Image.IMAGE_URL))
    }
}
