package com.paweloot.imageviewer

import android.os.Bundle
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.leanback.app.BrowseFragment
import androidx.leanback.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : BrowseFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUIElements()
        loadRows()
        setupEventListeners()
    }

    private fun setupUIElements() {
        title = getString(R.string.app_name)
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = getColor(resources, R.color.browse_header, null)
    }

    private fun loadRows() {
        val headersList = listOf(
            "Cities",
            "People",
            "Trip"
        )

        val imageList = ImageList.get()

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()

        for (i in 0 until NUM_ROWS) {
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)

            for (j in 0 until NUM_COLS) {
                listRowAdapter.add(imageList[(i * NUM_COLS + j) % imageList.size])
            }

            val header = HeaderItem(headersList[i])
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        (main_browse_fragment as BrowseFragment).adapter = rowsAdapter
    }

    private fun setupEventListeners() {
        onItemViewClickedListener = ItemViewClickedListener()
    }

    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder,
            item: Any,
            rowViewHolder: RowPresenter.ViewHolder,
            row: Row
        ) {
            (activity as MainActivity).openImageActivity(item as Image)
        }
    }

    companion object {
        private const val NUM_ROWS = 3
        private const val NUM_COLS = 3
    }
}
