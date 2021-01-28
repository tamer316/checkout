package service

import domain.{Apple, Orange}
import org.specs2.mutable.Specification

class ProductServiceSpec extends Specification with ProductService {
  "findProduct should" >> {
    "find Apple product" >> {
      findProduct("Apple") mustEqual Apple
    }
    "find Orange product" >> {
      findProduct("Orange") mustEqual Orange
    }
    "throw exception when product does not exist" >> {
      findProduct("test") must throwA[ProductNotFoundException]
    }
  }
}
