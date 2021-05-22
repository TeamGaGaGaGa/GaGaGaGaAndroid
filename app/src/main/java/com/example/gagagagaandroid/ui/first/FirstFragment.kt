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

        binding.btnPlan.setOnClickListener {
            binding.btnPlan.setBackgroundResource(R.drawable.line_border_fill)
            binding.tvPartMain.text = "기획 파트"
            binding.tvPartMainQuestion.text = "뭐라꼬? \n니 기획자가?"
            binding.tvPartQuestion1.text = "기획에는 TJ만 있을거 같죠? \n얼마나 계획적인 사람일까요?"
            binding.btnPartCheckYes.text = "계획하는일이 세상에서 제일 재밌어!"
            binding.btnPartCheckNo.text = "계획? 나는 그런거 몰라유"
            binding.tvPartQuestion2.text = "솝트의 꽃은 앱잼! \nPM에 나갈것 같은가요?"
            binding.btnNightCoding.text = "PM아니면 뭘 하죠?! 앱잼을 즐기려면 PM을 해야한다구욧!"
            binding.btnCoding.text = "앱잼... 무셔... 앱잼... 몰라.... TI도 좋아......"
            part = binding.btnPlan.text.toString()
            binding.clPartQuestion.visibility = View.VISIBLE
        }

        binding.btnDesign.setOnClickListener {
            binding.btnDesign.setBackgroundResource(R.drawable.line_border_fill)
            binding.tvPartMain.text = "디자인 파트"
            binding.tvPartMainQuestion.text = "뭐라꼬? \n니 디자이너가?"
            binding.tvPartQuestion1.text = "디자이너 하면 갬성이죠.. \n그 사람, 몽상가 재질일까요?"
            binding.tvPartQuestion1.text = "기획에는 TJ만 있을거 같죠? \n얼마나 계획적인 사람일까요?"
            binding.btnPartCheckYes.text = "당연히 몽상을 해야 디자인을 하죠. YES!!!"
            binding.btnPartCheckNo.text = "몽상하면 디자인이라는 고정관념을 버려주세요. NO!!!"
            binding.tvPartQuestion2.text = "인스타 한번 들어갔을 뿐인데 감성 폴폴 \n컨셉 인스타를 하고 있을까요?"
            binding.btnNightCoding.text = "당연히 인스타는 감성을 위해 하는거 아니겠어요...?"
            binding.btnCoding.text = "인스타는 그냥 내 마구마구 기록장! 뀨?!"
            part = binding.btnDesign.text.toString()
            binding.clPartQuestion.visibility = View.VISIBLE
        }

        binding.btnWeb.setOnClickListener {
            binding.btnWeb.setBackgroundResource(R.drawable.line_border_fill)
            binding.clPartQuestion.visibility = View.VISIBLE
            part = binding.btnWeb.text.toString()

        }

        binding.btnServer.setOnClickListener {
            binding.btnServer.setBackgroundResource(R.drawable.line_border_fill)
            binding.clPartQuestion.visibility = View.VISIBLE
            part = binding.btnServer.text.toString()
        }

        binding.btnIos.setOnClickListener {
            binding.btnIos.setBackgroundResource(R.drawable.line_border_fill)
            binding.clPartQuestion.visibility = View.VISIBLE
            part = binding.btnIos.text.toString()
        }

        binding.btnAndroid.setOnClickListener {
            binding.btnAndroid.setBackgroundResource(R.drawable.line_border_fill)
            binding.clPartQuestion.visibility = View.VISIBLE
            part = binding.btnAndroid.text.toString()

        }

        binding.btnOb.setOnClickListener {
            binding.btnOb.setBackgroundResource(R.drawable.line_border_fill)
            soptYear = binding.btnOb.text.toString()
        }

        binding.btnYb.setOnClickListener {
            binding.btnYb.setBackgroundResource(R.drawable.line_border_fill)
            soptYear = binding.btnYb.text.toString()
        }

        binding.btnPartCheckYes.setOnClickListener {
            binding.btnPartCheckYes.setBackgroundResource(R.drawable.line_border_fill)
            question1 = binding.btnPartCheckYes.text.toString()
        }

        binding.btnPartCheckNo.setOnClickListener {
            binding.btnPartCheckNo.setBackgroundResource(R.drawable.line_border_fill)
            question1 = binding.btnPartCheckNo.text.toString()
        }

        binding.btnNightCoding.setOnClickListener {
            binding.btnNightCoding.setBackgroundResource(R.drawable.line_border_fill)
            question2 = binding.btnNightCoding.text.toString()
        }

        binding.btnCoding.setOnClickListener {
            binding.btnCoding.setBackgroundResource(R.drawable.line_border_fill)
            question2 = binding.btnCoding.text.toString()
        }

        binding.btnAskYes.setOnClickListener {
            binding.btnAskYes.setBackgroundResource(R.drawable.line_border_fill)
            talkMode = true
        }

        binding.btnAskNo.setOnClickListener {
            binding.btnAskNo.setBackgroundResource(R.drawable.line_border_fill)
            talkMode = false
        }

        binding.btnAdd.setOnClickListener {
            name = binding.etWhatName.text.toString()
            mbti = binding.etMbti.text.toString()
            face = binding.etCommonQuestion1.text.toString()
            place = binding.etCommonQuestion2.text.toString()

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
                        Toast.makeText(requireContext(), response.body()?.message, Toast.LENGTH_SHORT).show()
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