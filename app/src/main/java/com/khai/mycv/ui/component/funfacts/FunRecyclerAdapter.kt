package com.khai.mycv.ui.component.funfacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.khai.mycv.data.adapter.MediaType
import com.khai.mycv.data.model.CvResponse.FunFacts.FunFactsData
import com.khai.mycv.databinding.RowItemFunImageBinding
import com.khai.mycv.databinding.RowItemFunTextBinding
import com.khai.mycv.databinding.RowItemFunVideoLinkBinding

class FunRecyclerAdapter(var data: List<FunFactsData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val N_COLUMNS = 2
    }

    interface IBindableViewHolder {
        fun bind(itemData: FunFactsData)
    }
    inner class FunTextViewHolder(private val binding: RowItemFunTextBinding) :
        RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
        override fun bind(itemData: FunFactsData) {
            binding.funData = itemData
        }
    }

    inner class FunImageViewHolder(private val binding: RowItemFunImageBinding) :
        RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
        override fun bind(itemData: FunFactsData) {
            binding.funData = itemData
        }
    }

    inner class FunVideoViewHolder(private val binding: RowItemFunVideoLinkBinding) :
        RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
        override fun bind(itemData: FunFactsData) {
            binding.funData = itemData
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].type.ordinal // return enum ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (MediaType.values()[viewType]) {
            MediaType.TEXT -> FunTextViewHolder(
                RowItemFunTextBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            MediaType.IMAGE -> FunImageViewHolder(
                RowItemFunImageBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            MediaType.VIDEO_LINK -> FunVideoViewHolder(
                RowItemFunVideoLinkBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = data[position]
        (holder as IBindableViewHolder).bind(itemData)
    }

    override fun getItemCount() = data.size
}