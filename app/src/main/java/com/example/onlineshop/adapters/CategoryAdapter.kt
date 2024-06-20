package com.example.onlineshop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.models.data.Category

class CategoryAdapter(private val categoryList: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryImage: ImageView = view.findViewById(R.id.category_image)
        val categoryName: TextView = view.findViewById(R.id.category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryName.text = category.name
        holder.categoryImage.setImageResource(category.img)

        holder.itemView.setOnClickListener {
            click.onItemClick(categoryList[holder.adapterPosition])
        }

    }

    //INTERFACE FOR CALLBACK ADAPTER, IN ANOTHER PLACE
    interface onClick {
        fun onItemClick(data: Category)
    }

    private lateinit var click: onClick //variable for instantiation onClick interface

    //method for setter variable instantiation onClick interface
    fun setterClick(click: onClick) {
        this.click = click
    }

    override fun getItemCount(): Int = categoryList.size
}
