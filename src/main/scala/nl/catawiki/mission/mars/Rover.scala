package nl.catawiki.mission.mars

class Rover(plateau: Plateau) {
  import Facing._

  def movement(move: String, roverPosition: RoverPosition): RoverPosition = {
    move.foldLeft(roverPosition)((roverPos, mov) => performAction(mov, roverPos) )
  }

  private def movePosition(roverPosition: RoverPosition): RoverPosition = {
    roverPosition.facing match {
      case Facing.E =>
        if (roverPosition.x < plateau.maxXCoordinate) {
          roverPosition.copy(x = roverPosition.x + 1)
        } else {
          roverPosition
        }

      case Facing.W =>
        if (roverPosition.x > 0) {
          roverPosition.copy(x = roverPosition.x - 1)
        } else {
          roverPosition
        }

      case Facing.N =>
        if (roverPosition.y < plateau.maxYCoordinate) {
          roverPosition.copy(y = roverPosition.y + 1)
        } else {
          roverPosition
        }

      case Facing.S =>
        if (roverPosition.y > 0) {
          roverPosition.copy(y = roverPosition.y - 1)
        } else {
          roverPosition
        }

      case _ => roverPosition
    }
  }

  private def performAction(mov: Char, roverPosition: RoverPosition): RoverPosition = {
    val roverCurrentFacing: Facing = roverPosition.facing

    mov match {
      case 'L' => roverPosition.copy(facing = turnLeft(roverCurrentFacing))

      case 'R' => roverPosition.copy(facing = turnRight(roverCurrentFacing))

      case 'M' => movePosition(roverPosition)

      case _ => roverPosition
    }
  }
  private def turnLeft(currentFacing: Facing): Facing = {
    currentFacing match {
      case Facing.E => Facing.N
      case Facing.W => Facing.S
      case Facing.N => Facing.W
      case Facing.S => Facing.E
    }
  }

  private def turnRight(currentFacing: Facing): Facing = {
    currentFacing match {
      case Facing.E => Facing.S
      case Facing.W => Facing.N
      case Facing.N => Facing.E
      case Facing.S => Facing.W
    }
  }

}




