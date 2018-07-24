

  class Point(var x: Int, var y: Int) {

    override def equals(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }

    def equalsComparison(other: Any) = other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  val p1 = new Point(1, 2)

  val coll1 = scala.collection.mutable.HashSet(p1)
  coll1 contains p1
  p1.x += 1
  coll1 contains p1
  coll1.iterator contains p1

