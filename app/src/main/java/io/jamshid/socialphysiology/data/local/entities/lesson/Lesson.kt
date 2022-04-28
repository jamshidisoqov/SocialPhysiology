package io.jamshid.socialphysiology.data.local.entities.lesson

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson")
data class Lesson(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "text")
    var text: String,
    @ColumnInfo(name = "paragraph_id")
    var paragraph_id: Int,
    @ColumnInfo(name = "status")
    var status: Boolean = false
)
