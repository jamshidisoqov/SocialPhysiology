package io.jamshid.socialphysiology.data.local.entities.topic

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "paragraph")
data class Topic(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name="chapter_id")
    var chapterId:Int,
    @ColumnInfo(name="name")
    var name:String
):Serializable
