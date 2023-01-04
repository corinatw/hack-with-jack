package resources.input

case class PhoneData(id: String,
                     model: Option[String],
                     color: Option[String],
                     accessories: Option[Boolean],
                     price: Option[BigDecimal]) {}
