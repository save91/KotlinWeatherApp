package net.extrategy.kotlinweatherapp.domain.commands

import net.extrategy.kotlinweatherapp.data.ForecastRequest
import net.extrategy.kotlinweatherapp.domain.mappers.ForecastDataMapper
import net.extrategy.kotlinweatherapp.domain.model.ForecastList

class RequestForecastCommand(): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest()
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}