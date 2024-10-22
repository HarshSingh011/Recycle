package com.example.api_fetch

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(
    private val newsArrayList: List<News>,
    private val context: Activity
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myListener: onItemClickListener? = null

    interface onItemClickListener {
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = newsArrayList.size

    class MyViewHolder(itemView: View, listener: onItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        private val hTitle: TextView = itemView.findViewById(R.id.headingTitle)
        private val hImage: ShapeableImageView = itemView.findViewById(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener?.onItemClicking(adapterPosition)
            }
        }

        fun bind(news: News) {
            hTitle.text = news.newsHeading
            hImage.setImageResource(news.newsImage)
        }
    }
}
