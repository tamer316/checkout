package service

import domain.{Apple, Orange, Product}

object ProductService extends ProductService

trait ProductService {
  def findProduct(name: String): Product = {
    name match {
      case "Apple" => Apple
      case "Orange" => Orange
      case _ => throw ProductNotFoundException(s"$name is not a valid product")
    }
  }
}
