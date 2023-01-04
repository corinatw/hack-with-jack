package solutions

import resources.input.ContactRequest
import resources.output.Message

class MessageModelFactory {

  def sendMessage(contactRequest: ContactRequest, isPhoneIncluded: Boolean): Option[Message] = {
    val phone = addPhoneToMessage(contactRequest, isPhoneIncluded)
    val message = Message(contactRequest.id, phone)
    println("Sending message " + message.id)
    Some(message)
  }

  def addPhoneToMessage(contactRequest: ContactRequest, isPhoneIncluded: Boolean): Option[Phone] = {
    contactRequest.phoneData.flatMap(phone =>
      isPhoneIncluded match {
        case true => Some(Phone.of(phone))
        case false => None
      })

  }

}
