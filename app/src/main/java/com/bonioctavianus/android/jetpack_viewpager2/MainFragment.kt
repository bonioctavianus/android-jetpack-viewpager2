package com.bonioctavianus.android.jetpack_viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerOnBackPressedDispatcher()
        initActionMenu()

        viewpager.adapter = PageAdapter(this)

        TabLayoutMediator(tab_layout, viewpager) { tab, position ->
            tab.text = "Page $position"
        }.attach()
    }

    private fun registerOnBackPressedDispatcher() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (viewpager.currentItem == 0) {
                    requireActivity().finish()
                } else {
                    viewpager.currentItem = viewpager.currentItem - 1
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun initActionMenu() {
        toolbar.inflateMenu(R.menu.fragment_main_menu)

        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_menu_vertical_orientation -> {
                    viewpager.orientation = ViewPager2.ORIENTATION_VERTICAL
                }

                R.id.action_menu_horizontal_orientation -> {
                    viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                }

                R.id.action_menu_zoom_out_transformer -> {
                    viewpager.setPageTransformer(ZoomOutPageTransformer())
                }

                R.id.action_menu_depth_page_transformer -> {
                    viewpager.setPageTransformer(DepthPageTransformer())
                }
            }
            true
        }
    }
}