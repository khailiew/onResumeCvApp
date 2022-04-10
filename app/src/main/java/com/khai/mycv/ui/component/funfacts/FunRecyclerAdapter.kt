package com.khai.mycv.ui.component.funfacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.khai.mycv.data.adapter.MediaType
import com.khai.mycv.data.model.CvResponse.FunFacts.FunFactsData
import com.khai.mycv.databinding.RowItemFunImageBinding
import com.khai.mycv.databinding.RowItemFunInfoTextBinding
import com.khai.mycv.databinding.RowItemFunTextBinding
import com.khai.mycv.databinding.RowItemFunVideoLinkBinding

class FunRecyclerAdapter(var data: List<FunFactsData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val N_COLUMNS = 2
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
            MediaType.INFO_TEXT -> FunInfoTextViewHolder(
                RowItemFunInfoTextBinding.inflate(
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
            MediaType.VIDEO_LINK -> {
                val binding = RowItemFunVideoLinkBinding.inflate(
                    inflater,
                    parent,
                    false
                )
                // YouTube Player lifecycle
                parent.findViewTreeLifecycleOwner()?.lifecycle?.addObserver(binding.youtubePlayerView)

                return FunVideoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = data[position]
        (holder as IBindableViewHolder).bind(itemData)
    }

    override fun getItemCount() = data.size
}

