package app

import service.{CheckoutService, OffersService, ProductService}

object Main {
  val checkoutService = new CheckoutService(ProductService, OffersService)

  def main(args: Array[String]) = {
    println(checkoutService.getTotalCost(Seq("Apple", "Apple", "Orange", "Apple")))
  }
}
