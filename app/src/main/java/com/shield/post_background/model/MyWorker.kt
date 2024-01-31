package com.shield.post_background.model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.shield.post_background.viewModel.MainViewModel

class MyWorker(appContext: Context, workerParams: WorkerParameters): Worker(appContext,workerParams) {
    private val application: Application
        get() = applicationContext as Application

    override fun doWork(): Result {

        val phone = inputData.getString("ph")
        val lastChunk = inputData.getString("ld")
        val netSpeed = inputData.getLong("ns",0)
        val battery = inputData.getLong("bs",0)
        val bytes = inputData.getLong("fb", 0)
        val bandwidth = inputData.getLong("ub", 0)
        val sendData = BodyData(phone, netSpeed, battery, bytes, bandwidth, lastChunk)

        val mainViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
        mainViewModel.fetchData(sendData,applicationContext)
        return Result.success()
    }
}