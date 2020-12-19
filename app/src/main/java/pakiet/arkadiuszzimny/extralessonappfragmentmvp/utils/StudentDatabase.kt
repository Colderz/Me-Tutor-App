package pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils

import android.content.Context
import android.support.v4.os.IResultReceiver
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.StudentDAO
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun studentDao(): StudentDAO

    companion object{
        private var instance: StudentDatabase? = null

        //Singleton
        fun getInstance(context: Context): StudentDatabase? {
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "student_table")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

        fun deleteInstanceOfDatabase() {
            instance = null
        }

    }

}