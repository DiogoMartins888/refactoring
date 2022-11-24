package pt.up.fe.ldts.example5;

public abstract class TurtleState {
    protected Turtle turtle;

    public void setTurtle(Turtle turtle) {
        this.turtle = turtle;
    }

    public abstract char getDirection();

    public abstract void moveForward();
    public abstract void rotateRight();
    public abstract void rotateLeft();
}
