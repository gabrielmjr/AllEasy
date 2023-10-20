package com.mjr.app.alleasy.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.adapter.SubtitlesAdapter
import com.mjr.app.alleasy.model.Subtitle
import java.util.ArrayList

abstract class SubtitlesFragment: BaseFragment(), SubtitlesAdapter.OnSubtitleClickListener {
    private var subtitlesContainer: RecyclerView? = null
    private var adapter: SubtitlesAdapter? = null
    protected var subtitles: ArrayList<Subtitle>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subtitles, container, false)
    }

    override fun getViews() {
        subtitlesContainer = viewContainer?.findViewById(R.id.subtitles_recycler_view)
    }

    override fun initializeAttributes() {
        subtitles = ArrayList()
        adapter = SubtitlesAdapter(
            requireContext().applicationContext,
            subtitles,
            this
        )
        subtitlesContainer?.adapter = adapter
        subtitlesContainer?.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        initializeSubtitles()
    }

    protected abstract fun initializeSubtitles()

    override fun onSubtitleClick(position: Int) {
        subtitles?.get(position)?.let { replaceFragment(it) }
    }
}