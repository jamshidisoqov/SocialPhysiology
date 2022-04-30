package io.jamshid.socialphysiology.domain.use_cases.question_use_case

import io.jamshid.socialphysiology.domain.repository.Repository

class GetQuestion(private val repository: Repository) {

    operator fun invoke(chapterId:Int) = repository.getQuestionsByLesson(chapterId)


}