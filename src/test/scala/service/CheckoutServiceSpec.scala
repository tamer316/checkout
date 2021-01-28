package service

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class CheckoutServiceSpec extends Specification {

  trait Context extends Scope {
    val checkoutService = CheckoutService()
  }

  "checkoutService.getTotalCost should" >> {
    "calculate correct price for one apple" in new Context {
      checkoutService.getTotalCost(Seq("Apple")) mustEqual "£0.60"
    }
    "calculate correct price for one orange" in new Context {
      checkoutService.getTotalCost(Seq("Orange")) mustEqual "£0.25"
    }
    "calculate correct price for three apples" in new Context {
      checkoutService.getTotalCost(Seq("Apple", "Apple", "Apple")) mustEqual "£1.80"
    }
    "calculate correct price for three oranges" in new Context {
      checkoutService.getTotalCost(Seq("Orange", "Orange", "Orange")) mustEqual "£0.75"
    }
    "calculate correct price for two apples and two oranges" in new Context {
      checkoutService.getTotalCost(Seq("Apple", "Apple", "Orange", "Orange")) mustEqual "£1.70"
    }
    "throw exception if product is not recognised" in new Context {
      checkoutService.getTotalCost(Seq("Apple", "Test")) must throwA[ProductNotFoundException]
    }
  }
}
