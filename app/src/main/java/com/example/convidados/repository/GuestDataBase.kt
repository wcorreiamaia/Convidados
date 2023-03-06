package com.example.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.convidados.constans.DataBaseConstants

/*Essa classe é responsável pela conexão ao banco de dados. Apenas isso! E no repository que lidamos
com os dados. Inserção, remoção, manipulação dos dados
 */

//Instaciamos essa classe na classe GuestRepository responsável por lidar com o banco de dados
class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

        companion object{
            private const val NAME = "Guestdb"
            private const val VERSION = 1
        }

    override fun onCreate(db: SQLiteDatabase) {
        //responsável pela criação do banco.
        // Criando uma tabela com nome GUEST com 3 colunas (ID, NAME E PRESENCE)
        //Ela tem um campo ID do tipo INTEIRO
        // Um name do tipo TEXT
        // Um presence do tipo INTERGER (para saber se o convidado está presente ou não).
        /*"primary key autoincrement" quer dizer que cada ID terá sua própria identificação,
        e o banco de dados será responsável por criar essa identificação única de cada um.*/


        db.execSQL("create table "+ DataBaseConstants.GUEST.TABLE_NAME +" (" +
                DataBaseConstants.GUEST.COLUMNS.ID + "interger primary key autoincrement," +
                DataBaseConstants.GUEST.COLUMNS.NAME +  "text," +
                DataBaseConstants.GUEST.COLUMNS.PRESENCE +  "interger);")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        //só cai nessa função quando existe uma nova versão, e o cliente esteja numa versão anterior
    }
}