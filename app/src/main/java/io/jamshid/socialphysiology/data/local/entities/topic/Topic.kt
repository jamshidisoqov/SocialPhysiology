package io.jamshid.socialphysiology.data.local.entities.topic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Topic(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var chapterId:Int,
    var name:String
)
