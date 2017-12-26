package com.hzjytech.hades.kotlinlearn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by Hades on 2017/12/20.
 */
class FunctionActivity: AppCompatActivity() {


    private lateinit var rcViewFunctions: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)


        rcViewFunctions=findViewById<RecyclerView>(R.id.rcViewFunctions)


        rcViewFunctions.layoutManager=LinearLayoutManager(this)

        rcViewFunctions.adapter=FunctionAdapter(createListView())
    }

    private fun createListView(): List<String> {
        return listOf("TimeLine")
    }
}

class FunctionAdapter(val lst: List<String>) : RecyclerView.Adapter<FunctionAdapter.FunctionViewHoder>() {
    override fun onBindViewHolder(holder: FunctionViewHoder, position: Int) {
        holder.tvFunctionItemName.setText(lst.get(position))
        holder.tvFunctionItemName.setOnClickListener{
            Toast.makeText(holder.itemView.context,lst[position],Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunctionViewHoder? {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.function_item,parent,false)
        return FunctionViewHoder(view)
    }


    override fun getItemCount(): Int {
        return lst.size
    }

    class FunctionViewHoder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvFunctionItemName:TextView=itemView.findViewById(R.id.tvFunctionItemName)



    }

}
