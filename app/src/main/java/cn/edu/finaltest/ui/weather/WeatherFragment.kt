package cn.edu.finaltest.ui.weather

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import cn.edu.finaltest.R
import kotlinx.android.synthetic.main.fragment_weather.*

class WeatherFragment : Fragment() {

    private lateinit var viewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            return inflater.inflate(R.layout.fragment_weather,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        viewModel.cities.observe(viewLifecycleOwner, Observer {
            val cities = it
            val adapter = activity?.let { it1 -> ArrayAdapter<CityItem>(it1, android.R.layout.simple_list_item_1,cities) }
            listView.adapter = adapter
            listView.setOnItemClickListener { adapterView, view, i, l ->

                val cityCode = cities[i].city_code
                val intent = Intent(activity, WeatherActivity::class.java)
                intent.putExtra("city_code", cityCode)
                startActivity(intent)
            }
        })
    }

}