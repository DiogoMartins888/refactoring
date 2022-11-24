package pt.up.fe.ldts.example5;

public class TurtleNorth extends TurtleState {
    public TurtleNorth() {

    }

    public TurtleNorth(Turtle turtle) {
        this.turtle = turtle;
    }

    @Override
    public char getDirection() {
        return 'N';
    }

    @Override
    public void moveForward() {
        turtle.setRow(turtle.getRow() - 1);
    }

    @Override
    public void rotateRight() {
        turtle.setDirection(new TurtleEast(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setDirection(new TurtleWest(turtle));
    }
}
