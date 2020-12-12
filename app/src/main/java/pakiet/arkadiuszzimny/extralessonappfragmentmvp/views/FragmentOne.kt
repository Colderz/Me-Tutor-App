package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_first.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.interfaces.IFragmentOneVP
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.presenters.FragmentOnePresenter

class FragmentOne : BaseFragment(), IFragmentOneVP.View {

    companion object {
        fun newInstance() = FragmentOne()
    }

    private lateinit var fragmentOnePresenter: FragmentOnePresenter
    private lateinit var recyclerAdapter: MainAdapterRV

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var mView: View = inflater.inflate(R.layout.fragment_first, container, false)
        var rv:RecyclerView = mView.findViewById(R.id.recyclerView)
        rv.layoutManager
        recyclerAdapter = MainAdapterRV()
        rv.adapter = MainAdapterRV()
        fragmentOnePresenter = FragmentOnePresenter()
        fragmentOnePresenter.initData()

        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonAdd.setOnClickListener {
            triggerAddition()
            studentName.text.clear()
        }
    }

    private fun triggerAddition() {
        fragmentOnePresenter.addFirebaseData(studentName.text.toString())
    }


    override fun onResume() {
        super.onResume()
        setImage(this, fragmentOneProgressBar, secondMainImage)
    }

    fun setImage(fragment: BaseFragment, progressBar: ProgressBar, imageView: ImageView) {
        fragmentOnePresenter.loadImageUsingGlide(fragment, progressBar, imageView)
    }


}