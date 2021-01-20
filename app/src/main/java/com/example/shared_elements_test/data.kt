package com.example.shared_elements_test

data class Item(
    val name:String,
    val photo:Int
)

val mList = mutableListOf<Item>()
fun setData(){

    for(i in 0 until 5){
        mList.add(Item("汪汪汪汪汪汪汪",R.drawable.avatar))
        mList.add(Item("安安安安安安安",R.drawable.img01))
        mList.add(Item("RRRRRRRRRRR",R.drawable.img02))
    }
}