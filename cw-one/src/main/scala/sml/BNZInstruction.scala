package sml

/**
  * Created by jeremysmith on 27/02/2016.
  */
class BNZInstruction(label: String, opcode: String, register: Int, value: String)
  extends Instruction(label, opcode) {

  //Checks whether the given register value is empty
  //If it is, it executes the given value
  def execute(m: Machine): Unit ={
    //Instruction is found by finding the first instance of the label
    //in the given machine's label name
    val labelIndex = m.labels.labels.indexOf(value)
    val valueTocheck = m.regs(register)

    if(valueTocheck != 0){
      m.execute(labelIndex)
    }

  }

  //Creates string showing operation of execution call
  override def toString(): String = {
    super.toString + " " + value + "\n"
  }

}
//Starts companion class
object BNZInstruction{
  def apply(label: String,  register: Int, value: String) =
    new BNZInstruction(label, "bnz", register, value)
}
