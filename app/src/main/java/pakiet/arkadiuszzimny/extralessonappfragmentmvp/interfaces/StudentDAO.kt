package pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student

@Dao
interface StudentDAO {

    @Insert
    fun insert(student: Student)

    @Update
    fun update(student: Student)

    @Query("DELETE FROM student_table WHERE randomId = :randomId")
    fun delete(randomId: String)

    @Query("SELECT * FROM student_table")
    fun getAllStudents(): LiveData<List<Student>>

    @Query("DELETE FROM student_table")
    fun deleteAllRows()

}