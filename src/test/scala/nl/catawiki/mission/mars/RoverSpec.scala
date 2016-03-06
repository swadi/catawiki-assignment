package nl.catawiki.mission.mars

import org.scalatest.{FunSpec, Matchers}

class RoverSpec extends FunSpec with Matchers {
  val plateau = new Plateau(5,5)
  val rover = new Rover(plateau)

  describe("rover should move") {
    it ("should call rover with first input"){
      val roverPos = RoverPosition(1, 2, Facing.N)
      val expectedPos = RoverPosition(1, 3, Facing.N)
      rover.movement("LMLMLMLMM", roverPos) should be(expectedPos)
    }

    it ("should call rover with second input"){
      val roverPos = RoverPosition(3, 3, Facing.E)
      val expectedPos = RoverPosition(5, 1, Facing.E)
      rover.movement("MMRMMRMRRM", roverPos) should be(expectedPos)
    }
  }
}
