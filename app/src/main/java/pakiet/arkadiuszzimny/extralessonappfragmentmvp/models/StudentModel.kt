package pakiet.arkadiuszzimny.extralessonappfragmentmvp.models

class StudentModel{

    fun initStudentLists(dtbsRow: DatabaseRow) {
        var listOfItems: ArrayList<DatabaseRow> = ArrayList()
        listOfItems.add(dtbsRow)
    }

}