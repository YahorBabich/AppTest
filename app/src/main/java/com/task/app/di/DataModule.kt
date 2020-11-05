package com.task.app.di

import androidx.room.Room
import com.task.app.db.AppDatabase
import org.koin.dsl.module

const val dbName = "APP_DATA_BASE"

val dataModule = module {
    //Room DataBase
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java,
            dbName
        ).build()
    }
    single { get<AppDatabase>().teamDao() }
}
