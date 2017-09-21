package net.extrategy.kotlinweatherapp.data

import com.google.gson.Gson
import java.net.URL

class ForecastRequest() {

    companion object {
        private val MY_URL = "http://app.e-xtrategy.net/demo/weather/today.json"
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(MY_URL).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
