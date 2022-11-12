package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentMeetingOneBinding
import com.example.client.databinding.FragmentMeetingSevenBinding
import com.example.client.databinding.FragmentMeetingSixBinding

class MeetingSevenFragment: Fragment() {

    private lateinit var  binding: FragmentMeetingSevenBinding
    private var meetingList: ArrayList<MeetingData> = arrayListOf(
        MeetingData(R.drawable.ic_meeting_item_soccer, "축구 3명 구해요", "같이 축구 하실 분~ 4명 모집합니다", "#전라도", "#축구"),
        MeetingData(R.drawable.ic_meeting_item_run, "러닝 같이 해요!", "러닝하실 분~ 4명 모집합니다", "#전라도", "#달리기"),
        MeetingData(R.drawable.ic_meeting_item_bike, "자전거 같이 탈 사람~!", "자전거 같이 타실 분~ 4명 모집합니다", "#전라도", "#자전거"),
        MeetingData(R.drawable.ic_meeting_item_bas, "잠실에서 농구할 사람", "잠실에서 농구하실 분~ 4명 모집합니다", "#전라도", "#농구"),
        MeetingData(R.drawable.ic_meeting_item_soccer, "축구 3명 구해요", "같이 축구 하실 분~ 4명 모집합니다", "#전라도", "#축구"),
        MeetingData(R.drawable.ic_meeting_item_run, "러닝 같이 해요!", "러닝하실 분~ 4명 모집합니다", "#전라도", "#달리기"),
        MeetingData(R.drawable.ic_meeting_item_bike, "자전거 같이 탈 사람~!", "자전거 같이 타실 분~ 4명 모집합니다", "#전라도", "#자전거"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingSevenBinding.inflate(inflater)
        binding.meetingRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,  false)
        binding.meetingRv.adapter = MeetingAdapter(meetingList)
        return binding.root
    }
}