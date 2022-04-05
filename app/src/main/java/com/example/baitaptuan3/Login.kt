package com.example.baitaptuan3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.baitaptuan3.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val bundle = intent.extras
        bundle?.let {
            val dataStore : DataStore? = it.getParcelable(Constants.KEY_USER)

            dataStore?.let {
//                binding.txtInfo.text = "${it.username} --- ${it.password} "
                var tempUser : String = "${it.username}"
                var tempPass : String = "${it.password}"

                binding.btnLogin.setOnClickListener {
                    var count : Int = 0;
                    var buffer : String = ""
                    if(("${binding.txtUserNameLogin.text}".compareTo(tempUser))!=0)
                    {
                        buffer += "Email không tồn tại\n"
                    }
                    if(("${binding.txtPassWordLogin.text}".compareTo(tempPass))!=0)
                    {
                        buffer += "Pass không đúng"
                    }
                    if(buffer.length > 0)
                        Toast.makeText(this, buffer, Toast.LENGTH_SHORT).show()
                    else {
//                        Toast.makeText(this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show()

                        val email = binding.txtUserNameLogin.text.toString().trim()
                        val passWord = binding.txtPassWordLogin.text.toString().trim()

                        val intent = Intent(this, Profile::class.java)

                        val bundle = Bundle()
                        bundle.putParcelable(Constants.KEY_USER, DataStore(email, passWord))
                        intent.putExtras(bundle)

                        startActivity(intent)
                    }
                }


            }

        }
    }
}