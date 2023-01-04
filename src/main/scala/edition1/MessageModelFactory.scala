package edition1

import resources.input.ContactRequest
import resources.output.Message

class MessageModelFactory {

  def sendMessage(contactRequest: ContactRequest, isPhoneIncluded: Boolean): Option[Message] = {
    val message = Message(contactRequest.id, None)
    println("Sending message " + message.id)
    Some(message)
  }

}
