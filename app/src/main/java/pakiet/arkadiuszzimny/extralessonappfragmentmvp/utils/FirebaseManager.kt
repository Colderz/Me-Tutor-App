package pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils

import com.google.firebase.database.*
import java.util.*

class FirebaseManager(pathName: String) {

    var firebase: FirebaseDatabase
    var pathName = pathName

    init {
        firebase = FirebaseDatabase.getInstance()
        getReference().addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }

    fun getReference(): DatabaseReference {
        return firebase.getReference(this.pathName)
    }

    fun addData(id: Long, name: String) {
        getReference().child("${id}").setValue(name)
    }

}