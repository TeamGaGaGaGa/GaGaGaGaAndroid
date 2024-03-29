package com.example.gagagagaandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gagagagaandroid.ui.list.ListFragment
import com.example.gagagagaandroid.ui.first.FirstFragment
import com.example.gagagagaandroid.ui.homefragment.HomeFragment

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> FirstFragment()
            else -> ListFragment()
        }
    }
}