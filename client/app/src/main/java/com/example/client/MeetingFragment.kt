package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.client.databinding.FragmentMeetingBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MeetingFragment : Fragment() {

    private lateinit var binding: FragmentMeetingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMeetingBinding.inflate(inflater, container, false)

        val meetingVPAdapter = MeetingVPAdapter(this)
        binding.vpMain.adapter = meetingVPAdapter

        val tabTitleArray = arrayOf(
            "전체",
            "서울",
            "경기도",
            "충청도",
            "경상도",
            "강원도",
            "전라도",
            "제주도",
        )



        TabLayoutMediator(binding.tabMain, binding.vpMain) {tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

        setTabItemMargin(binding.tabMain, 13)

        return binding.root

    }

    private fun setTabItemMargin(tabLayout: TabLayout, marginEnd: Int = 13) {
        for(i in 0 until 7) {
            val tabs = tabLayout.getChildAt(0) as ViewGroup
            for(i in 0 until tabs.childCount) {
                val tab = tabs.getChildAt(i)
                val lp = tab.layoutParams as LinearLayout.LayoutParams
                lp.marginEnd = marginEnd
                tab.layoutParams = lp
                tabLayout.requestLayout()
            }
        }
    }

}