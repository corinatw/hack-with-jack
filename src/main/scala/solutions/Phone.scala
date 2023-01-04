package solutions

import resources.input.PhoneData

case class Phone(model: Option[String] = None, color: Option[String] = None, isAccessories: Option[Boolean] = None){

    val initialDefaultText = "I am interested in buying a new phone:"

  //Exercise 1
    def displayText() = {
      val phoneDetails = createTextWithPhoneDetails()
      phoneDetails match {
        case head :: Nil => head + "\nNo information available"
        case values => values.mkString("\n")
      }
    }

    def createTextWithPhoneDetails() = {
      List(initialDefaultText, ("Model", model), ("Color", color), ("Accessories included", isAccessories)).
        collect {
          case (key, Some(true)) => s"$key: yes"
          case (key, Some(false)) => s"$key: no"
          case (key, Some(value)) => s"$key: $value"
          case value: String => s"$value"
        }
    }
}



//Exercise 2
object Phone {
  def of(phoneData: PhoneData): Phone = {
    Phone(phoneData.model, phoneData.color, phoneData.accessories)
  }
}