package com.choi.part3_ch02.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.choi.part3_ch02.R

@BindingAdapter(value = ["code_text","code_index"])
fun ImageView.setPin(codeText: CharSequence?, codeIndex:Int) {
    if (codeText!=null) {
        if (codeText.length>codeIndex) {
            setImageResource(R.drawable.baseline_circle_black_24)
        } else {
            setImageResource(R.drawable.baseline_circle_gray_24)
        }
    }
}