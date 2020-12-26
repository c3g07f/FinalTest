package cn.edu.finaltest.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewViewModel : ViewModel() {
    private val _feature = MutableLiveData<String>()
    private val _text = MutableLiveData<String>()
    val text:LiveData<String> = _text
    val feature: LiveData<String> = _feature
    fun getLanguage(feature : String) : String = when(feature){
        "你好" -> "好"
        "大家好" -> "真好"
        "你们好" -> "真的好"
        "对象好" -> "太好了"
        else -> "unknow"
    }
}