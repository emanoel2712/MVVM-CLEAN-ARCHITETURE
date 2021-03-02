package br.com.evjdev.usingsomeapismvvm.domain.model

import br.com.evjdev.usingsomeapismvvm.data.repository.MangaRepository
import java.lang.Exception

class GetMangas(
    private val mangaRepository: MangaRepository
) : GetMangasUseCase {

    override suspend fun invoke(): List<Manga> = try {
        mangaRepository.getMangas() ?: listOf()
    } catch (ex: Exception) {
        listOf()
    }
}

interface GetMangasUseCase {
    suspend operator fun invoke(): List<Manga>
}