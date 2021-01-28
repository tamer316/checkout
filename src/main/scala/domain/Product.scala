package domain

sealed trait Product {
  def name: String
  def price: BigDecimal
}

object Apple extends Product {
  val name = "Apple"
  val price = BigDecimal("0.60")
}

object Orange extends Product {
  val name = "Orange"
  val price = BigDecimal("0.25")
}
