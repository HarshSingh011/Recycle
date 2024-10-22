package com.example.api_fetch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstPage : AppCompatActivity() {

    private val myRecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val newsArrayList by lazy { ArrayList<cars>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        supportActionBar?.hide()

        val newsImageArray = arrayOf(
            R.drawable.ast, R.drawable.mal, R.drawable.lambo,
            R.drawable.por, R.drawable.kon, R.drawable.maje,
            R.drawable.pagani, R.drawable.ford, R.drawable.bug,
            R.drawable.far, R.drawable.corvet
        )

        val newsHeadingArray = resources.getStringArray(R.array.cars_headings)
        val newsContentArray = resources.getStringArray(R.array.cars_content)

        newsArrayList.addAll(newsImageArray.indices.map { index ->
            cars(newsHeadingArray[index], newsImageArray[index], newsContentArray[index])
        })

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                val news = newsArrayList[position]
                val intent = Intent(this@FirstPage, detail::class.java).apply {
                    putExtra("heading", news.newsHeading)
                    putExtra("imageId", news.newsImage)
                    putExtra("newscontent", news.newsContent)
                }
                startActivity(intent)
            }
        })
    }
}
