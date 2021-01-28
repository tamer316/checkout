package service

import java.text.NumberFormat
import java.util.Locale

class CheckoutService(productService: ProductService, offersService: OffersService) {
  private val formatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale.UK)

  def getTotalCost(productNames: Seq[String]): String = {
    val products = productNames map productService.findProduct

    val total = products.map(_.price).sum

    val discount = offersService.getDiscount(products)

    formatter.format(total - discount)
  }
}
