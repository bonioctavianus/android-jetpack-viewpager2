package com.bonioctavianus.android.jetpack_viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : Fragment() {

    companion object {

        fun getInstance(bundle: Bundle): PageFragment {
            return PageFragment()
                .apply { arguments = bundle }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString("title")
        val summary = arguments?.getString("summary")

        text_page_title.text = title
        text_page_summary.text = summary
    }
}