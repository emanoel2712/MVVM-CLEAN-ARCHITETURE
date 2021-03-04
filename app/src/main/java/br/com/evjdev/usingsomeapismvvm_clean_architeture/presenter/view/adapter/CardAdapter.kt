package br.com.evjdev.usingsomeapismvvm_clean_architeture.presenter.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.evjdev.usingsomeapismvvm_clean_architeture.R
import br.com.evjdev.usingsomeapismvvm_clean_architeture.domain.model.Card
import kotlinx.android.synthetic.main.adapter_card.view.*

class CardAdapter(private val contextIn: Context, private val cardListIn: List<Card>) :
    RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    var clickInfoCard: (cardIn: Card) -> Unit = { }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        this.cardListIn[position].let { cardIn ->

            when (cardIn.cID) {

                1 -> {

                    holder.nameCard.setTextColor(ContextCompat.getColor(contextIn, R.color.white))
                    holder.nameCard.setText(R.string.see_favorite_anime)
                    holder.nameCard.setBackgroundColor(
                        ContextCompat.getColor(
                            contextIn,
                            R.color.colorBottomIMGAnime
                        )
                    )
                    holder.ivCard.setImageResource(R.drawable.ic_anime)
                    holder.ivCard.setBackgroundColor(
                        ContextCompat.getColor(
                            contextIn,
                            R.color.black
                        )
                    )
                }
            }

            holder.itemView.setOnClickListener {
                this.clickInfoCard(cardIn)
            }
        }
    }

    override fun getItemCount(): Int {
        return this.cardListIn.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(contextIn).inflate(R.layout.adapter_card, parent, false)
        )
    }

    class ViewHolder(itemViewIn: View) : RecyclerView.ViewHolder(itemViewIn) {
        var ivCard: ImageView = itemViewIn.ivCard
        var nameCard: TextView = itemViewIn.nameCard

    }
}