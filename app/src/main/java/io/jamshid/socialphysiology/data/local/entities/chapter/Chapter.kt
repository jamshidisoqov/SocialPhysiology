package io.jamshid.socialphysiology.data.local.entities.chapter

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "chapter")
data class Chapter(
    @PrimaryKey(autoGenerate = true) var id:Int,
    @ColumnInfo(name="name")
    var name:String
):Serializable
