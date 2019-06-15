package com.paweloot.imageviewer

import android.graphics.Color
import android.view.ViewGroup
import android.widget.ImageView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.squareup.picasso.Picasso

class CardPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = object : ImageCardView(parent.context) {
            override fun setSelected(selected: Boolean) {
                updateCardBackgroundColor(this, parent, selected)
                super.setSelected(selected)
            }
        }

        cardView.isFocusable = true
        updateCardBackgroundColor(cardView, parent, false)
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val image = item as Image
        val cardView = viewHolder.view as ImageCardView

        cardView.titleText = image.title
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)

        loadImage(image.imageUrl, cardView.mainImageView)
    }

    private fun loadImage(imageUrl: String, target: ImageView) {
        Picasso.get()
            .load(imageUrl)
            .into(target)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        val cardView = viewHolder.view as ImageCardView

        cardView.mainImage = null
    }

    private fun updateCardBackgroundColor(view: ImageCardView, parent: ViewGroup, selected: Boolean) {
        val selectionColor = parent.context.getColor(R.color.browse_header)
        val currentColor = if (selected) selectionColor else Color.BLACK

        view.setBackgroundColor(currentColor)
        view.setInfoAreaBackgroundColor(currentColor)
    }

    companion object {
        private const val CARD_WIDTH = 320
        private const val CARD_HEIGHT = 180
    }
}
