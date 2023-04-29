package io.chucker

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissions = arrayOf(Manifest.permission.POST_NOTIFICATIONS)
            ActivityCompat.requestPermissions(
                this,
                permissions,
                1
            )
        }

        val call: Call<List<Hero>> =
            RetrofitClient.getIntstance(this).myApi.heroes as Call<List<Hero>>
        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
            }
        })
    }
}