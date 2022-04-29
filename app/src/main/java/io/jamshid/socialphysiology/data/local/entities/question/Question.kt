package io.jamshid.socialphysiology.data.local.entities.question

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "question")
data class Question(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "text")
    var text: String,
    @ColumnInfo(name = "chapter_id")
    var chapterId: Int
):Serializable
