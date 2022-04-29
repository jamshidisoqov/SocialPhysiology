package io.jamshid.socialphysiology.data.local.entities.use_lib

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "uselib")
data class UseLib(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "text")
    var text: String,
):Serializable
