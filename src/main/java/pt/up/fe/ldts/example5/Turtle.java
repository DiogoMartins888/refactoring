package pt.up.fe.ldts.example5;

public class Turtle {
    private int row;
    private int column;
    private TurtleState direction;

    public Turtle(int row, int column, TurtleState direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        direction.setTurtle(this);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction.getDirection();
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setDirection(TurtleState direction) {
        this.direction = direction;
    }

    public void execute(char command) {
        switch (command) {
            case 'F':
                direction.moveForward();
                break;
            case 'L':
                direction.rotateLeft();
                break;
            case 'R':
                direction.rotateRight();
                break;
        }
    }
}
