package NamedAndDefault


class Planet(name: String, description: String, moons: Int=1) {

  val this.name = name
  val this.description=description
  val this.moons=moons

  def hasMoon():Boolean={
    if (this.moons > 0) true else false
  }
}
