package com.khai.mycv.ui.common

import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.core.text.italic
import androidx.core.text.underline


fun parseFormatting(lines: List<String>): SpannableStringBuilder {
    val ssb = SpannableStringBuilder()
    for (line in lines) {
        when {
            line.startsWith("<b>") -> ssb.bold { append(line.removePrefix("<b>"))}
            line.startsWith("<i>") -> ssb.italic { append(line.removePrefix("<i>"))}
            line.startsWith("<u>") -> ssb.underline { append(line.removePrefix("<u>"))}
            else -> ssb.append(line)
        }
    }
    return ssb
}