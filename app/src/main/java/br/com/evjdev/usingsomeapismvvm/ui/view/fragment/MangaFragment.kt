package br.com.evjdev.usingsomeapismvvm.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import br.com.evjdev.usingsomeapismvvm.databinding.FragmentMangaBinding
import br.com.evjdev.usingsomeapismvvm.resource.extensions.localized
import br.com.evjdev.usingsomeapismvvm.ui.main.viewmodel.MangaViewModel
import br.com.evjdev.usingsomeapismvvm.ui.view.activity.BaseActivity
import br.com.evjdev.usingsomeapismvvm.ui.view.adapter.MangaAdapter
import kotlinx.android.synthetic.main.fragment_manga.*

class MangaFragment : Fragment() {

    private var binding: FragmentMangaBinding? = null
    private lateinit var mangaViewModel: MangaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Inflate View Binding
        this.binding = FragmentMangaBinding.inflate(inflater, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupViewModel()
        this.setupUI()
        this.getMangaListData()
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

    private fun setupMangaRV(mangaListIn: List<Manga>) {
        this.binding?.rvManga.apply {
            val mLayoutManager = GridLayoutManager(context, 2)
            mLayoutManager.orientation = LinearLayoutManager.VERTICAL

            val mMangaAdapter = context?.let {
                MangaAdapter(it, mangaListIn)
            }

            this?.adapter = mMangaAdapter
            this?.layoutManager = mLayoutManager
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

    private fun setupViewModel() {
        this.mangaViewModel = ViewModelProviders.of(this).get(MangaViewModel::class.java)
    }

    private fun getMangaListData() {
        this.mangaViewModel.getMangaListDataObserver().observe(viewLifecycleOwner, { mangaListIn ->
            this.setupMangaRV(mangaListIn)
        })
    }
}