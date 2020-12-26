package cn.edu.finaltest.ui.view
import android.icu.util.ULocale.getLanguage
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cn.edu.finaltest.R
import kotlinx.android.synthetic.main.fragment_view.*

class ViewFragment : Fragment() {

    private lateinit var viewViewModel: ViewViewModel
    private val text = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view, container, false)
    }
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewViewModel =
            ViewModelProvider(this).get(ViewViewModel::class.java)
        viewViewModel.feature.observe(viewLifecycleOwner, Observer {
            textView4.text = it
        })
        button4.setOnClickListener(){
            textView4.text = getLanguage(spinner2.selectedItem.toString())
        }

        button2.setOnClickListener{
            val txt = TextView(this.context)
            txt.layoutParams = text
            txt.text =getString(R.string.addTextView)
            txt.textSize = 30f
            linearLayout3.addView(txt, text)
        }
    }
}