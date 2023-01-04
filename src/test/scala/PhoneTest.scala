import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import edition1.Phone

class PhoneTest extends AnyWordSpec with Matchers {

  "displayText" should {
    "return no information available test " when {
      "no phone details defined" in {
        val phone = new Phone
        phone.displayText() shouldBe "I am interested in buying a new phone:\n" +
          "No information available"
      }
    }
  }

  "displayText" should {
    "return partial information " when {
      "some phone details defined" in {
        val phone = Phone(Some("Iphone"))
        phone.displayText() shouldBe "I am interested in buying a new phone:\nModel: Iphone"
      }
    }
  }

  "displayText" should {
    "return all information " when {
      "all phone details defined and accessories are included" in {
        val phone = Phone(Some("Iphone"), Some("red"), Some(true))
        phone.displayText() shouldBe "I am interested in buying a new phone:\n" +
          "Model: Iphone\nColor: red\nAccessories included: yes"
      }

      "all phone details defined and accessories are not included" in {
        val phone = Phone(Some("Iphone"), Some("red"), Some(false))
        phone.displayText() shouldBe "I am interested in buying a new phone:\n" +
          "Model: Iphone\nColor: red\nAccessories included: no"
      }
    }
  }

}
