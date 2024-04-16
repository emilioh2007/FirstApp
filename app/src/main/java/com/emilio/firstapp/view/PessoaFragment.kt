package com.emilio.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.emilio.firstapp.databinding.FragmentAllPessoasBinding
import com.emilio.firstapp.databinding.FragmentPessoaBinding
import com.emilio.firstapp.service.model.Pessoa
import com.emilio.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentPessoaBinding? = null
    private val binding:  FragmentPessoaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPessoaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnconcluir.setOnClickListener {
            val nome = binding.edtNome.editableText.toString()
            var anoNascimento = binding.edtAno.editableText.toString()

            var sexo = ""

            var faixaE = ""



// Nome
            if (nome != "" && anoNascimento != "" &&
                binding.btnMasculino.isChecked || binding.btnFeminino.isChecked){


// Sexo
                if (binding.btnMasculino.isChecked){
                    sexo = "Homem"
                }else{
                    sexo = "Mulher"
                }


                binding.tvNome.text = "Nome: ${nome}"

// Idade
                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()

                binding.tvAno.text = "Idade: ${idade}"

// Faixa etaria
                when (idade) {
                    in 0..12 -> faixaE = "Infantil"
                    in 13..17 -> faixaE = "Adolecente"
                    in 18..64 -> faixaE = "Adulto"
                    in 65..145 -> faixaE = "Idoso"
                    else -> faixaE = "Voçê está mentindo"
                }


// val da lista

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade,
                    sexo = sexo,
                    faixaE = faixaE
                )

                viewModel.insert(pessoa)

                binding.edtNome.editableText.clear()
                binding.edtAno.editableText.clear()

                // Voltar pra tela anterior
                findNavController().navigateUp()
            } else{
                Toast.makeText(requireContext(), "Digite od dados necessarios corretamente", Toast.LENGTH_LONG).show()
            }

        }


    }
}