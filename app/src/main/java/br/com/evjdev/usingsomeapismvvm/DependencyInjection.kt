package br.com.evjdev.usingsomeapismvvm.resource.koin

import br.com.evjdev.usingsomeapismvvm.data.api.APIClient
import br.com.evjdev.usingsomeapismvvm.data.repository.MangaRepository
import br.com.evjdev.usingsomeapismvvm.data.repository.MangaRepositoryImpl
import br.com.evjdev.usingsomeapismvvm.domain.model.GetMangas
import br.com.evjdev.usingsomeapismvvm.domain.model.GetMangasUseCase
import br.com.evjdev.usingsomeapismvvm.presenter.viewmodel.MangaViewModel
import org.koin.dsl.module

val mangaModule = module {

    single {
        APIClient()
    }

    single<MangaRepository> {
        MangaRepositoryImpl(service = get())
    }

    single<GetMangasUseCase> {
        GetMangas(mangaRepository = get())
    }

    single {
        MangaViewModel(getMangasUseCase = get())
    }
}
