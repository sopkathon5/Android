package com.icoo.sopkaton_5.ui.main.store

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.icoo.sopkaton_5.R
import com.icoo.sopkaton_5.data.model.storeItem.StoreIteamData

class  StoreRecyclerViewAdapter (val ctx:Context, var dataList : ArrayList<StoreIteamData>)
    : RecyclerView.Adapter<StoreRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_store_item, parent,false)
        return Holder(view)    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.shop.text=dataList[position].shop
        holder.product_item.text=dataList[position].product_item
        holder.product_price.text=dataList[position].product_price
        holder.product_img.setBackgroundResource(dataList[position].product_img)

    }

    inner class Holder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val shop : TextView = itemView.findViewById(R.id.rv_store_tv_shop) as TextView
        val product_item : TextView = itemView.findViewById(R.id.rv_store_tv_product_name) as TextView
        val product_price : TextView = itemView.findViewById(R.id.rv_store_tv_product_price) as TextView

        val product_img : ImageView = itemView.findViewById(R.id.rv_store_product_image) as ImageView
    }

}