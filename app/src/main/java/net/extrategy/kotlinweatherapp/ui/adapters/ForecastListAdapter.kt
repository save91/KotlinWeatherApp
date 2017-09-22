package net.extrategy.kotlinweatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import net.extrategy.kotlinweatherapp.domain.model.ForecastList

class ForecastListAdapter(private val forecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(TextView(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(forecast[position]) {
            holder.textView.text = "$date - $description - $low/$high"
        }
    }

    override fun getItemCount(): Int = forecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}
