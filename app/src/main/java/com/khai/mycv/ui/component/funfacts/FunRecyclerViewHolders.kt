package com.khai.mycv.ui.component.funfacts

import androidx.recyclerview.widget.RecyclerView
import com.khai.mycv.data.model.CvResponse
import com.khai.mycv.databinding.RowItemFunImageBinding
import com.khai.mycv.databinding.RowItemFunInfoTextBinding
import com.khai.mycv.databinding.RowItemFunTextBinding
import com.khai.mycv.databinding.RowItemFunVideoLinkBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

interface IBindableViewHolder {
    fun bind(itemData: CvResponse.FunFacts.FunFactsData)
}

class FunTextViewHolder(private val binding: RowItemFunTextBinding) :
    RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
    override fun bind(itemData: CvResponse.FunFacts.FunFactsData) {
        binding.funData = itemData
    }
}

class FunInfoTextViewHolder(private val binding: RowItemFunInfoTextBinding) :
    RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
    override fun bind(itemData: CvResponse.FunFacts.FunFactsData) {
        binding.funData = itemData
    }
}

class FunImageViewHolder(private val binding: RowItemFunImageBinding) :
    RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
    override fun bind(itemData: CvResponse.FunFacts.FunFactsData) {
        binding.funData = itemData
    }
}

class FunVideoViewHolder(private val binding: RowItemFunVideoLinkBinding) :
    RecyclerView.ViewHolder(binding.root), IBindableViewHolder {
    override fun bind(itemData: CvResponse.FunFacts.FunFactsData) {
        binding.funData = itemData
        // load videoId from URL
        binding.youtubePlayerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = itemData.videoUrl?.split("v=")?.last() ?: ""
                youTubePlayer.cueVideo(videoId, 0f)
            }
        })
    }
}