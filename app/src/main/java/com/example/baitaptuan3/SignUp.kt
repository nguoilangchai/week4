package com.example.baitaptuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.baitaptuan3.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnSignUp.setOnClickListener {
            val email = binding.txtEmail.text.toString().trim()
            val passWord = binding.txtPassWord.text.toString().trim()

            viewModel.checkEmailAndPassword(email, passWord)
            listenerSuccessEvent()
            listenerErrorEvent()
        }
    }

    private fun listenerSuccessEvent(){
        viewModel.isSuccessEvent.observe(this){
            if(it){
                val email = binding.txtEmail.text.toString().trim()
                val passWord = binding.txtPassWord.text.toString().trim()
                val intent = Intent(this, Login::class.java)

                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, DataStore(email, passWord))
                intent.putExtras(bundle)
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent(){
        viewModel.isErrorEvent.observe(this){errMsg ->
//            val dialog = AlertDialog.Builder(this)
//            dialog.setTitle("Error")
//            dialog.setMessage(errMsg)
//            dialog.show()
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}