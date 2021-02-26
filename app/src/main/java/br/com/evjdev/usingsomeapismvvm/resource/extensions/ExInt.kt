package br.com.evjdev.usingsomeapismvvm.resource.extensions

import br.com.evjdev.usingsomeapismvvm.resource.utils.MainContext


fun Int.localized(): String {
    return MainContext.context.getString(this)
}