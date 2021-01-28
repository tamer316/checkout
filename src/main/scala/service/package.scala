package object service {
  case class ProductNotFoundException(message: String) extends Exception
}
