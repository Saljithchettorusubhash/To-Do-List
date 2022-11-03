package com.example.firstassignment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class RecyclerAdapter(val context: Context, var ri_arraylist: ArrayList<RecyclerItem>) :
    RecyclerView.Adapter<RecyclerAdapter.ItemHolder>() {
    // private fields of the class
    private val _context: Context = context
    private var _ri_arraylist: ArrayList<RecyclerItem> = ri_arraylist







    //step 8
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(_context).inflate(R.layout.recycler_item, parent, false))
    }

    //step 9
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        // get the item at the current position
        val item: RecyclerItem = _ri_arraylist.get(position)
        // set the number and text on the view holder
        holder._tv_text.setText(item.text)
        holder._tv_number.setText(item.number.toString())
    }



    //step7
    override fun getItemCount(): Int {
        return _ri_arraylist.size
    }



    // recycler view step6
    class ItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var _view: View = v
        private var _recycler_item: RecyclerItem? = null
        lateinit var _tv_text: TextView
        lateinit var _tv_number: TextView
        init {
            _tv_text = _view.findViewById<TextView>(R.id.text)
            _tv_number = _view.findViewById<TextView>(R.id.number)
            // set a listener for clicks on this view holder
            _view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            Log.i("RecyclerView", "clicked on item" + _tv_number.text)
        }
    }






}