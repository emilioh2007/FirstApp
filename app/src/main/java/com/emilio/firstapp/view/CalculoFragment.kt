package com.emilio.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.emilio.firstapp.R
import com.emilio.firstapp.databinding.ActivityMainBinding
import com.emilio.firstapp.databinding.FragmentCalculoBinding
import java.time.LocalDateTime

class CalculoFragment : Fragment() {

    private var _binding: FragmentCalculoBinding? = null
    private val binding:  FragmentCalculoBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnconcluir.setOnClickListener {

            val nome = binding.edtNome.editableText.toString()

            binding.tvNome.text = "Nome: ${nome}"

            val anoAtual = LocalDateTime.now().year
            val idade = binding.edtAno.editableText.toString()

            binding.tvAno.text = "Idade: ${anoAtual - idade.toInt()}"

        }
    }
}