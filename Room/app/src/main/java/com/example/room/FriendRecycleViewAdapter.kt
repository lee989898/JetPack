package com.example.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.room.databinding.ListItemBinding
import com.example.room.db.Friend
import com.example.room.generated.callback.OnClickListener
import java.util.zip.Inflater

class FriendRecycleViewAdapter(
    private val clickListener: (Friend) -> Unit
) : RecyclerView.Adapter<FriendViewHolder>() {

    private val friendsList = ArrayList<Friend>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friendsList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return friendsList.size
    }

    fun setList(friends: List<Friend>){
        friendsList.clear()
        friendsList.addAll(friends)
    }
}

class FriendViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(friend: Friend, clickListener: (Friend) -> Unit) {
        binding.listItemNameTv.text = friend.name
        binding.listItemEmailTv.text = friend.email
        binding.listItemLl.setOnClickListener {
            clickListener(friend)
        }
    }
}