package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student

class MainAdapterRV(private val dataArrayList: ArrayList<Student>): RecyclerView.Adapter<MainAdapterRV.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterRV.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.student_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainAdapterRV.ViewHolder, position: Int) {
        holder.personName.text = dataArrayList[holder.adapterPosition].SdntName
        holder.personLevel.text = dataArrayList[holder.adapterPosition].SdntLevel
        holder.personCost.text = dataArrayList[holder.adapterPosition].SdntCost
        holder.idText.text = dataArrayList[holder.adapterPosition].Sdntid.toString()
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val personName: TextView
        val personLevel: TextView
        val personCost: TextView
        val idText: TextView

        init {
            personName = itemView.findViewById(R.id.studentName)
            personLevel = itemView.findViewById(R.id.classText)
            personCost = itemView.findViewById(R.id.costText)
            idText = itemView.findViewById(R.id.idTextView)
        }

    }
}