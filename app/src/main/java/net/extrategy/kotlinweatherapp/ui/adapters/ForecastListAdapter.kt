package net.extrategy.kotlinweatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import net.extrategy.kotlinweatherapp.R
import net.extrategy.kotlinweatherapp.domain.model.Forecast
import net.extrategy.kotlinweatherapp.domain.model.ForecastList
import org.jetbrains.anko.find

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
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTView = view.find<TextView>(R.id.maxTemperature)
        private val minTView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTView.text = "$high°"
                minTView.text = "$low°"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

}
