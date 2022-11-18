package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentMeetingOneBinding
import com.example.client.databinding.FragmentMeetingThreeBinding
import com.example.client.databinding.FragmentMeetingTwoBinding

class MeetingThreeFragment: Fragment() {

    private lateinit var  binding: FragmentMeetingThreeBinding

    private var meetingList: ArrayList<MeetingData> = arrayListOf(
        MeetingData(R.drawable.ic_meeting_item_bas, "경기도에서 농구할 사람", "경기도에서 농구하실 분~ 4명 모집합니다", "#경기도", "#농구"),
        MeetingData(R.drawable.ic_meeting_item_soccer, "축구 3명 구해요", "같이 축구 하실 분~ 4명 모집합니다", "#경기도", "#축구"),

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingThreeBinding.inflate(inflater)
        binding.meetingRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,  false)
        binding.meetingRv.adapter = MeetingAdapter(meetingList)
        return binding.root
    }
}