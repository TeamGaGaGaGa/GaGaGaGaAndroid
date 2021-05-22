package com.example.gagagagaandroid.data

import com.example.gagagagaandroid.ui.list.ListData

interface ListDataSource {
    fun fetchListItems(): MutableList<ListData>
}