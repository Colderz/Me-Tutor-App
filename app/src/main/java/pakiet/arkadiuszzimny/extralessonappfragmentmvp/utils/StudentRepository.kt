package pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils

import android.app.Application
import android.icu.text.Transliterator
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.StudentDAO
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student

class StudentRepository(application: Application) {

    private var studentDao: StudentDAO

    init {
        val database: StudentDatabase? = StudentDatabase.getInstance(application.applicationContext)

        studentDao = database!!.studentDao()
    }

    fun insertStudent(student: Student): Job = CoroutineScope(Dispatchers.IO).launch { studentDao.insert(student) }

    fun updateStudent(student: Student) =  CoroutineScope(Dispatchers.IO).launch { studentDao.update(student) }

    fun deleteStudent(randomId: String) = CoroutineScope(Dispatchers.IO).launch { studentDao.delete(randomId) }

    fun getAllStudentsAsync(): Deferred<LiveData<List<Student>>> = CoroutineScope(Dispatchers.IO).async { studentDao.getAllStudents() }

    fun deleteAllRows() = CoroutineScope(Dispatchers.IO).launch { studentDao.deleteAllRows() }

}