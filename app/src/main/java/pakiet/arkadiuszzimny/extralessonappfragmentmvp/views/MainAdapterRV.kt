package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.view.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.FragmentOnePresenter

class MainAdapterRV(private val dataArrayList: List<Student>, private val fm: FragmentManager, private val presenter: FragmentOnePresenter): RecyclerView.Adapter<MainAdapterRV.ViewHolder>() {
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
            itemView.setOnClickListener {
                var dialogInstance = EditDialogFragment.newInstance(personName.text.toString(), "Editing", presenter)
                dialogInstance.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.CustomDialog)
                dialogInstance.show(fm, EditDialogFragment.TAG)
            }
        }

    }
}