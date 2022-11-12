package com.example.client

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MeetingVPAdapter(fragmentActivity: MeetingFragment): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 8

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MeetingOneFragment()
            1 -> MeetingTwoFragment()
            2 -> MeetingThreeFragment()
            3 -> MeetingFourFragment()
            4 -> MeetingFiveFragment()
            5 -> MeetingSixFragment()
            6 -> MeetingSevenFragment()
            7 -> MeetingEightFragment()
            else -> MeetingOneFragment()
        }
    }

}