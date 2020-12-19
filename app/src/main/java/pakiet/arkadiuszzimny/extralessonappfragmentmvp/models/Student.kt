package pakiet.arkadiuszzimny.extralessonappfragmentmvp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(var name: String, var level: String, var cost: String) {

    @PrimaryKey(autoGenerate = true)
    var user_id: Int = 0

}



