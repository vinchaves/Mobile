package com.example.estudo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudo.databinding.ActivityCalcBinding

class Calc : AppCompatActivity() {
    private lateinit var binding: ActivityCalcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding = ActivityCalcBinding.inflate(layoutInflater)

        val primeiroValor = binding.editTextText4.text.toString().toDouble()
        val segundoValor = binding.editTextText5.text.toString().toDouble()

        binding.btnSoma.setOnClickListener{
            binding.textRes.text = "${primeiroValor*segundoValor}"
        }
        binding.button4.setOnClickListener{
            binding.textRes.text = "${primeiroValor-segundoValor}"
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}