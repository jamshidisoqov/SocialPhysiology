package io.jamshid.socialphysiology.data.local.entities.use_lib

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UseLib(
    @PrimaryKey var id: Int,
    var text: String,
    var lessonId: Int
)
