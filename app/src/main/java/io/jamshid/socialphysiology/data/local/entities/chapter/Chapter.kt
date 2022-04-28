package io.jamshid.socialphysiology.data.local.entities.chapter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapter")
data class Chapter(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name="name")
    var name:String
)
