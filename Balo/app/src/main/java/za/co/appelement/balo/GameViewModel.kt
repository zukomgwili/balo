package za.co.appelement.balo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.timer
import kotlin.random.Random

const val INITIAL_COUNTER_VALUE = 5

class GameViewModel : ViewModel() {
    private val _factors = arrayOf(3, 4, 7)
    private val _factorValue = _factors[Random.nextInt(_factors.size)]
    private val _factor = MutableStateFlow(_factorValue)
    val factor = _factor.asStateFlow()
    private val _counter = MutableStateFlow(INITIAL_COUNTER_VALUE)
    val counter = _counter.asStateFlow()
    private val _multiple = MutableStateFlow(_factorValue)
    val multiple = _multiple.asStateFlow()
    private val _score = MutableStateFlow(0)
    val score = _score.asStateFlow()
    private val _gameOver = MutableStateFlow(false)
    val gameOver = _gameOver.asStateFlow()
    private lateinit var _timer: Timer

    init {
        startTimer()
    }

    private fun resetCounter() {
        stopTimer()
        _counter.value = INITIAL_COUNTER_VALUE
    }

    fun validateNoAnswer() {
        if (_multiple.value % _factor.value == 0) {
            _gameOver.value = true
        }
        _multiple.value++
        resetCounter()
    }

    fun validateYesAnswer() {
        if (_multiple.value % factor.value == 0) {
            _score.value++
        } else {
            _gameOver.value = true
        }
        _multiple.value++
        resetCounter()
    }

    private fun stopTimer() {
        _timer.purge()
        viewModelScope.cancel()
    }

    private fun startTimer() {
        viewModelScope.launch {
            _timer = timer(period = 1000L, action = {
                if (_counter.value == 0) {
                    if (_multiple.value % _factor.value == 0) {
                        _gameOver.value = true
                    }
                    _counter.value = INITIAL_COUNTER_VALUE
                    _multiple.value++
                } else {
                    _counter.value--
                }
            })
        }
    }
}