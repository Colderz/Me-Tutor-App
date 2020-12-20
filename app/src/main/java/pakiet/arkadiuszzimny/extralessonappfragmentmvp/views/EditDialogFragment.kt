package pakiet.arkadiuszzimny.extralessonappfragmentmvp.views

import android.icu.text.CaseMap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_layout.view.*
import pakiet.arkadiuszzimny.extralessonappfragmentmvp.R

class EditDialogFragment: DialogFragment() {

    companion object {

        const val TAG = "EditDialog"
        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_SUBTITLE = "KEY_SUBTITLE"

        fun newInstance(title: String, subTitle: String): EditDialogFragment {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_SUBTITLE, subTitle)
            val fragment = EditDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupClickListeners(view)
    }

    private fun setupView(view: View) {
        view.dialogName.text = arguments?.getString(KEY_TITLE)
        view.subTitle.text = arguments?.getString(KEY_SUBTITLE)
    }

    private fun setupClickListeners(view: View) {
        view.cancelButton.setOnClickListener {
            dismiss()
        }
        view.saveButton.setOnClickListener {
            // TODO: Do some task here
        }
    }

}