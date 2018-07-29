package services

import models.{Inventory, Item, Price}

trait BackendServices {

  def addItemInInventory(inventory: models.Inventory, name:String,photo: String,vendor:Long,category:String,price: Double,stock : Int)={


  }
}