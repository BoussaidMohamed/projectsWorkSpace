package taginstore.apackage.com.pokemonandroid

class Pokemon{
    var name:String?=null
    var desc:String?=null
    var image:Int?=null
    var power:Double?=null
    var lat:Double?=null
    var longi:Double?=null
    var isCatched:Boolean?=false
    constructor(image:Int,name:String,desc:String,power:Double,lat:Double,longi:Double){
        this.image=image
        this.desc=desc
        this.name=name
        this.power=power
        this.lat=lat
        this.longi=longi
        this.isCatched=false
    }
}