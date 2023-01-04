package resources.input

case class ContactRequest(id: String,
                          phoneData: Option[PhoneData] = None,
                          clientData: Option[ClientData] = None) {}
