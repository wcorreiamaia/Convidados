package com.example.convidados.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.constans.DataBaseConstants
import com.example.convidados.model.GuestModel

//essa classe nao pode ser instaciada. Por isso o private constructor
class GuestRepository private constructor(context: Context) {

    private val guestDataBase = GuestDataBase(context)

    //Singleton: o que é? Controla o número de instâncias de uma classe.
    //É um padrão de projeto bastante utilizado
    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {

            //se o repositório não estiver inicializado, ele irá se inicializar
            if (!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }

    }

    fun insert(guest: GuestModel): Boolean {
        //utilizando try/catch para retornar em caso de erro true ou false
        return try {
            //writetabledatabase é o metodo para podermos inserirmos as informações da tabela
            val db = guestDataBase.writableDatabase

            //se for true (retornará 1) se for false (retornará 0)
            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            //na linha abaixo estamos escrevendo o nome da coluna "name" e chamamos o name da classe GuestModel
            //Nao foi necessário implementar a coluna de "id" pois é autoencremento. O banco faz sozinho
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)
            //na linha abaixo estamos dando o nome a tabela "GUEST", e values que instaciamos com a classe
            //contentValues por obrigação.
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
            true
        }catch (e: Exception){
            false
        }
    }
}