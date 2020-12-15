package pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces

import com.google.firebase.database.DataSnapshot
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student

interface IStudentModel {
    fun initStudentLists(dtsnShot: DataSnapshot)
    fun initLists()
    fun getDisplayList() : ArrayList<Student>
}