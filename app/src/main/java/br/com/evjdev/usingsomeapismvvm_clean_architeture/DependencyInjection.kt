package br.com.evjdev.usingsomeapismvvm_clean_architeture.resource.koin

import br.com.evjdev.usingsomeapismvvm_clean_architeture.data.api.APIClient
import br.com.evjdev.usingsomeapismvvm_clean_architeture.data.repository.MangaRepository
import br.com.evjdev.usingsomeapismvvm_clean_architeture.data.repository.MangaRepositoryImpl
import br.com.evjdev.usingsomeapismvvm_clean_architeture.domain.model.GetMangas
import br.com.evjdev.usingsomeapismvvm_clean_architeture.domain.model.GetMangasUseCase
import br.com.evjdev.usingsomeapismvvm_clean_architeture.presenter.viewmodel.MangaViewModel
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
