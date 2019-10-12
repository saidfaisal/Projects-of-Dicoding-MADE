package com.example.myintentapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonWithPercelize(val name: String?, val age: Int?, val email: String?, val city: String?): Parcelable