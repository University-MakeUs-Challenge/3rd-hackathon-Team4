package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentCommunityBinding
import com.example.client.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private var feedList = ArrayList<FeedData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFeedBinding.inflate(inflater,container,false)

        feedList.apply {
            add(FeedData(R.drawable.turtle))
            add(FeedData(R.drawable.turtle2))
            add(FeedData(R.drawable.turtle3))
            add(FeedData(R.drawable.turtle4))
            add(FeedData(R.drawable.turtle5))
            add(FeedData(R.drawable.turtle6))
            add(FeedData(R.drawable.turtle7))
            add(FeedData(R.drawable.turtle8))
            add(FeedData(R.drawable.turtle9))
        }

        val feedAdapter = FeedAdapter(feedList)
        binding.rvFeed.adapter = feedAdapter
        binding.rvFeed.layoutManager = GridLayoutManager(context, 3)
        binding.rvFeed2.adapter = feedAdapter
        binding.rvFeed2.layoutManager = GridLayoutManager(context, 3)

        return binding.root
        return FragmentFeedBinding.inflate(layoutInflater).root
    }

}