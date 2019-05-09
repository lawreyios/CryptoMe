package com.raywenderlich.android.flyme.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.flyme.models.CryptoData
import com.raywenderlich.android.flyme.models.Price
import com.raywenderlich.android.flyme.R
import kotlinx.android.synthetic.main.row_layout.view.*

class CryptoDataAdapter (private val cryptoList : ArrayList<CryptoData>, private val listener :


Listener) : RecyclerView.Adapter<CryptoDataAdapter.ViewHolder>() {
  interface Listener {
    fun onItemClick(retroCrypto : CryptoData)

  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    holder.bind(cryptoList[position], listener)

  }

  override fun getItemCount(): Int = cryptoList.count()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
    return ViewHolder(view)

  }

  class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    fun bind(cryptoData: CryptoData, listener: Listener) {

      itemView.setOnClickListener{ listener.onItemClick(cryptoData) }
      itemView.text_name.text = cryptoData.name
      itemView.text_price.text = getPricesString(cryptoData.prices)
    }

    private fun getPricesString(prices: List<Price>): String {
      var finalString = ""
      for (price in prices) {
        finalString += "${price.currency}: ${price.price}\n"
      }

      return finalString
    }

  }

}