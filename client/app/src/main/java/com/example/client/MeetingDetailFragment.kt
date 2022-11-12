package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.client.databinding.FragmentMeetingDetailBinding
import com.example.client.databinding.FragmentMeetingFiveBinding
import com.example.client.databinding.FragmentMeetingOneBinding

class MeetingDetailFragment: Fragment() {

    private lateinit var  binding: FragmentMeetingDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingDetailBinding.inflate(inflater)

        binding.meetingTitle.text = getMeetTitle()
        binding.meetingDesc.text = getMeetContent()

        return binding.root
    }

    private fun getMeetTitle(): String? {
        val sharedPreferences =
            activity?.getSharedPreferences("title", AppCompatActivity.MODE_PRIVATE)
        return sharedPreferences!!.getString("title", null)
    }

    private fun getMeetContent(): String? {
        val sharedPreferences =
            activity?.getSharedPreferences("content", AppCompatActivity.MODE_PRIVATE)
        return sharedPreferences!!.getString("content", null)
    }

}