package io.jamshid.socialphysiology.domain.use_cases

import io.jamshid.socialphysiology.domain.use_cases.favourite_use_case.GetFavourites
import io.jamshid.socialphysiology.domain.use_cases.favourite_use_case.UpdateFavorites
import io.jamshid.socialphysiology.domain.use_cases.home_use_case.GetAllChapter
import io.jamshid.socialphysiology.domain.use_cases.lesson_use_case.GetLesson
import io.jamshid.socialphysiology.domain.use_cases.question_use_case.GetQuestion
import io.jamshid.socialphysiology.domain.use_cases.search_use_case.SearchByChapter
import io.jamshid.socialphysiology.domain.use_cases.search_use_case.SearchByTopic
import io.jamshid.socialphysiology.domain.use_cases.topic_use_case.GetTopics
import io.jamshid.socialphysiology.domain.use_cases.use_libs_use_case.GetUseLibs

data class UseCases(
    var getAllChapter: GetAllChapter,
    var getTopics: GetTopics,
    var getLesson: GetLesson,
    var getQuestion: GetQuestion,
    var getUseLibs: GetUseLibs,
    var getFavourites: GetFavourites,
    var updateFavorites: UpdateFavorites,
    var searchByChapter: SearchByChapter,
    var searchByTopic: SearchByTopic
)