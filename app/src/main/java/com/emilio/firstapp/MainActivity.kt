package com.emilio.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emilio.firstapp.databinding.ActivityMainBinding
import com.emilio.firstapp.databinding.TelaLinearBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!


//    private var _bindingTelaLinear: TelaLinearBinding? = null
//    private val bindingTelaLinear: TelaLinearBinding get() = _bindingTelaLinear!!
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)


    binding.btnEnviar.setOnClickListener {
        var telefone = binding.edtTelefone.editableText.toString()
        if  (telefone.length == 11) {
            binding.tvTelefone.text = "Telefone: ${telefone} está valido"
        }else{
            binding.tvTelefone.text = "Telefone: Invalido"
        }

        var email = binding.edtEmail.editableText.toString()
        if (email.contains("@") && email.contains(".com") ) {
            binding.tvEmail.text = "E-Mail: ${email} está valido"
        }else{
        binding.tvEmail.text = "E-Mail: E-mail invalido"
        }
//
//        var nome = binding.edtNome.editableText.toString()
//        binding.tvNome.text =  "Nome: ${nome}"
//        val anoAtual = LocalDateTime.now().year
//        var idade = binding.edtAno.editableText.toString()
//        binding.tvAno.text =  "Idade: ${anoAtual - idade.toInt()}"


    }
}
}