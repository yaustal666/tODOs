package com.yaustal666.todos

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yaustal666.todos.data.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDiModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
        callback: AppDataBase.Callback
    ) =
        Room.databaseBuilder(app, AppDataBase::class.java, "todo_app_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideTaskDao(db : AppDataBase) = db.taskDAO()
    @Provides
    fun provideTaskListDao(db : AppDataBase) = db.taskListDAO()

    @Provides
    @Singleton
    fun provideAppScope() = CoroutineScope(SupervisorJob())

}