package com.emilio.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emilio.firstapp.R
import com.emilio.firstapp.databinding.FragmentVerificaBinding

class VerificaFragment : Fragment() {
    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerificaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {
            var telefone = binding.edtTelefone.editableText.toString()
            if (telefone.length == 11) {
                binding.tvTelefone.text = "Telefone: ${telefone} está valido"
            } else {
                binding.tvTelefone.text = "Telefone: Invalido"
            }

            var email = binding.edtEmail.editableText.toString()
            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.text = "E-Mail: ${email} está valido"
            } else {
                binding.tvEmail.text = "E-Mail: E-mail invalido"}
        }
    }
}