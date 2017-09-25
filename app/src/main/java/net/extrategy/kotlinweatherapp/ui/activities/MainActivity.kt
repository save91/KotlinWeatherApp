package net.extrategy.kotlinweatherapp.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import net.extrategy.kotlinweatherapp.R
import net.extrategy.kotlinweatherapp.domain.commands.RequestForecastCommand
import net.extrategy.kotlinweatherapp.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastCommand().execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result, { toast(it.date) })
            }
        }

    }
}
