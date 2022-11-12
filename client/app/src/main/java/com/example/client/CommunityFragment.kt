package com.example.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.client.databinding.FragmentCommunityBinding

class CommunityFragment : Fragment() {

    private lateinit var binding: FragmentCommunityBinding
    private var communityList = ArrayList<Community>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCommunityBinding.inflate(inflater,container,false)

        binding.constraintLayout2.bringToFront()
        communityList.apply {
            add(
                Community(
                    "1",
                    "잠실에서 농구하실 분~", "잠실에서 농구하실 분~ 4명 모집합니다. 자세한 장소는\n" +
                            "미정이고 관심있으신 분들은 댓글 부탁드려요~", "450", "21"
                )
            )
            add(
                Community(
                    "2",
                    "운동 루틴 추천 부탁드려요", "헬린이라 잘 모르는데, 유튜버나 루틴 추천해주실 수 있을\n" +
                            "까요?ㅜㅜㅜㅜ 부탁드립니다.", "320", "10"
                )
            )

            add(
                Community(
                    "3",
                    "덤벨 브랜드 추천 좀", "손 안 미끄러지는 거로 사고 싶은데 가격대는 얼마가\n" +
                            "괜찮은지 모르겠네요. 추천 좀 부탁드려요.", "180", "7"
                )
            )

            add(
                Community(
                    "4",
                    "헬스장 1년 or 6개월?",
                    "1년이 훨씬 싼데 내가 제대로 다닐지 모르겠음\n" +
                            "어떡할까요", "42", "17"
                )
            )
        }

        val communityAdapter = CommunityAdapter(communityList)
        binding.communityRv.adapter = communityAdapter
        binding.communityRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

}