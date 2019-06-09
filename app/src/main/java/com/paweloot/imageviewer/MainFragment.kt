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
        title = "Image Viewer"
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true

        brandColor = getColor(resources, R.color.browse_header, null)
        searchAffordanceColor = getColor(resources, R.color.browse_search, null)
    }

    private fun loadRows() {
        val headersList = listOf(
            "Cities",
            "People",
            "Trip"
        )

        val imageList = listOf(
            Image("Stunning New York", resources.getDrawable(R.drawable.new_york, null)),
            Image("Zebra or not a zebra?", resources.getDrawable(R.drawable.zebra_stripes, null)),
            Image("Somewhere in Asia", resources.getDrawable(R.drawable.somewhere_in_asia, null)),
            Image("Red Head", resources.getDrawable(R.drawable.red_head, null)),
            Image("Stripes stripes stripes", resources.getDrawable(R.drawable.stripes_again, null)),
            Image("Mountains", resources.getDrawable(R.drawable.mountains, null)),
            Image("Reflection", resources.getDrawable(R.drawable.car_mirror, null)),
            Image("Lonely", resources.getDrawable(R.drawable.lone_road, null)),
            Image("Time to go!", resources.getDrawable(R.drawable.travel_stuff, null))
        )

        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = CardPresenter()

        for (i in 0 until NUM_ROWS) {
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)

            for (j in 0 until NUM_COLS) {
                listRowAdapter.add(imageList[i * NUM_COLS + j])
            }

            val header = HeaderItem(headersList[i])
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        (main_browse_fragment as BrowseFragment).adapter = rowsAdapter
    }

    private fun setupEventListeners() {
        onItemViewClickedListener = ItemViewClickedListener()
        onItemViewSelectedListener = ItemViewSelectedListener()
    }

    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder,
            item: Any,
            rowViewHolder: RowPresenter.ViewHolder,
            row: Row
        ) {

        }
    }

    private inner class ItemViewSelectedListener : OnItemViewSelectedListener {
        override fun onItemSelected(
            itemViewHolder: Presenter.ViewHolder?, item: Any?,
            rowViewHolder: RowPresenter.ViewHolder, row: Row
        ) {

        }
    }

    companion object {
        private const val NUM_ROWS = 3
        private const val NUM_COLS = 3
    }
}
