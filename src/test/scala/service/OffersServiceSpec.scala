package service

import domain.{Apple, ApplesOffer, Orange, OrangesOffer}
import org.specs2.mutable.Specification

class OffersServiceSpec extends Specification with OffersService {

  val offers = Seq(ApplesOffer, OrangesOffer)

  "getDiscount should" >> {
    "return price of two apples if product list has four apples" >> {
      getDiscount(Seq(Apple, Apple, Apple, Apple)) mustEqual BigDecimal("1.2")
    }
    "return price of one orange if product list has three oranges" >> {
      getDiscount(Seq(Orange, Orange, Orange)) mustEqual BigDecimal("0.25")
    }
    "return price of one apple and one orange if product list has two apples and three oranges" >> {
      getDiscount(Seq(Apple, Orange, Apple, Orange, Orange)) mustEqual BigDecimal("0.85")
    }
  }
}
