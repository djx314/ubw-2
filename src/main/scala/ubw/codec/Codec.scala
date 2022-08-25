package ubw.codec

import ubw.number.{Number1, Number2S, Number2T}

trait Number1Decoder[T] {
  def decode(number1: Number1): T
}

trait Number1Encoder[T] {
  def encode(model: T): Number1
}

trait Number2Decoder[T] {
  def decode1(number2: Number2S): T
  def decode2(number2: Number2T): T
}

trait Number2Encoder[T] {
  def encode1(model: T): Number2S
  def encode2(model: T): Number2T
}