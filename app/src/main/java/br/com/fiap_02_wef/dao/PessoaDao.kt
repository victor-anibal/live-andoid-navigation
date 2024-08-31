package br.com.fiap_02_wef.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap_02_wef.model.Pessoa

// Operação de CRUD do DB
@Dao
interface PessoaDao {

@Insert
fun salvar(pessoa: Pessoa): Long

@Query("SELECT * FROM tbl_pessoa ORDER BY nome ASC")
fun listarPessoa(): List<Pessoa>

}