package com.ibrohimapk3.learneasy.presentation.screen.grammar.view.component

fun splitText(text: String?): MutableList<String>? {
    if (text == null)
        return null
    val myText = "$text+"
    val list = mutableListOf<String>()
    var textPart = ""
    for (i in 0..<myText.length) {
        if (myText[i] != '+') textPart += myText[i]
        if (myText[i] == '+') {
            list.add(textPart)
            textPart = ""
        }
    }
    return list
}

