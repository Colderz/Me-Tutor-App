package pakiet.arkadiuszzimny.extralessonappfragmentmvp.models

import com.google.firebase.database.DataSnapshot
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IStudentModel

class StudentModel: IStudentModel{

    init {
        initLists()
    }

    private lateinit var listOfItems: ArrayList<DatabaseRow>
    private lateinit var listOfStudents: ArrayList<Student>
    private lateinit var displayList: ArrayList<Student>

    override fun initStudentLists(dtsnShot: DataSnapshot) {
        for (i in dtsnShot.children) {
            val newId = i.key!!.toLong()
            val newRow = i.getValue(DatabaseRow::class.java)
            listOfItems.add(newRow!!)
            listOfStudents.add(Student(newId, newRow.name, newRow.level, newRow.cost))
        }
        displayList.addAll(listOfStudents)
        displayList.sortBy { it.SdntName }
    }

    override fun initLists() {
        listOfItems = ArrayList()
        listOfStudents = ArrayList()
        displayList = ArrayList()
    }

    override fun getDisplayList(): ArrayList<Student> {
        return displayList
    }
}