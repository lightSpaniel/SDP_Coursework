package caseClasses


case class Person(first: String,
                  last: String,
                  email: String) {
  val this.first=first
  val this.last=last
  val this.email=email

}
