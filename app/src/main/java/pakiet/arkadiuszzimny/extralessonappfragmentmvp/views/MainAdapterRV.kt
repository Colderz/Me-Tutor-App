package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student

class MainAdapterRV(private val dataArrayList: List<Student>): RecyclerView.Adapter<MainAdapterRV.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterRV.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.student_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainAdapterRV.ViewHolder, position: Int) {
        holder.personName.text = dataArrayList[position].name
        holder.personLevel.text = dataArrayList[position].level
        holder.personCost.text = dataArrayList[position].cost
    }

    override fun getItemCount(): Int {
        return dataArrayList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val personName: TextView
        val personLevel: TextView
        val personCost: TextView

        init {
            personName = itemView.findViewById(R.id.studentName)
            personLevel = itemView.findViewById(R.id.classText)
            personCost = itemView.findViewById(R.id.costText)
        }

    }
}