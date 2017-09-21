package net.extrategy.kotlinweatherapp.domain.commands

interface Command<out T> {
    fun execute(): T
}
