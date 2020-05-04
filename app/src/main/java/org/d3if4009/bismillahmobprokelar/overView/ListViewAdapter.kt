package org.d3if4009.bismillahmobprokelar.overView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if4009.bismillahmobprokelar.databinding.RecyclerviewListItemBinding
import org.d3if4009.bismillahmobprokelar.network.BuahProperty


class ListViewAdapter(private val onClickListener: OnClickListener) : ListAdapter<BuahProperty,
        ListViewAdapter.BuahPropertyViewHolder>(DiffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewAdapter.BuahPropertyViewHolder {
        return BuahPropertyViewHolder(
            RecyclerviewListItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: ListViewAdapter.BuahPropertyViewHolder,
        position: Int
    ) {
        val BuahProperty = getItem(position)
        holder.bind(BuahProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<BuahProperty>(){
        override fun areItemsTheSame(
            oldItem: BuahProperty,
            newItem: BuahProperty
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: BuahProperty,
            newItem: BuahProperty
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

        class BuahPropertyViewHolder(
            private var binding: RecyclerviewListItemBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(BuahProperty: BuahProperty) {
                binding.property = BuahProperty
                binding.executePendingBindings()
            }
        }

    class OnClickListener(val clickListener: (BuahProperty: BuahProperty)-> Unit){
        fun onClick(BuahProperty: BuahProperty) = clickListener(BuahProperty)
    }
}