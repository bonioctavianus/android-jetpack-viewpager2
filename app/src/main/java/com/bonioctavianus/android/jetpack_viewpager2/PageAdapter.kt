package com.bonioctavianus.android.jetpack_viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return PageFragment.getInstance(
            Bundle()
                .apply {
                    putString("title", "Page $position")
                    putString("summary", "Page $position summary")
                }
        )
    }
}