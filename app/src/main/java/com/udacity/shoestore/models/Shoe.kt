package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.databinding.BindingAdapter
import kotlinx.android.parcel.Parcelize

@Parcelize
data class  Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable

// Extension method on Shoe
fun Shoe.valid(): Boolean {
    return company.isNotEmpty() && name.isNotEmpty() && !size.isNaN() && description.isNotEmpty()
}