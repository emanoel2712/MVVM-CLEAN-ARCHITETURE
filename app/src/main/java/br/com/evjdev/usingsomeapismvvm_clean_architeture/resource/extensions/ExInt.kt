package br.com.evjdev.usingsomeapismvvm_clean_architeture.resource.extensions

import br.com.evjdev.usingsomeapismvvm_clean_architeture.resource.utils.MainContext


fun Int.localized(): String {
    return MainContext.context.getString(this)
}