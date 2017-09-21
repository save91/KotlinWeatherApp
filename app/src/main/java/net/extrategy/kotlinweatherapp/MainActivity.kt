package net.extrategy.kotlinweatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    private val url = "http://app.e-xtrategy.net/demo/weather/today.json"
    private val items = listOf(
            "Lunedì - Pioggia - min 15 - max 34",
            "Martedì - Pioggia - min 15 - max 34",
            "Mercoledì - Pioggia - min 15 - max 34",
            "Giovedì - Pioggia - min 15 - max 34",
            "Venerdì - Pioggia - min 15 - max 34",
            "Sabato - Pioggia - min 15 - max 34",
            "Domenica - Pioggia - min 15 - max 34"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
        doAsync {
            Request(url).run()
            uiThread { longToast("Request performed") }
        }

    }
}
