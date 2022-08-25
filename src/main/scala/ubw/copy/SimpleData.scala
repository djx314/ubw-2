package ubw.copy

import ubw.codec.{Number1Decoder, Number1Encoder, Number2Decoder, Number2Encoder}
import ubw.number.{Number1, Number1S, Number1SI, Number1TI, Number2S, Number2SAI, Number2SBI, Number2T, Number2TAI, Number2TBI}

case class UbwInt(n: Int)

object UbwInt {
  implicit val ubwIntNumber1Decoder: Number1Decoder[UbwInt] = new Number1Decoder[UbwInt] {
    override def decode(number1: Number1): UbwInt = {
      var count: Int = 0
      var currNum1: Number1 = number1
      while(currNum1.isInstanceOf[Number1S]) {
        count = count + 1
        currNum1 = currNum1.asInstanceOf[Number1S].tail
      }
      UbwInt(count)
    }
  }
  implicit val ubwIntNumber2Decoder: Number2Decoder[UbwInt] = new Number2Decoder[UbwInt] {
    override def decode1(number2: Number2S): UbwInt = {
      val num1Decoder = implicitly[Number1Decoder[UbwInt]]
      val num2: Number1 = number2
      num1Decoder.decode(num2)
    }

    override def decode1(number2: Number2T): UbwInt = {
      val num1Decoder = implicitly[Number1Decoder[UbwInt]]
      val num2: Number1 = number2
      num1Decoder.decode(num2)
    }
  }

  implicit val ubwIntNumber1Encoder: Number1Encoder[UbwInt] = new Number1Encoder[UbwInt] {
    override def encode(model: UbwInt): Number1 = {
      var count = model.n
      var num1:Number1 = Number1TI
      while (count > 0) {
        num1 = Number1SI(num1)
        count = count  - 1
      }
      num1
    }
  }
  implicit val ubwIntNumber2Encoder: Number2Encoder[UbwInt] = new Number2Encoder[UbwInt] {
    override def encode1(model: UbwInt): Number2S = {
      var count = model.n
      var num2:Number2S = Number2SBI
      while (count > 0) {
        num2 = Number2SAI(num2, Number2TBI)
        count = count  - 1
      }
      num2
    }

    override def encode2(model: UbwInt): Number2T = {

      var count = model.n
      var num2:Number2T = Number2TBI
      while (count > 0) {
        num2 = Number2TAI(num2, Number2SBI)
        count = count  - 1
      }
      num2
    }
  }
}