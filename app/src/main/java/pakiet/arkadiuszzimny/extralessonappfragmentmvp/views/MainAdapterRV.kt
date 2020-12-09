package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R

class MainAdapterRV(/*private val dataArrayList: ArrayList<Student>*/): RecyclerView.Adapter<MainAdapterRV.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterRV.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.student_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainAdapterRV.ViewHolder, position: Int) {
        //holder.textRV.text = "No tak"
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        init {

        }

    }
}