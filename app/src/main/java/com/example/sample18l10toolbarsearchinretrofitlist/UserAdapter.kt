package com.example.sample18l10toolbarsearchinretrofitlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sample18l10toolbarsearchinretrofitlist.databinding.ItemUserBinding
import com.example.sample18l10toolbarsearchinretrofitlist.UserViewHolder

class UserAdapter(
    context: Context
) : ListAdapter<User, UserViewHolder>(DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            binding = ItemUserBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.login == newItem.login && oldItem.avatarUrl == newItem.avatarUrl
            }
        }
    }
}

class UserViewHolder(
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User) {
        with(binding) {
            imageAvatar.load(item.avatarUrl)
            userName.text =item.login
        }
    }
}