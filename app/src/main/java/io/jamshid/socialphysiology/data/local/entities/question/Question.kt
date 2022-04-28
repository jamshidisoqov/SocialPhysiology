package io.jamshid.socialphysiology.data.local.entities.question

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var text:String,
    var lessonId:Int
)
