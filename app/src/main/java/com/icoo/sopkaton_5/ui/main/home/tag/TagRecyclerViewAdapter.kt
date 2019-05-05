package com.icoo.sopkaton_5.ui.main.home.tag

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.Test.TestModel
import com.icoo.sopkaton_5.data.model.post.PostModel
import com.icoo.sopkaton_5.util.IHomeClickListener
import com.icoo.sopkaton_5.util.IIdxClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class TagRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<PostModel>) :
    RecyclerView.Adapter<TagRecyclerViewAdapter.Holder>() {

    private var listener: IIdxClickListener? = null

    fun setOnItemClickListener(listener: IIdxClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_tag_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(dataList[position].idx)
            }
        }
        holder.nickname.text = dataList[position].nickname
        holder.time.text = dataList[position].time
        holder.contents.text = dataList[position].contents
        holder.tag.text = dataList[position].tag
        holder.likeCnt.text = dataList[position].likeCnt.toString()
        holder.commentCnt.text = dataList[position].commentCnt.toString()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view: LinearLayout = itemView.findViewById(R.id.rv_tag_item_ll_view) as LinearLayout
        val nickname: TextView = itemView.findViewById(R.id.rv_tag_item_tv_nickname) as TextView
        val time: TextView = itemView.findViewById(R.id.rv_tag_item_tv_time) as TextView
        val contents: TextView = itemView.findViewById(R.id.rv_tag_item_tv_contents) as TextView
        val tag: TextView = itemView.findViewById(R.id.rv_tag_item_tv_tag) as TextView
        val likeCnt: TextView = itemView.findViewById(R.id.rv_tag_item_tv_like_cnt) as TextView
        val commentCnt: TextView = itemView.findViewById(R.id.rv_tag_item_tv_comment_cnt) as TextView
    }
}