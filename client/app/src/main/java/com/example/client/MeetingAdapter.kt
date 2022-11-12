package com.example.client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.client.databinding.ItemMeetingDataBinding

class MeetingAdapter(private val dataList: ArrayList<MeetingData>): RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder>() {

    inner class MeetingViewHolder(private val binding: ItemMeetingDataBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data:MeetingData) {
            binding.itemImg.setImageResource(data.img)
            binding.itemTvFirst.text = data.mainTv
            binding.itemTvSecond.text = data.centerTv
            binding.itemTagTv1.text = data.tag1

        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }



    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder {
        val binding = ItemMeetingDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingViewHolder(binding)
    }
}