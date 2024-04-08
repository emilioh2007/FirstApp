package com.emilio.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.emilio.firstapp.databinding.FragmentCalculoBinding
import com.emilio.firstapp.service.model.Pessoa
import com.emilio.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

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
            var anoNascimento = binding.edtAno.editableText.toString()

            if (nome != "" && anoNascimento != ""){

                binding.tvNome.text = "Nome: ${nome}"


                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()

                binding.tvAno.text = "Idade: ${idade}"

//            binding.tvAno.text = "Idade: ${anoAtual - anoNasc.toInt()}"

                val pessoa = Pessoa(
                    nome = nome,
                    idade = idade
                )

                viewModel.insert(pessoa)

                binding.edtNome.editableText.clear()
                binding.edtAno.editableText.clear()

            } else{
                Toast.makeText(requireContext(), "Digite od dados necessarios", Toast.LENGTH_LONG).show()
            }

        }
    }
}