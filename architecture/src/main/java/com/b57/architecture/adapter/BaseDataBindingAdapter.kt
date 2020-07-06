/*
 * Copyright 2018-2020 KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.b57.architecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * @author KunMinX
 * Create at 2018/6/30
 */
abstract class BaseDataBindingAdapter<M, B : ViewDataBinding?>(diffCallback: DiffUtil.ItemCallback<M>) :
    ListAdapter<M, RecyclerView.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding : B? = DataBindingUtil.inflate<B>(
            LayoutInflater.from(parent.context)!!,
            getLayoutResId(viewType),
            parent,
            false
        )
        val holder = BaseBindingViewHolder(binding?.root)
        if (holder.adapterPosition != RecyclerView.NO_POSITION) {
            onBindListener(binding, getItem(holder.adapterPosition), holder)
        }
        return holder
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val binding : B? = DataBindingUtil.getBinding<B>(holder.itemView) as B?
        onBindContent(binding, getItem(position), holder)
        binding?.executePendingBindings()
    }

    @LayoutRes
    protected abstract fun getLayoutResId(viewType: Int): Int

    abstract fun onBindContent(
        binding: B?,
        item: M?,
        holder: RecyclerView.ViewHolder?
    )

    abstract fun onBindListener(
        binding: B?,
        item: M?,
        holder: RecyclerView.ViewHolder?
    )

    class BaseBindingViewHolder internal constructor(itemView: View?) :
        RecyclerView.ViewHolder(itemView!!)
}