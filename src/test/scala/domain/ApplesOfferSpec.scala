package domain

import org.specs2.mutable.Specification

class ApplesOfferSpec extends Specification {
  val offer = ApplesOffer

  "apply should" >> {
    "return zero if product list has only one apple" >> {
      offer(Seq(Apple)) mustEqual BigDecimal("0.0")
    }
    "return price of one apple if product list has two apples" >> {
      offer(Seq(Apple, Apple)) mustEqual BigDecimal("0.6")
    }
    "return price of three apples if product list has five apples" >> {
      offer(Seq(Apple, Apple, Apple, Apple, Apple)) mustEqual BigDecimal("1.2")
    }
    "return price of three apples if product list has six apples and two oranges" >> {
      offer(Seq(Apple, Apple, Apple, Orange, Orange, Apple, Apple, Apple)) mustEqual BigDecimal("1.8")
    }
  }
}
