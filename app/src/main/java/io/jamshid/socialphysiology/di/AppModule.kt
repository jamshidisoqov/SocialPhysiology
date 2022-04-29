package io.jamshid.socialphysiology.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.jamshid.socialphysiology.data.local.dao.SocailDao
import io.jamshid.socialphysiology.data.local.database.AppDatabase
import io.jamshid.socialphysiology.data.utils.Constants
import io.jamshid.socialphysiology.domain.repository.Repository
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import io.jamshid.socialphysiology.domain.use_cases.favourite_use_case.GetFavourites
import io.jamshid.socialphysiology.domain.use_cases.favourite_use_case.UpdateFavorites
import io.jamshid.socialphysiology.domain.use_cases.home_use_case.GetAllChapter
import io.jamshid.socialphysiology.domain.use_cases.lesson_use_case.GetLesson
import io.jamshid.socialphysiology.domain.use_cases.question_use_case.GetQuestion
import io.jamshid.socialphysiology.domain.use_cases.topic_use_case.GetTopics
import io.jamshid.socialphysiology.domain.use_cases.use_libs_use_case.GetUseLibs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            Constants.DB_NAME
        ).createFromAsset("book.db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideSocialDao(appDatabase: AppDatabase): SocailDao {
        return appDatabase.socialDao()
    }

    @Provides
    @Singleton
    fun provideRepository(socialDao: SocailDao): Repository {
        return Repository(socialDao)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            getAllChapter = GetAllChapter(repository),
            getTopics = GetTopics(repository),
            getLesson = GetLesson(repository),
            getQuestion = GetQuestion(repository),
            getUseLibs = GetUseLibs(repository),
            getFavourites = GetFavourites(repository),
            updateFavorites = UpdateFavorites(repository)
        )
    }


}