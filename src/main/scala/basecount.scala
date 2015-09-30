object basecount {

  def main(args: Array[String]): Unit = {

    // This opening section is the console output describing what the program is and what it should do.

    println("This is my homework assignment for September 29, 2015. \n\n" +
      "It is intended to ake any number of Strings in and output if it \n" +
      "is a valid Oligo and if it is it should output the \nbreakdown of G, C, T," +
      "and A's in that sequence.")
    println("")
    println("Expected Input:\nrun TTGC CCGTA GTTRC  TTGCT\n\n" +
      "Expected Console Output:\nTTGC: " +
      "G(1), T(2), C(1), A(0)\nCCGTA: G(1), T(1), C(2), A(1)\nGTTRC: " +
      "Invalid Sequence!\nTTGCT; G(1), T(3), C(1), A(0)\n")

    //Here is the real meat of the program:

    val VectorOfInput = args.toVector
    println(VectorOfInput)

    val goodorbad = VectorOfInput.map(yesorno)

    val Validation = goodorbad.map(check)
    println(Validation)

    val basecount = VectorOfInput.map(adenines)
    println(basecount)
  }

  def yesorno(strand: String): Boolean = {
    strand.matches("[ATGC]+")
  }

  def adenines(seq: String) = seq.groupBy(x => x).mapValues(_.length)
  //def adenines(seq: String) = {
    //seq match {
   //   case "[ATGC]+" => seq.groupBy(x => x).mapValues(_.length)
   //   case _ => "not applicable"
  //  }
  //}


  def check(testresult: Boolean) = {
    testresult match {
      case true => "Valid Sequence"
      case false => "This is no good"
    }
  }
}