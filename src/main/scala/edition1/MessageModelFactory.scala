package edition1

import resources.input.ContactRequest
import resources.output.Message

class MessageModelFactory {

  def sendMessage(contactRequest: ContactRequest, isPhoneIncluded: Boolean): Option[Message] = {
    if(isPhoneIncluded){
      contactRequest.phoneData match {
        case Some(value) => Phone(value.model, value.color, value.accessories)
        case None => None
      }

      contactRequest.phoneData.flatMap(value =>
        Some(Phone(value.model, value.color, value.accessories)))
    }
    val message = Message(contactRequest.id, None)
    println("Sending message " + message.id)
    Some(message)
  }

}
