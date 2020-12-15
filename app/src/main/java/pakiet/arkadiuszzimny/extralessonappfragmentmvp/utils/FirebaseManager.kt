package pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils

import android.util.Log
import com.google.firebase.database.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.DatabaseRow
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.StudentModel
import java.util.*

class FirebaseManager(pathName: String) {

    val firebase: FirebaseDatabase
    val pathName = pathName
    val studentModel: StudentModel

    init {
        firebase = FirebaseDatabase.getInstance()
        studentModel = StudentModel()
        getReference().addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                studentModel.initStudentLists(snapshot)
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun getReference(): DatabaseReference {
        return firebase.getReference(this.pathName)
    }

    fun addData(id: Long, name: String, level: String, cost: String) {
        val firebaseInput = DatabaseRow(name, level, cost)
        getReference().child("${id}").setValue(firebaseInput)
    }

}