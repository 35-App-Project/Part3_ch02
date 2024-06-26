package com.choi.part3_ch02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choi.part3_ch02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view=this
    }

    fun openShuffle() {
        startActivity(Intent(this,PinActivity::class.java))
    }

    fun openVerifyOtp() {
        startActivity(Intent(this,IdentityInputActivity::class.java))
    }
}