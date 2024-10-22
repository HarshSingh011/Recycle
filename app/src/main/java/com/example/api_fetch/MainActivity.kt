package com.example.api_fetch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val myRecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
    private val newsArrayList by lazy { ArrayList<News>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val newsImageArray = arrayOf(
            R.drawable.ast, R.drawable.mal, R.drawable.lambo,
            R.drawable.por, R.drawable.kon, R.drawable.maje
        )

        val newsHeadingArray = resources.getStringArray(R.array.news_headings)
        val newsContentArray = resources.getStringArray(R.array.news_content)

        newsArrayList.addAll(newsImageArray.indices.map { index ->
            News(newsHeadingArray[index], newsImageArray[index], newsContentArray[index])
        })

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClicking(position: Int) {
                val news = newsArrayList[position]
                val intent = Intent(this@MainActivity, detail::class.java).apply {
                    putExtra("heading", news.newsHeading)
                    putExtra("imageId", news.newsImage)
                    putExtra("newscontent", news.newsContent)
                }
                startActivity(intent)
            }
        })
    }
}
