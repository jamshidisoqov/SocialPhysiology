package io.jamshid.socialphysiology.data.local.entities.lesson

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lesson(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var text: String,
    var topicId: Int,
    var status: Boolean = false
)
