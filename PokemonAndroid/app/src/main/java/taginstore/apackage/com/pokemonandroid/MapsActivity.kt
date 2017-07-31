package taginstore.apackage.com.pokemonandroid

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_maps.*


import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        CheckPermission()
        loadPokemon()
    }

    var ACCESS_LOCATION = 123

    fun CheckPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED)
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), ACCESS_LOCATION)

        }
        GetUserLocation();
    }

    fun GetUserLocation() {
        Toast.makeText(this, "User location access on", Toast.LENGTH_LONG).show()
        //TODO: Will implement later
        var myLocation = MyLocationListener()
        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3, 3f, myLocation)
        var GPSThread = myThread()
        GPSThread.start()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            ACCESS_LOCATION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    GetUserLocation()
            }
            else -> {
                Toast.makeText(this, "We cannot get your location", Toast.LENGTH_LONG).show()

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
    }


    var location: Location? = null
    var oldPosition:Location?=null

    //Get user Location
    inner class MyLocationListener : LocationListener {
        constructor() {
            location = Location("Start")
            location!!.longitude = 0.0
            location!!.latitude = 0.0
        }


        override fun onLocationChanged(p0: Location?) {
            location = p0
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(p0: String?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(p0: String?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
    public fun MoveToMyPosition(view:View){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(location!!.latitude, location!!.longitude), 16f))

    }

    //

    inner class myThread : Thread {
        constructor() : super() {

            oldPosition = Location("Start")
            oldPosition!!.longitude = 0.0
            oldPosition!!.latitude = 0.0
        }

        override fun run() {
            while (true) {
                try {
                    if(oldPosition!!.distanceTo(location)==0f){
                        continue
                    }
                    oldPosition=location

                    runOnUiThread {
                        mMap!!.clear()
                        val userCurrentPosition = LatLng(location!!.latitude, location!!.longitude)
                        mMap.addMarker(MarkerOptions()
                                .position(userCurrentPosition)
                                .title("My Position")
                                .snippet("My current Position")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mario))
                        )
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userCurrentPosition, 16f))
                        for (i in 0..listOfPokemon.size - 1) {
                            var newPokemon = listOfPokemon[i]
                            if (newPokemon.isCatched == false) {
                                val pokemonPosition = LatLng(newPokemon.lat!!, newPokemon.longi!!)
                                mMap.addMarker(MarkerOptions()
                                        .position(pokemonPosition)
                                        .title(newPokemon.name!!)
                                        .snippet(newPokemon.desc!!)
                                        .icon(BitmapDescriptorFactory.fromResource(newPokemon.image!!)))

                            }
                        }

                    }
                    Thread.sleep(1000)
                } catch (ex: Exception) {
                }

            }
        }

    }

    var listOfPokemon = ArrayList<Pokemon>()
    fun loadPokemon() {
        listOfPokemon.add(Pokemon(R.drawable.charmander2, "Charmander", "Pokemon of fire", 109.22, 48.803379, 2.057181))
        listOfPokemon.add(Pokemon(R.drawable.bulbasaur2, "Bulbasaur", "Pokemon of Earth", 99.22, 48.803399, 2.057866))
        listOfPokemon.add(Pokemon(R.drawable.squirtle, "Squirtle", "Pokemon of Water", 107.22, 48.803379, 2.059153))
    }

}
