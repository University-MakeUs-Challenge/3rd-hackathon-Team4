package com.example.client

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentMeetingOneBinding

class MeetingOneFragment: Fragment() {
    private lateinit var  binding: FragmentMeetingOneBinding
    private lateinit var meetingAdapter: MeetingAdapter

    private var meetingList: ArrayList<MeetingData> = arrayListOf(
        MeetingData(R.drawable.ic_meeting_item_bas, "잠실에서 농구할 사람", "잠실에서 농구하실 분~ 4명 모집합니다", "#서울", "#농구"),
        MeetingData(R.drawable.ic_meeting_item_soccer, "축구 3명 구해요", "같이 축구 하실 분~ 4명 모집합니다", "#서울", "#축구"),
        MeetingData(R.drawable.ic_meeting_item_run, "러닝 같이 해요!", "러닝하실 분~ 4명 모집합니다", "#충청도", "#달리기"),
        MeetingData(R.drawable.ic_meeting_item_bike, "자전거 같이 탈 사람~!", "자전거 같이 타실 분~ 4명 모집합니다", "#충청도", "#자전거"),
        MeetingData(R.drawable.ic_meeting_item_bas, "잠실에서 농구할 사람", "잠실에서 농구하실 분~ 4명 모집합니다", "#경기도", "#농구"),
        MeetingData(R.drawable.ic_meeting_item_soccer, "축구 3명 구해요", "같이 축구 하실 분~ 4명 모집합니다", "#경기도", "#축구"),
        MeetingData(R.drawable.ic_meeting_item_run, "러닝 같이 해요!", "러닝하실 분~ 4명 모집합니다", "#경기도", "#달리기"),
        MeetingData(R.drawable.ic_meeting_item_bike, "자전거 같이 탈 사람~!", "자전거 같이 타실 분~ 4명 모집합니다", "#제주도", "#자전거"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingOneBinding.inflate(inflater)

        binding.meetingRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,  false)
        meetingAdapter = MeetingAdapter(meetingList)
        binding.meetingRv.adapter = meetingAdapter


        //리사이클러뷰의 각각 아이템을 클릭했을 때
        meetingAdapter.setMyItemClickListener(object: MeetingAdapter.MyItemClickListener{
            override fun onItemClick(meetingData: MeetingData) {
                Log.d("meetingData",meetingData.toString())

                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, MeetingDetailFragment())
                    .commitAllowingStateLoss()

                saveMeetTitle(meetingData.mainTv)
                saveMeetContent(meetingData.centerTv)
                saveMeetImage(meetingData.img)
            }
        })

        return binding.root
    }

    private fun saveMeetTitle(title: String) {
        val sharedPreferences = activity?.getSharedPreferences("title", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putString("title", title)
        editor.apply()
    }

    private fun saveMeetContent(content: String) {
        val sharedPreferences = activity?.getSharedPreferences("content", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putString("content", content)
        editor.apply()
    }

    private fun saveMeetImage(img: Int) {
        val sharedPreferences = activity?.getSharedPreferences("img", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putInt("img", img)
        editor.apply()
    }
}