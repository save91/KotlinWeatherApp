package net.extrategy.kotlinweatherapp.domain.model

data class ForecastList(
        val city: String,
        val country: String,
        val dailyForecast: List<Forecast>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(pos: Int): Forecast = dailyForecast.get(pos)
}

data class Forecast(
        val date: String,
        val description: String,
        val high: Int,
        val low: Int,
        val iconUrl: String)
