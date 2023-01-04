package edition1

case class Phone(model: Option[String] = None, color: Option[String] = None, isAccessories: Option[Boolean] = None) {

  def displayText(): String = {
    val defaultText = "I am interested in buying a new phone:\n"
    val modelPhone = List(("Model", model), ("Color", color), ("Accessories included", isAccessories),
    "Year", None).collect{
      case (key, Some(value:Boolean)) => if(value) s"$key: yes" else s"$key: no"
      //List("Model: Iphone", "Color: red")
      case (key, Some(value)) => s"$key: $value"
    }.mkString("\n")
    val modelPhoneFinal = modelPhone match {
      case "" => "No information available"
      case something => something
    }

    defaultText + modelPhoneFinal
  }
}
