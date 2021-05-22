package com.example.gagagagaandroid.data

import com.example.gagagagaandroid.ui.list.ListData

class LocalListDataSource : ListDataSource {
    override fun fetchListItems(): MutableList<ListData> {
        return mutableListOf<ListData>(
            ListData(
//                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "김솝트",
                tags = arrayListOf("#iOS", "#enfp", "YB"),
                description = "홍대에서 만난 너구리",
            ),
            ListData(
//                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "이은솔",
                tags = arrayListOf("#기획", "#esfp", "#YB"),
                description = "강남에서 만난 라이언",
            ),
            ListData(
//                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "명세린",
                tags = arrayListOf("#Android", "#entj", "#OB"),
                description = "회기에서 만난 꼬부기"
            ),
            ListData(
//                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "박시원",
                tags = arrayListOf("#디자인", "#isfj", "#YB"),
                description = "슈퍼스타트에서 만난 장도연",
            ),
            ListData(
//                image = "https://cdn.pixabay.com/photo/2020/04/06/13/37/coffee-5009730_1280.png",
                name = "마예지",
                tags = arrayListOf("#디자인", "#infj", "#YB"),
                description = "하남돼지집에서 만난 병아리",
            ),
        )
    }
}