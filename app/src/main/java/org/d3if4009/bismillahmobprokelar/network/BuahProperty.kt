package org.d3if4009.bismillahmobprokelar.network

import com.squareup.moshi.Json

data class BuahProperty(
    val nama_bindo : String,
    val nama_bing : String,
    val warna : String,
    val manfaat : String,
    @Json(name = "imgURL")
    val imgSrcUrl : String
)