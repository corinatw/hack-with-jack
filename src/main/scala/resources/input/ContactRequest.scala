package resources.input

case class ContactRequest(id: String,
                          phoneData: Option[PhoneData]) {}
