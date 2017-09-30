package taginstore.packag.com.mynote

class Note{

    var nodeID:Int?=null
    var nodeName:String?=null
    var nodeDes:String?=null

    constructor(nodeID:Int,nodeName:String,nodeDes:String){
        this.nodeDes=nodeDes
        this.nodeID=nodeID
        this.nodeName=nodeName
    }
}