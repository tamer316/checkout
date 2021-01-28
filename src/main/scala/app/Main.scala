package app

import service.CheckoutService

object Main {
  val checkoutService = CheckoutService()

  def main(args: Array[String]) = {
    println(checkoutService.getTotalCost(Seq("Apple", "Apple", "Orange", "Apple")))
  }
}
