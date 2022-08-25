package ubw.number

trait Number1

class Number1S(val tail: Number1) extends Number1
class Number1T extends Number1

final case class Number1SI(override val tail: Number1) extends Number1S(tail)
final case object Number1TI extends Number1T