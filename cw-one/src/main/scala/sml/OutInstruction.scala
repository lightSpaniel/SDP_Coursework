package sml

/**
  * Created by jeremysmith on 26/02/2016.
  */

class OutInstruction(label: String, opcode: String, register: Int)
  extends Instruction(label, opcode){

  //Returns value of given register
  override def execute(m: Machine) =
    register

//Returns string of above execution call
  override def toString(): String = {
    super.toString + " " + register.toString + "\n"
  }
}

//Starts companion class
object OutInstruction{

  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)

}