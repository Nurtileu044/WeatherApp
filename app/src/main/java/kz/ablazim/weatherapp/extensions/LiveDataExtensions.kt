package kz.ablazim.weatherapp.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

inline fun <T> LiveData<T>.observeNotNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    this.observe(owner) { it?.run(observer) }
}