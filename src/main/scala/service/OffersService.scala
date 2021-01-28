package service

import domain.{ApplesOffer, Offer, OrangesOffer, Product}

object OffersService extends OffersService {
  val offers = Seq(ApplesOffer, OrangesOffer)
}

trait OffersService {
  def offers: Seq[Offer]

  def getDiscount(products: Seq[Product]): BigDecimal =
    offers.map(offer => offer(products)).sum
}
