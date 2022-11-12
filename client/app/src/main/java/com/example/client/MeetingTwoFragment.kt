package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentMeetingOneBinding
import com.example.client.databinding.FragmentMeetingTwoBinding

class MeetingTwoFragment: Fragment() {
    private lateinit var  binding: FragmentMeetingTwoBinding

    private var meetingList: ArrayList<MeetingData> = arrayListOf(
        MeetingData(R.drawable.ic_meeting_item_bas, "잠실에서 농구할 사람", "잠실에서 농구하실 분~ 4명 모집합니다", "#서울", "#농구"),
        MeetingData(R.drawable.ic_meeting_item_soccer, "축구 3명 구해요", "같이 축구 하실 분~ 4명 모집합니다", "#서울", "#축구"),
        MeetingData(R.drawable.ic_meeting_item_run, "러닝 같이 해요!", "러닝하실 분~ 4명 모집합니다", "#서울", "#달리기"),

    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingTwoBinding.inflate(inflater)
        binding.meetingRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,  false)
        binding.meetingRv.adapter = MeetingAdapter(meetingList)
        return binding.root
    }
}