package sml

/**
  * Created by jeremysmith on 26/02/2016.
  */

class SubInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op){

  //Takes the regs value at the given values and returns the first minus the other
  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    if(value1 > value2){
      m.regs(result) = value1 - value2
    }else{
      m.regs(result) = 0
    }

  }
  //Prints string showing result of exection call
  override def toString(): String = {
    super.toString + " " + op1 + " - " + op2 + " to " + result + "\n"
  }

}
//Starts companion class
object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new SubInstruction(label, "sub", result, op1, op2)
}
