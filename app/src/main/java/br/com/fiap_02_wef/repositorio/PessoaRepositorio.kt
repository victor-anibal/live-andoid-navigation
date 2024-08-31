package br.com.fiap_02_wef.repositorio
import android.content.Context
import br.com.fiap_02_wef.dao.PessoaDataBase
import br.com.fiap_02_wef.model.Pessoa

class PessoaRepositorio(context: Context) {

    private val db = PessoaDataBase.getDataBase(context).pessoaDao()

    fun salvar(pessoa: Pessoa): Long {
        return db.salvar(pessoa)
    }
    fun listarPessoas(): List<Pessoa>{
        return db.listarPessoa()
    }


}