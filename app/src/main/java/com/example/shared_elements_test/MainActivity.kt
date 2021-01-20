package com.example.shared_elements_test

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
// Rename the Pair class from the Android framework to avoid a name clash
import android.util.Pair as UtilPair

class MainActivity : AppCompatActivity() {

    lateinit var adapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData()
        adapter = MyAdapter(this)
        adapter.updateList(mList)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter



        adapter.mClickListener = { itemView, position ->

            val intent = Intent(this,Main2Activity::class.java)
            intent.putExtra("item_position",position)

            val options = ActivityOptions.makeSceneTransitionAnimation(this,
                UtilPair.create(itemView.findViewById(R.id.imageView) as View,getString(R.string.transitionName_image)),
                UtilPair.create(itemView.findViewById(R.id.textView) as View,getString(R.string.transitionName_title)))
            startActivity(intent,options.toBundle())

        }



    }
}
