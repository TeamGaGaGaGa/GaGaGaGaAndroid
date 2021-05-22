package com.example.gagagagaandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.gagagagaandroid.R
import com.example.gagagagaandroid.adapter.HomeListAdapter
import com.example.gagagagaandroid.adapter.MainViewPagerAdapter
import com.example.gagagagaandroid.databinding.ActivityMainBinding
import com.example.gagagagaandroid.ui.homefragment.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setViewPagerAdapter()
        binding.bnvMain.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item1 -> binding.vpMain.currentItem = 0
                R.id.item2 -> binding.vpMain.currentItem = 1
                else -> binding.vpMain.currentItem = 2
            }
            true
        }
//        val homeListFragment = HomeFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.homeList_container, homeListFragment)
//        transaction.commit()
    }

    private fun setViewPagerAdapter() {
        val viewPagerAdapter = MainViewPagerAdapter(this)
        binding.vpMain.apply {
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(PageChangeCallBack())
            isUserInputEnabled = false
        }
    }

    private inner class PageChangeCallBack : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.bnvMain.selectedItemId = when (position) {
                0 -> R.id.item1
                1 -> R.id.item2
                2 -> R.id.item3
                else -> throw IllegalArgumentException("Wrong Position $position")
            }
        }
    }
}