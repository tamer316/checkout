package domain

import org.specs2.mutable.Specification

class OrangesOfferSpec extends Specification {
  val offer = OrangesOffer

  "apply should" >> {
    "return zero if product list has only one orange" >> {
      offer(Seq(Orange)) mustEqual BigDecimal("0.0")
    }
    "return zero if product list has two oranges" >> {
      offer(Seq(Orange, Orange)) mustEqual BigDecimal("0.0")
    }
    "return price of one orange if product list has three oranges" >> {
      offer(Seq(Orange, Orange, Orange)) mustEqual BigDecimal("0.25")
    }
    "return price of two oranges if product list has seven oranges" >> {
      offer(Seq(Orange, Orange, Orange, Orange, Orange, Orange, Orange)) mustEqual BigDecimal("0.5")
    }
    "return price of two oranges if product list has three apples and six oranges" >> {
      offer(Seq(Apple, Apple, Orange, Orange, Orange, Orange, Orange, Orange, Apple)) mustEqual BigDecimal("0.5")
    }
  }
}
