package com.emilio.firstapp.view

import android.app.AlertDialog
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
import com.emilio.firstapp.databinding.FragmentPessoaDetailBinding
import com.emilio.firstapp.service.model.Pessoa
import com.emilio.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaDetailFragment : Fragment() {
    // chamar a view model
    private val viewModel: PessoaViewModel by viewModels()

    // criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null
    private val binding:  FragmentPessoaDetailBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // configurar  binding
        _binding = FragmentPessoaDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    // chamar a função onViewCreatd onde vamos implementar o codigo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // pegar o id da pessoa que foi enviado pela AllPessoaFragment
        // setar a pessoa para ser carregada
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))

        }

        // carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner) { pessoa ->
            binding.textNomeDetail.text = pessoa.nome
            binding.textAnoDetail.text = pessoa.idade.toString() + " anos"
            binding.textFaixaEtariaDetail.text = pessoa.faixaE

            if (pessoa.sexo == "Homem"){
                binding.icMale.visibility = View.VISIBLE
                binding.icFemale.visibility = View.INVISIBLE
            }else {
                binding.icMale.visibility = View.INVISIBLE
                binding.icFemale.visibility = View.VISIBLE
            }
        }

        }
}