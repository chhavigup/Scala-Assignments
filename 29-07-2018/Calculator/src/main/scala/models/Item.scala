package models

case class Item(id :Long,name:String,photo: String,vendor:Vendor,category:String,price: Price,stock : Int)