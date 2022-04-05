package com.example.baitaptuan3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class DataStore(val username:String, val password:String):Parcelable {
}

