package org.d3if4009.bismillahmobprokelar.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BuahProperty(
    val id: String,
    val nama_bindo : String,
    val nama_bing : String,
    val warna : String,
    val manfaat : String,
    @Json(name = "imgURL")
    val imgSrcUrl : String) : Parcelable{

}



