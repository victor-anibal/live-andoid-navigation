package br.com.fiap_02_wef.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap_02_wef.model.Pessoa


@Database(entities = [Pessoa::class], version = 1)
abstract class PessoaDataBase: RoomDatabase() {

   abstract fun pessoaDao(): PessoaDao

   companion object {

       private lateinit var instancia: PessoaDataBase

       fun getDataBase(context: Context): PessoaDataBase{

           if (!::instancia.isInitialized) {
               instancia = Room
                   .databaseBuilder(context, PessoaDataBase::class.java, "pessoa_db")
                   .allowMainThreadQueries()
                   .fallbackToDestructiveMigration(false)
                   .build()
           }

           return instancia
       }
   }

}