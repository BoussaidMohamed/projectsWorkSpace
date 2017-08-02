package taginstore.apackage.com.pokemonandroid

import android.location.Location

class Pokemon{
    var name:String?=null
    var desc:String?=null
    var image:Int?=null
    var power:Double?=null
    var lat:Double?=null
    var longi:Double?=null
    var isCatched:Boolean?=false
    var location:Location?=null
    constructor(image:Int,name:String,desc:String,power:Double,lat:Double,longi:Double){
        this.image=image
        this.desc=desc
        this.name=name
        this.power=power
        this.isCatched=false
        this.location= Location(name)
        this.location!!.latitude = lat
        this.location!!.longitude = longi
    }
}