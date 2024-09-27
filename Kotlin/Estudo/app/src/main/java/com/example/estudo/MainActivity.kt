package com.example.estudo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener{
            login()
        }
        binding.textCadastro.setOnClickListener{
            startActivity(Intent(this, Cadas::class.java))
        }
        binding.textEsqSenha.setOnClickListener{
            startActivity(Intent(this,NovaSenha::class.java))
        }
        binding.btnCalc.setOnClickListener{
            startActivity(Intent(this,Calc::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun login (){
        val email = binding.editEmail.text.toString().trim()
        val senha = binding.editSenha.text.toString().trim()
        if(email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(applicationContext,"E-mail ou senha não inseridos!", Toast.LENGTH_LONG).show()
        }else if((email != "vlconta.suporte@gmail.com" && !email.isEmpty()) || (senha != "123456" && !senha.isEmpty())){
            Toast.makeText(this,"E-mail ou Senha Inválido!",Toast.LENGTH_LONG).show()
        }else{
            startActivity(Intent(this,Inicial::class.java))
        }
    }

}