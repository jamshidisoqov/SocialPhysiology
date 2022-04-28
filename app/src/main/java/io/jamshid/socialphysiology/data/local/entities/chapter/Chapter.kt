package io.jamshid.socialphysiology.data.local.entities.chapter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chapter(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var name:String
)
