package com.example.gagagagaandroid.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gagagagaandroid.adapter.ListAdapter
import com.example.gagagagaandroid.data.ListDataSource
import com.example.gagagagaandroid.data.LocalListDataSource
import com.example.gagagagaandroid.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private var listDataSource: ListDataSource = LocalListDataSource()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList = listDataSource.fetchListItems()
        val listAdapter = ListAdapter(object : ListAdapter.ItemClick {
            override fun onClick() {
                showDialog()
            }
        })
        binding.rvList.adapter = listAdapter
        listAdapter.replaceList(dataList)
    }

    private fun showDialog() {
        val dialog = ListDialogFragment.CustomDialogBuilder().create()
        dialog.isCancelable = false
        dialog.show(parentFragmentManager, "dialog")
    }
}