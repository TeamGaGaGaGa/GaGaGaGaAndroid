package com.example.gagagagaandroid.ui.homefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gagagagaandroid.HomeListData
import com.example.gagagagaandroid.adapter.HomeListAdapter
import com.example.gagagagaandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private lateinit var homeListAdapter: HomeListAdapter
    private lateinit var result: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureHomeList()
    }

    private fun configureHomeList() {
        homeListAdapter = HomeListAdapter()
        binding.homeList.adapter = homeListAdapter
        homeListAdapter.homeList.addAll(
            listOf<HomeListData>(
                HomeListData(
                            "채정아",
                            "서버",
                            "ob",
                            "entp",
                            "s3~",
                            "홍대",
                             "너구리",
                            true,
                            "쌓여있다",
                            "낮코",
                            "fkfkfkf"
                ),
                HomeListData(
                    "채아",
                    "서버",
                    "ob",
                    "entp",
                    "s3~",
                    "홍대",
                    "너구리",
                    true,
                    "쌓여있다",
                    "낮코",
                    "fkfkfkf"
                ),
                HomeListData(
                    "정아",
                    "서버",
                    "ob",
                    "entp",
                    "s3~",
                    "홍대",
                    "너구리",
                    true,
                    "쌓여있다",
                    "낮코",
                    "fkfkfkf"
                ),
                HomeListData(
                    "채정",
                    "서버",
                    "ob",
                    "entp",
                    "s3~",
                    "홍대",
                    "너구리",
                    true,
                    "쌓여있다",
                    "낮코",
                    "fkfkfkf"
                )
            )
        )
        homeListAdapter.notifyDataSetChanged()
    }

}