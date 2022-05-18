package kz.ablazim.weatherapp.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kz.ablazim.weatherapp.R

fun FragmentActivity.replaceFragment(
    fragment: Fragment,
    tag: String = fragment::class.java.name
) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment, tag)
        .commit()
}

fun Fragment.replaceFragment(
    fragment: Fragment,
    @IdRes container: Int = R.id.container,
    addToBackStack: Boolean = true,
    tag: String = fragment::class.java.name
) {
    requireActivity()
        .supportFragmentManager
        .beginTransaction()
        .replace(container, fragment, tag)
        .apply { if (addToBackStack) addToBackStack(tag) }
        .commit()
}