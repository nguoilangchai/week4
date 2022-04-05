package com.example.baitaptuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.baitaptuan3.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        val bundle = intent.extras
        bundle?.let {
            val dataStore : DataStore? = it.getParcelable(Constants.KEY_USER)

            dataStore?.let {
//                binding.txtFull.text = "${it.username} --- ${it.password} "
                binding.txtFull.text = "${it.username}"
                binding.txtPass2.text = "${it.password}"
            }

            binding.btnDetailProfile.setOnClickListener {
                val intent = Intent(this, ShowMenu::class.java)
                startActivity(intent)
            }
    }
}}