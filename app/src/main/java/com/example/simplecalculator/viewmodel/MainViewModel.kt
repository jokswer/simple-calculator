package com.example.simplecalculator.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainViewModel : BaseObservable() {
    private var engine = ScriptEngineManager().getEngineByName("rhino")

    var currentInput = ObservableField<String>()

    fun addSymbol(symbol: String) {
        if (currentInput.get() != null) {
            currentInput.set(currentInput.get().plus(symbol))
        } else {
            currentInput.set(symbol)
        }
    }

    fun clearAll() {
        currentInput.set(null)
    }

    fun clearLastSymbol() {
        if (currentInput.get() != null) {
            currentInput.set(currentInput.get()?.dropLast(1))
        }
    }

    fun calculate() {
        try {
            val res = engine.eval(currentInput.get())
            currentInput.set(res.toString())
        } catch (error: ScriptException) {
        }
    }
}