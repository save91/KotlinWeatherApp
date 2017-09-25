package net.extrategy.kotlinweatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*
import net.extrategy.kotlinweatherapp.R
import net.extrategy.kotlinweatherapp.domain.model.Forecast
import net.extrategy.kotlinweatherapp.domain.model.ForecastList

class ForecastListAdapter(
        private val forecast: ForecastList,
        private val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(forecast[position])
    }

    override fun getItemCount(): Int = forecast.size

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high°"
                itemView.minTemperature.text = "$low°"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}
