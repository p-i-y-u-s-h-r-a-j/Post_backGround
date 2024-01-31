package com.shield.post_background.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shield.post_background.api.ApiInterface
import com.shield.post_background.api.ApiUtility
import com.shield.post_background.model.BodyData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application): AndroidViewModel(application) {
    fun fetchData(sendData: BodyData, context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            val apiService = ApiUtility.getInstance().create(ApiInterface::class.java)
            val res = apiService.getData(sendData)
            if(res.isSuccessful){
                viewModelScope.launch(Dispatchers.Main){
//                    Toast.makeText(context,"${res.body()?.accessChunkStatus}",Toast.LENGTH_SHORT).show()
                    Log.i("FOUND DATA","${res.body()?.accessChunkStatus}")
                }
            }
            else{
                viewModelScope.launch(Dispatchers.Main){
//                    Toast.makeText(context,"Cannot Fetch Data",Toast.LENGTH_SHORT).show()
                    Log.i("DataError","${res.body()?.accessChunkStatus}")
                }
            }

        }
    }
}