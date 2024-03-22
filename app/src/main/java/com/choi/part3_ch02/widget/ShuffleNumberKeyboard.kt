package com.choi.part3_ch02.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.GridLayout
import android.widget.TextView
import androidx.core.view.children
import com.choi.part3_ch02.databinding.WidgetShuffleNumberKeyboardBinding
import kotlin.random.Random

class ShuffleNumberKeyboard @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    GridLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var _binding: WidgetShuffleNumberKeyboardBinding? = null
    val binding
        get() = _binding!!

    private var listener : KeyPadListener?=null


    init {
        _binding = WidgetShuffleNumberKeyboardBinding.inflate(
            LayoutInflater.from(context),
            this, true
        )
        binding.view=this
        binding.clickListener=this
        shuffle()
    }

    // view를 직접 관리 해야 한다
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        _binding=null
    }

    // 랜덤으로 섞기
    private fun shuffle() {
        val keyNumberArray = ArrayList<String>()
        for(i in 0..9) {
            keyNumberArray.add(i.toString())
        }

        binding.gridLayout.children.forEach {view->
            if(view is TextView && view.tag!=null) {
                val randIndex= Random.nextInt(keyNumberArray.size)
                view.text=keyNumberArray[randIndex]
                keyNumberArray.removeAt(randIndex)
            }
        }
    }

    fun setKeyPadListener(keyPadListener: KeyPadListener) {
        this.listener=keyPadListener
    }

    fun onClickDelete() {
        listener?.onClickDelete()
    }

    fun onClickDone() {
        listener?.onClickDone()
    }

    override fun onClick(keyPad: View) {
        if (keyPad is TextView && keyPad.tag!=null) {
            listener?.onClickNum(keyPad.text.toString())
        }
    }

    interface KeyPadListener {
        fun onClickNum(num : String)
        fun onClickDelete()
        fun onClickDone()
    }
}