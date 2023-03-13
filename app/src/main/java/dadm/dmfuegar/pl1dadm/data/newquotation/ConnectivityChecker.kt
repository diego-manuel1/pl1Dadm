package dadm.dmfuegar.pl1dadm.data.newquotation

import android.net.ConnectivityManager
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import javax.inject.Inject

class ConnectivityChecker @Inject constructor(val conManager: ConnectivityManager) {
    fun isConnectionAvalilable() : Boolean{
        val capabilities = conManager.getNetworkCapabilities(conManager.activeNetwork)
        return capabilities!=null && (capabilities.hasTransport(TRANSPORT_WIFI) || capabilities.hasTransport(TRANSPORT_CELLULAR))
    }
}