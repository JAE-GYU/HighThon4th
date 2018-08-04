package kr.puze.highthon.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_board.view.*
import kr.puze.highthon.Data.RecyclerItem
import kr.puze.highthon.R

class RecommendRecyclerViewAdapter(var items: ArrayList<RecyclerItem>, var context: Context) : RecyclerView.Adapter<RecommendRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_board, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bind(items.get(position))
        holder?.itemView?.setOnClickListener {
            itemClick?.onItemClick(holder.itemView, position)
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RecyclerItem) {
            itemView.image.setImageResource(R.drawable.ic_feed)
            itemView.title.text = item.title
            itemView.hash_tag.text = item.hashtag
            itemView.info.text = item.info
        }
    }

    var itemClick: ItemClick? = null

    interface ItemClick {
        fun onItemClick(view: View?, position: Int)
    }
}