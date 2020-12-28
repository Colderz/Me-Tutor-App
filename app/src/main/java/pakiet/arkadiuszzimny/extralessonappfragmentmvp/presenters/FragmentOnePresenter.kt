package pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters

import android.app.Application
import android.graphics.drawable.Drawable
import android.icu.text.Transliterator
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentOneVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils.StudentRepository
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.MainAdapterRV

class FragmentOnePresenter(application: Application): IFragmentOneVP.Presenter {

    private var studentRepository: StudentRepository = StudentRepository(application)
    private var allStudent: Deferred<LiveData<List<Student>>> = studentRepository.getAllStudentsAsync()
    private val imageUrl_1 = "https://images.unsplash.com/photo-1521927336940-cae6e9f22945?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"

    override fun loadImageUsingGlide(
        fragment: BaseFragment,
        progressBar: ProgressBar,
        imageView: ImageView)
    {
        progressBar.visibility = View.VISIBLE
        Glide.with(fragment).load(imageUrl_1).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.visibility = View.VISIBLE
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.visibility = View.INVISIBLE
                return false
            }
        }).into(imageView)
    }

    override fun initData() {

    }


    fun insertStudent(student: Student) {
        studentRepository.insertStudent(student)
    }

    fun updateStudent(student: Student) {
        studentRepository.updateStudent(student)
    }

    fun deleteStudent(randomId: String) {
        studentRepository.deleteStudent(randomId)
    }

    //Coroutine
    fun getAllPeople(): LiveData<List<Student>> = runBlocking {
        allStudent.await() //suspended function
    }

    fun deleteAllRows() {
        studentRepository
    }

    fun swipeToDelete(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        var position = viewHolder.adapterPosition
        when(direction) {
            ItemTouchHelper.LEFT -> {

            }
        }
    }


}