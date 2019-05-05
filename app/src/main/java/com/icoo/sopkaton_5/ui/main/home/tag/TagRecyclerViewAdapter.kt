package com.icoo.sopkaton_5.ui.main.home.tag

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.local.SharedPreferenceController
import com.icoo.sopkaton_5.data.model.post.PostModel
import com.icoo.sopkaton_5.util.ITagClickListener

class TagRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<PostModel>) :
    RecyclerView.Adapter<TagRecyclerViewAdapter.Holder>() {

    private var listener: ITagClickListener? = null

    fun setOnItemClickListener(listener: ITagClickListener) {
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
                listener!!.onItemClick(dataList[position].contentIdx)
            }
        }
        holder.nickname.text =  SharedPreferenceController.getUsername(ctx)//dataList[position].userIdx.toString()
        holder.time.text = dataList[position].createdAt
        holder.contents.text = dataList[position].content
        holder.tag.text = dataList[position].name
        holder.likeCnt.text = dataList[position].heartCount.toString()
        holder.commentCnt.text = dataList[position].commentCount.toString()

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view: LinearLayout = itemView.findViewById(R.id.rv_tag_item_ll_view) as LinearLayout
        val tag: TextView = itemView.findViewById(R.id.rv_tag_item_tv_tag) as TextView
        val time: TextView = itemView.findViewById(R.id.rv_tag_item_tv_time) as TextView
        val contents: TextView = itemView.findViewById(R.id.rv_tag_item_tv_contents) as TextView
        val nickname: TextView = itemView.findViewById(R.id.rv_tag_item_tv_nickname) as TextView
        val likeCnt: TextView = itemView.findViewById(R.id.rv_tag_item_tv_like_cnt) as TextView
        val commentCnt: TextView = itemView.findViewById(R.id.rv_tag_item_tv_comment_cnt) as TextView
    }
}