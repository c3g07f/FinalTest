package cn.edu.finaltest.ui.music

import android.media.MediaPlayer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MusicViewModel : ViewModel() {
    val mediaPlayer = MediaPlayer()
    val musicList = mutableListOf<String>()
    val musicNameList = mutableListOf<String>()
    var current = 0
    var isPause = false
    val Channel_ID = "my channel"
    val Notification_ID = 1

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}