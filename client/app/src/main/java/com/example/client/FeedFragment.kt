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
            add(FeedData(R.drawable.bell))
            add(FeedData(R.drawable.bell))
            add(FeedData(R.drawable.bell))
            add(FeedData(R.drawable.bell))
            add(FeedData(R.drawable.bell))
            add(FeedData(R.drawable.bell))
            add(FeedData(R.drawable.bell))
        }

        val feedAdapter = FeedAdapter(feedList)
        binding.rvFeed.adapter = feedAdapter
        binding.rvFeed.layoutManager = GridLayoutManager(context, 3)

        return binding.root
    }

}