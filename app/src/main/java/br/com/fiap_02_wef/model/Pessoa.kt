package br.com.fiap_02_wef.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_pessoa")
data class Pessoa(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String = "",
    val peso: Double = 0.0,
    @ColumnInfo(name = "data_nasc") val dataNasc: String = "",
    val altura: Double = 0.0,
)
