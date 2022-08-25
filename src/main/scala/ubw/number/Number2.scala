package ubw.number

trait Number2S extends Number1

class Number2SA(val tail1: Number2S, val tail2: Number2T) extends Number1S(tail1) with Number2S
class Number2SB extends Number1T with Number2S

final case class Number2SAI(override val tail1: Number2S, override val tail2: Number2T) extends Number2SA(tail1, tail2)
final case object Number2SBI extends Number2SB


trait Number2T extends Number1

  class Number2TA( val tail1: Number2T,  val tail2: Number2S) extends Number1S(tail1) with Number2T
  class Number2TB extends Number2T

final case class Number2TAI(override val tail1: Number2T, override val tail2: Number2S) extends Number2TA(tail1, tail2)
final case object Number2TBI extends Number2TB