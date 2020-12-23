//package cn.edu.finaltest.ui.music
//
//import android.Manifest
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.media.MediaPlayer
//import android.os.Build
//import android.os.Bundle
//import android.provider.MediaStore
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.SeekBar
//import android.widget.TextView
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import androidx.core.content.ContextCompat.getSystemService
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProviders
//import cn.edu.finaltest.MainActivity
//import cn.edu.finaltest.R
//import kotlinx.android.synthetic.main.fragment_music.*
//import java.io.IOException
//import kotlin.concurrent.thread
//
//class MusicFragment : Fragment() {
//
//    private lateinit var musicViewModel: MusicViewModel
//    val mediaPlayer = MediaPlayer()
//    val musicList = mutableListOf<String>()
//    val musicNameList = mutableListOf<String>()
//    var current = 0
//    var isPause = false
//    val Channel_ID = "my channel"
//    val Notification_ID = 1
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        musicViewModel =
//            ViewModelProviders.of(this).get(MusicViewModel::class.java)
////        button.setOnClickListener {
////
////            val notificationManager =
////                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
////            val builder: Notification.Builder
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
////                val notificationChannel =
////                    NotificationChannel(Channel_ID, "music", NotificationManager.IMPORTANCE_DEFAULT)
////                notificationManager.createNotificationChannel(notificationChannel)
////                builder = Notification.Builder(this, Channel_ID)
////            } else {
////                builder = Notification.Builder(this)
////            }
////            val intent = Intent(this, MusicFragment::class.java)
////            val pendingIntent =
////                PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT)
////
////            val notification = builder.setSmallIcon(R.drawable.ic_nomusic)
////                .setContentTitle("${musicNameList[current]}")
////                .setContentText("${current + 1}/${musicList.size}")
////                .setContentIntent(pendingIntent)
////                .setAutoCancel(true)
////                .build()
////            notificationManager.notify(Notification_ID, notification)
////        }
//        mediaPlayer.setOnPreparedListener {
//            it.start()
//        }
//        mediaPlayer.setOnCompletionListener {
//            current++
//            if (current >= musicList.size) {
//                current = 0
//            }
//            play()
//        }
//        if (ContextCompat.checkSelfPermission(
//                this,Manifest.permission.READ_EXTERNAL_STORAGE
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                0
//            )
//        } else {
//            getMusicList()
//        }
//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                if (fromUser) {
//                    mediaPlayer.seekTo(progress)
//                }
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//
//            }
//        })
//        thread {
//            while (true) {
//                Thread.sleep(1000)
//                runOnUiThread {
//                    seekBar.max = mediaPlayer.duration
//                    seekBar.progress = mediaPlayer.currentPosition
//                }
//            }
//        }
//
//    }
//    fun onPlay(v: View) {
//        play()
//    }
//
//    fun onPause(v: View) {
//        if (isPause) {
//            mediaPlayer.start()
//            isPause = false
//        } else {
//            mediaPlayer.pause()
//            isPause = true
//        }
//    }
//
//    fun onStop(v: View) {
//        mediaPlayer.stop()
//    }
//
//    fun onNext(v: View) {
//        current++
//        if (current >= musicList.size) {
//            current = 0
//        }
//        play()
//    }
//
//    fun onPrev(v: View) {
//        current--
//        if (current < 0) {
//            current = musicList.size - 1
//        }
//        play()
//    }
//
//    fun play() {
//        if (musicList.size == 0) return
//        val path = musicList[current]
//        mediaPlayer.reset()
//        try {
//            mediaPlayer.setDataSource(path)
//            mediaPlayer.prepareAsync()
//            textView_mn.text = musicNameList[current]
//            textView_count.text = "${current + 1}/${musicList.size}"
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//    }
//
//    fun getMusicList() {
//        val cursor = contentResolver.query(
//            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
//            null,
//            null,
//            null,
//            null
//        )
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                val musicPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
//                musicList.add(musicPath)
//                val musicName =
//                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
//                musicNameList.add(musicName)
//            }
//            cursor.close()
//        }
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mediaPlayer.release()
//    }
//}
//
//
