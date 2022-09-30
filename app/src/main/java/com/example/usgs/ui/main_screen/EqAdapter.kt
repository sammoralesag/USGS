package com.example.usgs.ui.main_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.usgs.databinding.ItemEqBinding
import com.example.usgs.domain.models.Eq


class EqAdapter(
    private val onEqClicked: (Eq) -> Unit
) : ListAdapter<Eq, EqAdapter.EqViewHolder>(EqDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EqViewHolder {
        return EqViewHolder(
            ItemEqBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EqViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class EqViewHolder(private val itemBinding: ItemEqBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(eq: Eq) {
            with(itemBinding) {
                place.text = eq.place
                mag.text = eq.mg.toString()
                tvDate.text = eq.time.toString()
                cvEqItem.setOnClickListener {
                    onEqClicked(eq)
                }

            }
        }

    }

}

class EqDiff() : DiffUtil.ItemCallback<Eq>() {
    override fun areItemsTheSame(oldItem: Eq, newItem: Eq): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Eq, newItem: Eq): Boolean {
        return oldItem == newItem
    }


}