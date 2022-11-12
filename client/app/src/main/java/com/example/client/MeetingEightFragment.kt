package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentMeetingEightBinding
import com.example.client.databinding.FragmentMeetingOneBinding

class MeetingEightFragment: Fragment() {

    private lateinit var  binding: FragmentMeetingEightBinding
    private var meetingList: ArrayList<MeetingData> = arrayListOf(
        MeetingData(R.drawable.ic_meeting_item_bike, "자전거 같이 탈 사람~!", "자전거 같이 타실 분~ 4명 모집합니다", "#제주도", "#자전거"),
        MeetingData(R.drawable.ic_meeting_item_bas, "제주에서 농구할 사람", "잠실에서 농구하실 분~ 4명 모집합니다", "#제주도", "#농구"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingEightBinding.inflate(inflater)
        binding.meetingRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,  false)
        binding.meetingRv.adapter = MeetingAdapter(meetingList)
        return binding.root
    }
}