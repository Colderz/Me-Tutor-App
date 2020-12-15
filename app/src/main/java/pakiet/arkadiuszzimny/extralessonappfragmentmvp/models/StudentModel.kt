package pakiet.arkadiuszzimny.extralessonappfragmentmvp.models

import android.util.Log
import com.google.firebase.database.DataSnapshot

class StudentModel{

    fun initStudentLists(dtsnShot: DataSnapshot) {
        var listOfItems: ArrayList<DatabaseRow> = ArrayList()
        for (i in dtsnShot.children) {
            val newId = i.key!!.toLong()
            Log.d("infoid", "O to id chodzi: ${newId}")
            val newRow = i.getValue(DatabaseRow::class.java)
            listOfItems.add(newRow!!)
        }


    }

}