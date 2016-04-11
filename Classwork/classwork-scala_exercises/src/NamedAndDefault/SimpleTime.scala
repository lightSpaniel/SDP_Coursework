package NamedAndDefault


class SimpleTime(hours: Int=0, minutes: Int=0){
    val this.hours = hours
    val this.minutes = minutes

    def gethours():Int = {
      this.hours
    }

    def getminutes():Int = {
      this.minutes
    }
}
