package com.example.examencl3.VideoRest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examencl3.R


class CustomAdapter(private var mList: List<Video>, private val onItemClick: (String) -> Unit): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.lbl_titulo)
        val subtitulo: TextView = itemView.findViewById(R.id.lbl_subtitulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = mList[position]
        holder.titulo.text = itemViewModel.title
        holder.subtitulo.text = itemViewModel.subtitle
        holder.itemView.setOnClickListener {
            val videoUrl = mList[position].sources.firstOrNull()
            if (videoUrl != null) {
                onItemClick(videoUrl)
            }
        }
    }

    fun setData(newList: List<Video>) {
        mList = newList
        notifyDataSetChanged()
    }
}
