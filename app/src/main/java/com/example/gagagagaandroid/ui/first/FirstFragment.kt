package com.example.gagagagaandroid.ui.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gagagagaandroid.R
import com.example.gagagagaandroid.api.RequestFriendData
import com.example.gagagagaandroid.api.ResponseFriendData
import com.example.gagagagaandroid.api.ServiceCreator
import com.example.gagagagaandroid.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.properties.Delegates

class FirstFragment : Fragment() {
    private lateinit var name: String
    private lateinit var part: String
    private lateinit var soptYear: String
    private lateinit var mbti: String
    private lateinit var question1: String
    private lateinit var question2: String
    private lateinit var face: String
    private lateinit var place: String
    private var talkMode by Delegates.notNull<Boolean>()
    private var image = "src"
    private var tmi = "src"

    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setScrollEvent(binding)


        binding.chipGroupPart.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.chipPlan.id -> {
                    changePlan(binding)
                }
                binding.chipDesign.id -> {
                    changeDesign(binding)
                }

                binding.chipIos.id  -> {
                    changeDevelop(binding)
                }

                binding.chipAndroid.id  -> {
                    changeDevelop(binding)
                }

                binding.chipServer.id  -> {
                    changeDevelop(binding)
                }

                binding.chipWeb.id  -> {
                    changeDevelop(binding)
                }
            }
        }

        binding.btnAdd.setOnClickListener {
            name = binding.etWhatName.text.toString()
            mbti = binding.etMbti.text.toString()
            face = binding.etCommonQuestion1.text.toString()
            place = binding.etCommonQuestion2.text.toString()

            when (binding.chipGroupYbOb.checkedChipId) {
                binding.chipYb.id -> soptYear = binding.chipYb.text.toString()
                binding.chipOb.id -> soptYear = binding.chipOb.text.toString()
                else -> Toast.makeText(requireContext(), "선택하지 않은 부분이 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }

            when (binding.chipGroupPartQuestion1.checkedChipId) {
                binding.chipPartCheckYes.id -> question1 = binding.chipPartCheckYes.text.toString()
                binding.chipPartCheckNo.id -> question1 = binding.chipPartCheckNo.text.toString()
                else -> Toast.makeText(requireContext(), "선택하지 않은 부분이 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }

            when (binding.chipGroupPartQuestion2.checkedChipId) {
                binding.chipNightCoding.id -> question2 = binding.chipNightCoding.text.toString()
                binding.chipCoding.id -> question2 = binding.chipCoding.text.toString()
                else -> Toast.makeText(requireContext(), "선택하지 않은 부분이 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }

            when (binding.chipGroupTalkMode.checkedChipId) {
                binding.chipTalkModeOn.id -> talkMode = true
                binding.chipTalkModeOff.id -> talkMode = false
                else -> Toast.makeText(requireContext(), "선택하지 않은 부분이 있습니다", Toast.LENGTH_SHORT)
                    .show()
            }

            val requestFriendData = RequestFriendData(
                name = name,
                part = part,
                mbti = mbti,
                image = image,
                place = place,
                face = face,
                banmo = talkMode,
                answer1 = question1,
                answer2 = question2,
                ybob = soptYear,
                tmi = tmi
            )

            val call = ServiceCreator.soptService.postAddFriend(requestFriendData)
            call.enqueue(object : retrofit2.Callback<ResponseFriendData> {
                override fun onResponse(
                    call: Call<ResponseFriendData>,
                    response: Response<ResponseFriendData>
                ) {
                    if (response.body()?.success == true) {
                        Log.d("test", "성공")
                        Toast.makeText(
                            requireContext(),
                            response.body()?.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseFriendData>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("test", "실패")
                }
            })

            Log.d(
                "test",
                name + " " + part + " " + soptYear + " " + mbti + " " + question1 + " " + question2 + " " + face + " " + place + " " + talkMode
            )
        }
    }


    private fun setScrollEvent(binding: FragmentFirstBinding) {
        with(binding) {
            scrollContainer.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                val scrollLength = scrollContainer.getChildAt(0).height - scrollContainer.height

                scrollProgressBar.apply {
                    max = scrollLength
                    progress = scrollY
                }
            }
        }
    }

    private fun changeDevelop(binding: FragmentFirstBinding) {
        binding.tvPartMain.text = "개발 파트"
        binding.tvPartMainQuestion.text = "뭐라꼬? \n니 개발자가?"
        binding.tvPartQuestion1.text = "개발 실력은 체크셔츠에서 나오는거 인정?! \n체크셔츠가 옷장에 쌓여 있을까요?"
        binding.chipPartCheckYes.text = "철이 없었죠... 체크셔츠가 많으면 코딩을 잘 할 수 있을거라 생각한게.."
        binding.chipPartCheckNo.text = "체크셔츠는 그냥 체크셔츠일 뿐. 오해하지 말자.!"
        binding.tvPartQuestion2.text = "해뜨면 눈감는 개발자?!\n 이 사람은 밤코일까요, 낮코일까요?\""
        binding.chipNightCoding.text = "나는 부엉부엉 부엉이 밤코"
        binding.chipCoding.text = "일찍 일어나는 새가 더 배부른 법이지! 나는 낮코"
        part = binding.chipDesign.text.toString()
        binding.clPartQuestion.visibility = View.VISIBLE
    }

    private fun changeDesign(binding: FragmentFirstBinding) {
        binding.tvPartMain.text = "디자인 파트"
        binding.tvPartMainQuestion.text = "뭐라꼬? \n니 디자이너가?"
        binding.tvPartQuestion1.text = "디자이너 하면 갬성이죠.. \n그 사람, 몽상가 재질일까요?"
        binding.tvPartQuestion1.text = "기획에는 TJ만 있을거 같죠? \n얼마나 계획적인 사람일까요?"
        binding.chipPartCheckYes.text = "당연히 몽상을 해야 디자인을 하죠. YES!!!"
        binding.chipPartCheckNo.text = "몽상하면 디자인이라는 고정관념을 버려주세요. NO!!!"
        binding.tvPartQuestion2.text = "인스타 한번 들어갔을 뿐인데 감성 폴폴 \n컨셉 인스타를 하고 있을까요?"
        binding.chipNightCoding.text = "당연히 인스타는 감성을 위해 하는거 아니겠어요...?"
        binding.chipCoding.text = "인스타는 그냥 내 마구마구 기록장! 뀨?!"
        part = binding.chipDesign.text.toString()
        binding.clPartQuestion.visibility = View.VISIBLE
    }

    private fun changePlan(binding: FragmentFirstBinding) {
        binding.tvPartMain.text = "기획 파트"
        binding.tvPartMainQuestion.text = "뭐라꼬? \n니 기획자가?"
        binding.tvPartQuestion1.text = "기획에는 TJ만 있을거 같죠? \n얼마나 계획적인 사람일까요?"
        binding.chipPartCheckYes.text = "계획하는일이 세상에서 제일 재밌어!"
        binding.chipPartCheckNo.text = "계획? 나는 그런거 몰라유"
        binding.tvPartQuestion2.text = "솝트의 꽃은 앱잼! \nPM에 나갈것 같은가요?"
        binding.chipNightCoding.text = "PM아니면 뭘 하죠?! 앱잼을 즐기려면 PM을 해야한다구욧!"
        binding.chipCoding.text = "앱잼... 무셔... 앱잼... 몰라.... TI도 좋아......"
        part = binding.chipPlan.text.toString()
        binding.clPartQuestion.visibility = View.VISIBLE
    }
}