package domain

sealed trait Offer {
  // Returns the Discount to be applied for a list of Products
  def apply(products: Seq[Product]): BigDecimal
}

object ApplesOffer extends Offer {
  def apply(products: Seq[Product]): BigDecimal = {
    val numOfApples = products.count(_ == Apple)
    val numOfApplesToRemove = (numOfApples - (numOfApples % 2)) / 2

    numOfApplesToRemove * Apple.price
  }
}

object OrangesOffer extends Offer {
  def apply(products: Seq[Product]): BigDecimal = {
    val numOfOranges = products.count(_ == Orange)
    val numOfOrangesToRemove = (numOfOranges - (numOfOranges % 3)) / 3

    numOfOrangesToRemove * Orange.price
  }
}
