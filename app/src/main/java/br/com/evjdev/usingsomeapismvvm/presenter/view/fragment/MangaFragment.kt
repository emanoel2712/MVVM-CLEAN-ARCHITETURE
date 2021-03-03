package br.com.evjdev.usingsomeapismvvm.presenter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.databinding.FragmentMangaBinding
import br.com.evjdev.usingsomeapismvvm.domain.model.Manga
import br.com.evjdev.usingsomeapismvvm.resource.extensions.localized
import br.com.evjdev.usingsomeapismvvm.presenter.view.activity.BaseActivity
import br.com.evjdev.usingsomeapismvvm.presenter.view.adapter.MangaAdapter
import br.com.evjdev.usingsomeapismvvm.presenter.viewmodel.MangaViewModel
import kotlinx.android.synthetic.main.fragment_manga.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MangaFragment : Fragment() {

    private val viewModel: MangaViewModel by sharedViewModel()
    private var binding: FragmentMangaBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentMangaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupUI()
        this.setupObserverMangasData()
        this.viewModel.getMangas()
    }

    private fun setupUI() {
        (requireActivity() as BaseActivity).setupNavBar(
            R.string.animes.localized(),
            true,
            R.color.colorMainDark,
            R.color.white
        )

        this.clickBtnSearch()
        this.editClickInNext()
    }

    private fun setupObserverMangasData() {
        this.viewModel.mangas.observe(viewLifecycleOwner) { mangaListIn ->
            println("LISTA DE MANGAS $mangaListIn")
            this.setupMangaRV(mangaListIn)
//            this.populateMangas(mangaListIn)
        }
    }

    private fun populateMangas(mangas: List<Manga>) {
//        binding?.rvManga?.adapter = MangaAdapter(requireContext(), mangas)
    }

    private fun setupMangaRV(mangaListIn: List<Manga>) {
        this.binding?.rvManga.apply {
            val mLayoutManager = GridLayoutManager(context, 2)
            mLayoutManager.orientation = LinearLayoutManager.VERTICAL

            val mMangaAdapter = context?.let {
                MangaAdapter(it, mangaListIn)
            }

            this?.adapter = mMangaAdapter
            this?.layoutManager = mLayoutManager

            println("LISTA DE MANGAS $mangaListIn")
        }
    }

    private fun clickBtnSearch() {
        this.btnSearch.setOnClickListener {
            this.searchTF.editText?.let {
                if (it.text.isNotEmpty()) {
//                    this.showLoading()
//                    AnimePresenter.sharedInstance.getAnimes(it.text.toString())

                } else {
                    it.error = "O campo não pode ser vazio"
                }
            }
        }
    }

    private fun editClickInNext() {

        this.searchTF.editText?.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_NEXT) {
                this.btnSearch.requestFocusFromTouch()
            }
            false
        }
    }
}