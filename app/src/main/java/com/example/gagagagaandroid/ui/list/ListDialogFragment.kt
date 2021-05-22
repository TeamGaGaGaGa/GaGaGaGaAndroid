package com.example.gagagagaandroid.ui.list

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.gagagagaandroid.R
import com.example.gagagagaandroid.databinding.DialogListBinding

class ListDialogFragment : DialogFragment() {

    private var _binding: DialogListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDialogBackground()
        binding.close.setOnClickListener {
            dialog!!.dismiss()
        }
    }

    private fun setupDialogBackground() {
        val deviceWidth = Resources.getSystem().displayMetrics.widthPixels
        val dialogHorizontalMargin = (Resources.getSystem().displayMetrics.density * 30) * 2
        dialog!!.window!!.apply {
            setLayout(
                (deviceWidth - dialogHorizontalMargin).toInt(),
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawableResource(R.drawable.background_rectangle_radius_15_stroke_2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    class CustomDialogBuilder {
        private val dialog = ListDialogFragment()

        fun create(): ListDialogFragment {
            return dialog
        }
    }
}