package com.example.firstassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainLayoutAdapter(private val mList: List<RecyclerItemmain>,private val cellClickListener: ClickListener) : RecyclerView.Adapter<MainLayoutAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_main, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.tasknumber.text= ItemsViewModel.tasknumber.toString()
        holder.taskname.text = ItemsViewModel.taskname

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(ItemsViewModel)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tasknumber:TextView = itemView.findViewById(R.id.tasknumber)
        val taskname: TextView = itemView.findViewById(R.id.taskname)
    }
}
