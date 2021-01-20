package com.example.shared_elements_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.viewholder.view.*

class MyAdapter(val context:Context):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var list = listOf<Item>()

    var mClickListener:(itemView:View, position:Int)-> Unit = { itemView, position ->  }

    inner class MyViewholder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tv = itemView.textView
        val imgv = itemView.imageView
        val rootview = itemView.rootview_viewholder


        fun bind(item:Item){
            tv.text = item.name
            Glide.with(context)
                .load(item.photo)
                .transform(CircleCrop())
                .into(imgv)

        }
    }

    override fun getItemCount(): Int  = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.viewholder,parent,false)
        return MyViewholder(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyViewholder) {
            holder.bind(list[position])
            holder.rootview.setOnClickListener {
                mClickListener.invoke(holder.itemView,position)
            }
        }
    }


    fun updateList(list:List<Item>){
        this.list = list
    }
}