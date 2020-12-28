package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentOneVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.models.Student
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.FragmentOnePresenter
import java.util.*

class FragmentOne : BaseFragment(), IFragmentOneVP.View {

    companion object {
        fun newInstance() = FragmentOne()
    }

    private lateinit var fragmentOnePresenter: FragmentOnePresenter
    private lateinit var listOfPeople: LiveData<List<Student>>
    private lateinit var recyclerView: RecyclerView
    private lateinit var daoAdapter: MainAdapterRV

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fm = fragmentManager
        fragmentOnePresenter = FragmentOnePresenter(requireActivity().application)
        var mView: View = inflater.inflate(R.layout.fragment_first, container, false)
        recyclerView = mView.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        listOfPeople = fragmentOnePresenter.getAllPeople()
        listOfPeople.observe(this, Observer {
            if (it.isNotEmpty()) {
                daoAdapter = MainAdapterRV(it, fm!!, fragmentOnePresenter)
                recyclerView.adapter = daoAdapter
            }
        })
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonAdd.setOnClickListener {
            triggerAddition()
            studentName.text.clear()
        }
    }

    private fun triggerAddition() {
        val student = Student(studentName.text.toString(), "No level", "Lack", Date().time.toString())
        fragmentOnePresenter.insertStudent(student)
    }


    override fun onResume() {
        super.onResume()
        setImage(this, fragmentOneProgressBar, secondMainImage)
    }

    fun setImage(fragment: BaseFragment, progressBar: ProgressBar, imageView: ImageView) {
        fragmentOnePresenter.loadImageUsingGlide(fragment, progressBar, imageView)
    }

    private var simpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            fragmentOnePresenter.swipeToDelete(viewHolder, direction)
        }

    }


}