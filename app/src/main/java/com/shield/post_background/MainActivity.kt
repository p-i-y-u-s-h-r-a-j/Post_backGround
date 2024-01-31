package com.shield.post_background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.work.Data
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.shield.post_background.databinding.ActivityMainBinding
import com.shield.post_background.model.BodyData
import com.shield.post_background.viewModel.MainViewModel
import androidx.work.PeriodicWorkRequestBuilder
import com.shield.post_background.model.MyWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val workManager = WorkManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sendData = BodyData("7970404162",220,99,121,25,"12:15:35")

        val inputData = Data.Builder()
            .putString("p",sendData.nodeId)
            .putLong("ns", sendData.networkSpeed!!)
            .putLong("bs",sendData.batteryStatus!!)
            .putLong("fb",sendData.freeBytes!!)
            .putLong("ub",sendData.usedBandwidth!!)
            .putString("ld",sendData.lastChunkDownloadTime)
            .build()
        val periodicWorkRequest = PeriodicWorkRequestBuilder<MyWorker>(
            15,
            TimeUnit.MINUTES
        ).setInputData(inputData)
            .build()
        workManager.enqueue(periodicWorkRequest)
    }
}