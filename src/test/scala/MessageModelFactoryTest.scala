import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import resources.input.{ContactRequest, PhoneData}
import edition1.{MessageModelFactory, Phone}

class MessageModelFactoryTest extends AnyWordSpec with Matchers {

  "sendMessage" should {
    "send phone details" when {
      "isPhoneIncluded is false" in {
        val messageModelFactory = new MessageModelFactory()
        val phoneData = PhoneData("dummy", Some("Iphone"), Some("blue"), Some(true), Some(1000))
        val contactRequest = ContactRequest("dummy", Some(phoneData))
        val expectedMessage = messageModelFactory.sendMessage(contactRequest, false).get
        expectedMessage.phone shouldBe None
      }

      "isPhoneIncluded is true" in {
        val messageModelFactory = new MessageModelFactory()
        val phoneData = PhoneData("dummy", Some("Iphone"), Some("blue"), Some(true), Some(1000))
        val contactRequest = ContactRequest("dummy", Some(phoneData))
        val expectedMessage = messageModelFactory.sendMessage(contactRequest, true).get
        expectedMessage.phone shouldBe Some(Phone(Some("Iphone"), Some("blue"), Some(true)))
      }
    }

    "do not send phone details" when {
      "isPhoneIncluded is false" in {
        val messageModelFactory = new MessageModelFactory()
        val contactRequest = ContactRequest("dummy")
        val expectedMessage = messageModelFactory.sendMessage(contactRequest, false).get
        expectedMessage.phone shouldBe None
      }

      "isPhoneIncluded is true" in {
        val messageModelFactory = new MessageModelFactory()
        val contactRequest = ContactRequest("dummy")
        val expectedMessage = messageModelFactory.sendMessage(contactRequest, true).get
        expectedMessage.phone shouldBe None
      }
    }
  }

}
