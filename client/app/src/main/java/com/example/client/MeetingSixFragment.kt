package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentMeetingFiveBinding
import com.example.client.databinding.FragmentMeetingOneBinding
import com.example.client.databinding.FragmentMeetingSixBinding

class MeetingSixFragment: Fragment() {

    private lateinit var  binding: FragmentMeetingSixBinding
    private var meetingList: ArrayList<MeetingData> = arrayListOf(
        MeetingData(R.drawable.ic_meeting_item_run, "러닝 같이 해요!", "러닝하실 분~ 4명 모집합니다", "#강원도", "#달리기"),

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingSixBinding.inflate(inflater)
        binding.meetingRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,  false)
        binding.meetingRv.adapter = MeetingAdapter(meetingList)
        return binding.root
    }
}