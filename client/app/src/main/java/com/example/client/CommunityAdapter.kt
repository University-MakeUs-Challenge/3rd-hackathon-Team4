package com.example.client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.client.databinding.ItemCommunityListBinding

class CommunityAdapter(private val communityList: ArrayList<Community>): RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(community: Community)
    }

    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CommunityAdapter.ViewHolder {
        val binding: ItemCommunityListBinding = ItemCommunityListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityAdapter.ViewHolder, position: Int) {
        holder.bind(communityList[position])
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(communityList[position])
        }
   }

    override fun getItemCount(): Int {
        return communityList.size
    }

    inner class ViewHolder(val binding: ItemCommunityListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(community: Community){
            binding.itemNum.text = community.num
            binding.itemTitleTv.text = community.title
            binding.itemContentTv.text = community.content
            binding.itemViewTv.text = community.viewNum
            binding.itemCommentTv.text = community.commentNum
        }
    }

}