package org.d3if4009.bismillahmobprokelar

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.d3if4009.bismillahmobprokelar.overView.buahApiStatus
import org.d3if4009.bismillahmobprokelar.network.BuahProperty
import org.d3if4009.bismillahmobprokelar.overView.ListViewAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri()
            .buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
                .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<BuahProperty>?){
    val adapter = recyclerView.adapter as ListViewAdapter
    adapter.submitList(data)
}

@BindingAdapter("buahApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: buahApiStatus?) {
    when (status) {
        buahApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        buahApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        buahApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}