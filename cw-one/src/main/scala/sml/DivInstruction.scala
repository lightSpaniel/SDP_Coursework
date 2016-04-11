package sml

/**
  * Created by jeremysmith on 26/02/2016.
  */

class DivInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){
//Takes the given machine regs values and divides first by second
  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = value1 / value2
  }
//Creates string showing operation of execution call
  override def toString(): String = {
    super.toString + " " + op1 + " / " + op2 + " to " + result + "\n"
  }

}

//Starts companion class
object DivInstruction{
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new DivInstruction(label, "div", result, op1, op2)
}
