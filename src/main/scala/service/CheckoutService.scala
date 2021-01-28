package service

import java.text.NumberFormat
import java.util.Locale

class CheckoutService(productService: ProductService) {
  private val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale.UK)

  def getTotalCost(productNames: Seq[String]): String = {
    val products = productNames map(productService.findProduct)

    val total = products.map(_.price).sum

    formatter.format(total)
  }
}

object CheckoutService {
  def apply(): CheckoutService = new CheckoutService(ProductService)
}
