package com.emilio.firstapp.service.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emilio.firstapp.service.model.Pessoa

@Database(entities = [Pessoa::class], version = 1)
abstract class FirstAppDataBase: RoomDatabase() {

    abstract fun pessoaDAO(): PessoaDAO
    companion object{
        @Volatile
        private lateinit var INSTACE: FirstAppDataBase

        fun getDataBase(context: Context): FirstAppDataBase{
            if (!Companion::INSTACE.isInitialized){
                synchronized(this){
                    INSTACE = Room.databaseBuilder(
                        context,
                        FirstAppDataBase::class.java,
                        "firstapp_database").build()
                }
            }
            return INSTACE
        }
    }

}