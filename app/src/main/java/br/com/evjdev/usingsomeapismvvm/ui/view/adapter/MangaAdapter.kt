package br.com.evjdev.usingsomeapismvvm.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.data.model.Manga
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_manga.view.*

class MangaAdapter(private val contextIn: Context, private val mangaListIn: List<Manga>) :
    RecyclerView.Adapter<MangaAdapter.ViewHolder>() {

    var mMangaInfo: (animeIn: Manga) -> Unit = { }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        this.mangaListIn[position].let { mangaIn ->

            Picasso.get().load(mangaIn.mIMG_URL).into(holder.ivAnimeIMG)
            holder.tvAnimeName.text = mangaIn.mTitle

            holder.itemView.setOnClickListener {
                this.mMangaInfo(mangaIn)
            }
        }
    }

    override fun getItemCount(): Int {
        return this.mangaListIn.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextIn).inflate(R.layout.adapter_manga, parent, false)
        )
    }

    class ViewHolder(itemViewIn: View) : RecyclerView.ViewHolder(itemViewIn) {
        val ivAnimeIMG: AppCompatImageView = itemViewIn.ivMangaIMG
        val tvAnimeName: TextView = itemViewIn.tvMangaName
    }
}