package com.example.bitcointicker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.*

open class BaseViewModel<T: Any>: ViewModel() {
    protected var _state: MutableStateFlow<ViewState<T>> = MutableStateFlow(ViewState.Idle())
    val state: StateFlow<ViewState<T>> = _state
}

sealed class ViewState<T> {
    data class Success<T>(val data:T): ViewState<T>()
    data class Error<T>(val error: T? = null, val message: String? = null ): ViewState<T>()
    class Idle<T> : ViewState<T>()
    class Loading<T> : ViewState<T>()
}