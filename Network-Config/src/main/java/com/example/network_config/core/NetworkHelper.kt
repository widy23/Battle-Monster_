package com.example.network_config.core

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkHelper {


    @SuppressLint("SuspiciousIndentation")
    fun checkNetworkConnection(context: Context):Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val networkCapabilities =connectivityManager.getNetworkCapabilities(network)
            return networkCapabilities != null && (networkCapabilities.hasTransport(
            NetworkCapabilities.TRANSPORT_ETHERNET) ||
                   networkCapabilities.hasTransport( NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            )
    }

}