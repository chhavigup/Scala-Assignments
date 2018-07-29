package services

import models.{Inventory, Item, Price}

import scala.concurrent.Future

trait InventoryServices {

  def sortByPrice(inventory: Inventory,sortBy:String):Inventory={
    val sortedListOfItems = inventory.item.sortBy(_.price.cost)
    if(sortBy.equalsIgnoreCase("LowToHigh")){
      Inventory(sortedListOfItems)
    }
    else{
      Inventory(sortedListOfItems.reverse)
    }
  }

  def searchItem(inventory: Inventory,categoryName:String,itemName:String,filter:Option[String]): Future[List[Item]] = Future{

    val filteredList : List[Item]= inventory.item.filter(_.category == categoryName).filter(_.name==itemName)
    if(filteredList.isEmpty)
      throw new NoSuchElementException

    filter match {
      case Some(filters)=> sortByPrice(Inventory(filteredList),filters).item
      case None => filteredList
    }
  }

  def returnPrice(inventory: Inventory,id:Long): Future[Price] =Future{
    inventory.item.filter(_.id==id).head.price
  }

  def updateItemCount(inventory: Inventory,itemId:Long,count:Int,f:(Int,Int)=>Int): Future[Item] =Future{

    val item:Option[Item] = inventory.item.find(_.id== itemId)

    item match {
      case Some(item)=> {
        val updateStock:Int = f(item.stock,count)
        val updatedItem:Item = item.copy(stock=updateStock)
        updatedItem
      }
      case None => throw new NoSuchElementException
    }
  }
}
