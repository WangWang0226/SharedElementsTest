package com.example.shared_elements_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main2.*
import java.net.ContentHandler

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        ViewCompat.setTransitionName(imgv_avatar, getString(R.string.transitionName_image))
        ViewCompat.setTransitionName(tv_name, getString(R.string.transitionName_title))

        intent.extras?.let {
            val id = it.getInt("item_position")

            Glide.with(this)
                .load(mList[id].photo)
                .transform(CircleCrop())
                .into(imgv_avatar)
            tv_name.text = mList[id].name

        }



    }
}
