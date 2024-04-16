package com.emilio.firstapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emilio.firstapp.R
import com.emilio.firstapp.databinding.ListItemPessoaBinding
import com.emilio.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa) -> Unit):
    RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {

        private var pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
                    binding.tvNome.text = pessoa.nome
                    binding.tvIdade.text = pessoa.idade.toString() + " Anos"

                    binding.tvFaixaEtaria.text = pessoa.faixaE
// metodo 1 para imagem ou icone
                    if (pessoa.sexo == "Homem") {
                        binding.icMale.visibility = View.VISIBLE
                        binding.icFemale.visibility = View.GONE
                    }else if (pessoa.sexo == "Mulher"){
                        binding.icMale.visibility = View.GONE
                        binding.icFemale.visibility = View.VISIBLE
                    }
// metodo 2 para imagem ou icone
//                    if (pessoa.sexo == "Homem") {
//                        binding.icMale.setImageResource(R.drawable.ic_male)
//                    }else if (pessoa.sexo == "Mulher"){
//                        binding.icFemale.setImageResource(R.drawable.ic_female)
//                    }


                    binding.root.setOnClickListener{
                        clickListListener(pessoa)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }

    fun updatePessoa(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}