package pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentOneVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.utils.FirebaseManager
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.views.BaseFragment
import java.util.*
import kotlin.collections.ArrayList

class FragmentOnePresenter: IFragmentOneVP.Presenter {

    private lateinit var fireManager: FirebaseManager
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
        var studentList: ArrayList<Student> = ArrayList<Student>()
        studentList.add(Student(1, "Klaudia", "III Liceum", "30 zł"))
        fireManager = FirebaseManager("ArrayData")
    }

    fun addFirebaseData(name: String) {
        val level = "No level of learning"
        val cost = "Lack"
        fireManager.addData(Date().time, name, level, cost)
    }





}