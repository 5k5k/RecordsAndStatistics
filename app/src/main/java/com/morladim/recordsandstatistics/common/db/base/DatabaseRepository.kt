package com.morladim.recordsandstatistics.common.db.base

import android.content.Context
import androidx.room.Room
import com.morladim.recordsandstatistics.common.db.PeriodDao
import com.morladim.recordsandstatistics.common.db.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * @author 5k5k
 * Created at 2022/5/30
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseRepository {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DbExecutor

    @Provides
    @Singleton
    fun getDatabase(
        @ApplicationContext context: Context,
        @DbExecutor executor: Executor
    ): MainDatabase {
        return Room.databaseBuilder(
            context,
            MainDatabase::class.java, "main.db"
        )
//            .addMigrations(MIGRATION_1_2)
            //允许丢失现有数据
            .fallbackToDestructiveMigration()
            .setQueryExecutor(executor).build()
    }

    @Provides
    @Singleton
    @DbExecutor
    fun dbExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @Singleton
    fun taskDao(db: MainDatabase): TaskDao {
        return db.taskDao()
    }

    @Provides
    @Singleton
    fun periodDao(db: MainDatabase): PeriodDao {
        return db.periodDao()
    }

    @Provides
    @Singleton
    fun otherExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }
}