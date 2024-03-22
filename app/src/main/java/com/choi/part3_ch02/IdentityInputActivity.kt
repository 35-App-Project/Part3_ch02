package com.choi.part3_ch02

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.choi.part3_ch02.databinding.ActivityIdentityInputBinding
import com.choi.part3_ch02.util.ViewUtil.hideKeyboard
import com.choi.part3_ch02.util.ViewUtil.setOnEditorActionListener
import com.choi.part3_ch02.util.ViewUtil.showKeyBoard
import com.choi.part3_ch02.util.ViewUtil.showKeyboardDelay

class IdentityInputActivity: AppCompatActivity() {

    private lateinit var binding : ActivityIdentityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityIdentityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        binding.nameEditText.showKeyboardDelay()
    }


    private fun initView() {
        binding.view=this
        with(binding) {
            nameEditText.setOnEditorActionListener(EditorInfo.IME_ACTION_NEXT) {
                birthdayLayout.isVisible=true
                birthdayEditText.showKeyBoard()
            }

            birthdayEditText.doAfterTextChanged {
                if (birthdayEditText.length() > 7) {
                    genderLayout.isVisible=true
                    birthdayEditText.hideKeyboard()
                }
            }

            genderChipGroup.setOnCheckedStateChangeListener {group, checkedIds ->
                if (!telecomLayout.isVisible) {
                    telecomLayout.isVisible=true
                }
            }

            telecomChipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
                if (!phoneLayout.isVisible) {
                    phoneLayout.isVisible=true
                    phoneEdit.showKeyBoard()
                }
            }

            phoneEdit.doAfterTextChanged {
                if (phoneEdit.length()>10) {
                    confirmButton.isVisible=true
                    phoneEdit.hideKeyboard()
                }
            }

            phoneEdit.setOnEditorActionListener(EditorInfo.IME_ACTION_DONE) {
                if(phoneEdit.length()>9) {
                    confirmButton.isVisible=true
                    phoneEdit.hideKeyboard()
                }
            }

        }
    }
}