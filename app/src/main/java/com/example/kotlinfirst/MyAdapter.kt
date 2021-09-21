package com.example.kotlinfirst


import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class MyAdapter(
    private val list:MutableList<Todo>
): RecyclerView.Adapter<MyAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )

    }

    fun addto(todo: Todo){
        list.add(todo)
        notifyItemInserted(list.size -1)
    }
    fun deleteToDo(){
        list.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(titletodo: TextView,isChecked: Boolean){
        if(isChecked){
            titletodo.paintFlags =titletodo.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            titletodo.paintFlags = titletodo.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val current = list[position]
        holder.itemView.apply {
            titletodo.text = current.title
            cbdone.isChecked = current.isChecked
            toggleStrikeThrough(titletodo,current.isChecked)
            toggleStrikeThrough(titletodo,current.isChecked)
            cbdone.setOnCheckedChangeListener { _, b -> //ischecked
                toggleStrikeThrough(titletodo,b)
                current.isChecked = !current.isChecked
            }

        }
    }

    override fun getItemCount(): Int {

        return list.size

    }

}