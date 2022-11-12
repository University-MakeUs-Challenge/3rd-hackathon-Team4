package com.example.client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.client.databinding.ViewItemLayoutBinding

class FeedAdapter(private val feedList: ArrayList<FeedData>): RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: FeedAdapter.ViewHolder, position: Int) {
        holder.bind(feedList[position])
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(feedList[position])
        }
    }
    interface MyItemClickListener{
        fun onItemClick(feed: FeedData)
    }

    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FeedAdapter.ViewHolder {
        val binding: ViewItemLayoutBinding = ViewItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }


    inner class ViewHolder(val binding: ViewItemLayoutBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(feed: FeedData){
                    Glide.with(binding.postImgView.context)
                        .load(feed.img)
                        .into(binding.postImgView)
        }
    }

}