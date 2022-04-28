package io.jamshid.socialphysiology.domain.use_cases.use_libs_use_case

import io.jamshid.socialphysiology.domain.repository.Repository
import java.util.concurrent.Flow

class GetUseLibs (private val repository: Repository) {

    operator fun invoke() = repository.getUseLibsByLesson()


}