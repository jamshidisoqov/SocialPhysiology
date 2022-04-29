package io.jamshid.socialphysiology.common.core

object TextWatcher {

    fun textSubstring(str: String): String {
        val len = str.length
        return if (len > 20)
            "${str[0]}${str.substring(1, 20).lowercase()}"
        else
            "${str[0]}${str.substring(1, len).lowercase()}"

    }
}