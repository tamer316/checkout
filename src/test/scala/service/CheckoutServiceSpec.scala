package service

import domain.Offer
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class CheckoutServiceSpec extends Specification {

  trait NoOffersContext extends Scope {
    val offersService = new OffersService {
      def offers: Seq[Offer] = Seq.empty
    }
    val checkoutService = new CheckoutService(ProductService, offersService)
  }

  trait WithOffersContext extends Scope {
    val checkoutService = new CheckoutService(ProductService, OffersService)
  }

  "checkoutService.getTotalCost should" >> {
    "calculate correct price for one apple" in new NoOffersContext {
      checkoutService.getTotalCost(Seq("Apple")) mustEqual "£0.60"
    }
    "calculate correct price for one orange" in new NoOffersContext {
      checkoutService.getTotalCost(Seq("Orange")) mustEqual "£0.25"
    }
    "calculate correct price for three apples" in new NoOffersContext {
      checkoutService.getTotalCost(Seq("Apple", "Apple", "Apple")) mustEqual "£1.80"
    }
    "calculate correct price for three oranges" in new NoOffersContext {
      checkoutService.getTotalCost(Seq("Orange", "Orange", "Orange")) mustEqual "£0.75"
    }
    "calculate correct price for two apples and two oranges" in new NoOffersContext {
      checkoutService.getTotalCost(Seq("Apple", "Apple", "Orange", "Orange")) mustEqual "£1.70"
    }
    "throw exception if product is not recognised" in new NoOffersContext {
      checkoutService.getTotalCost(Seq("Apple", "Test")) must throwA[ProductNotFoundException]
    }

    "calculate correct price for two apples with offers" in new WithOffersContext {
      checkoutService.getTotalCost(Seq("Apple", "Apple")) mustEqual "£0.60"
    }
    "calculate correct price for three oranges with offers" in new WithOffersContext {
      checkoutService.getTotalCost(Seq("Orange", "Orange", "Orange")) mustEqual "£0.50"
    }
    "calculate correct price for four apples and six oranges with offers" in new WithOffersContext {
      checkoutService.getTotalCost(Seq("Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple")) mustEqual "£2.20"
    }
  }
}
