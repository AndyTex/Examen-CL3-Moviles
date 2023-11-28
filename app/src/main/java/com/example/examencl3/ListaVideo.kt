package com.example.examencl3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examencl3.VideoRest.CustomAdapter
import com.example.examencl3.VideoRest.QuoteApi
import com.example.examencl3.VideoRest.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ListaVideo : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter

    private fun openVideoActivity(videoUrl: String) {
        val intent = Intent(this, VideoActivity::class.java)
        intent.putExtra("Url", videoUrl)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_video)
        recyclerView = findViewById(R.id.rv_list_video)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CustomAdapter(emptyList()) { videoUrl ->
            openVideoActivity(videoUrl)
        }
        recyclerView.adapter = adapter
        val Video = RetrofitHelper.getRetroFitInstance().create(QuoteApi::class.java)
        GlobalScope.launch {
            val response = Video.getVideos()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val categories = body.categories
                    val videos = categories.flatMap { it.videos }
                    runOnUiThread {
                        adapter.setData(videos)
                    }
                }
            }
        }
    }
}