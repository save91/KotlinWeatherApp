package net.extrategy.kotlinweatherapp.domain.mappers

import net.extrategy.kotlinweatherapp.data.Forecast
import net.extrategy.kotlinweatherapp.data.ForecastResult
import net.extrategy.kotlinweatherapp.domain.model.ForecastList
import net.extrategy.kotlinweatherapp.domain.model.Forecast as ModelForecast
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(
                forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.min.toInt(),
                forecast.temp.max.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

}
