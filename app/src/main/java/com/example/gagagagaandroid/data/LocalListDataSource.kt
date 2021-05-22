package com.example.gagagagaandroid.data

import com.example.gagagagaandroid.ui.list.ListData

class LocalListDataSource : ListDataSource {
    override fun fetchListItems(): MutableList<ListData> {
        return mutableListOf<ListData>(
            ListData(
                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "김희빈",
                tags = arrayListOf("tag1", "tag2", "tag3"),
                description = "안드로이드 어쩌구",
                test1 = "얘는 눌러야 보임"
            ),
            ListData(
                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "김희빈",
                tags = arrayListOf("tag1", "tag2", "tag3"),
                description = "안드로이드 어쩌구",
                test1 = "얘는 눌러야 보임"
            ),
            ListData(
                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "김희빈",
                tags = arrayListOf("tag1", "tag2", "tag3"),
                description = "안드로이드 어쩌구",
                test1 = "얘는 눌러야 보임"
            ),
            ListData(
                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "김희빈",
                tags = arrayListOf("tag1", "tag2", "tag3"),
                description = "안드로이드 어쩌구",
                test1 = "얘는 눌러야 보임"
            ),
        )
    }
}