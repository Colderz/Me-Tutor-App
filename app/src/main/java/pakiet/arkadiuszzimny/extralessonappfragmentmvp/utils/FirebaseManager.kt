package pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils

import com.google.firebase.database.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.DatabaseRow
import java.util.*

class FirebaseManager(pathName: String) {

    var firebase: FirebaseDatabase
    var pathName = pathName

    init {
        firebase = FirebaseDatabase.getInstance()
        getReference().addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    val newId = i.key!!.toLong()
                    val newRow = i.getValue()
                }
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