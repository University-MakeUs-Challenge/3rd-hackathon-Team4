package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.client.databinding.FragmentMeetingBinding
import com.example.client.databinding.FragmentMypageBinding
import com.example.client.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var  binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater)

        return binding.root

    }

}