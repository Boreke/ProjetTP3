package Game.pieces;

import static java.lang.Math.abs;

public class Bishop {
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    Position position= new Position();
    int color;
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        if (newPosition.isValid() && board.isEmpty()){
            int deltaRow=abs(newPosition.getRow()-this.position.getRow());
            int deltaColumn=abs(newPosition.getColumnNumber()-this.position.getColumnNumber());
            return deltaRow==deltaColumn;
        }
        return false;
    }

    public String toString(){
        return "B";
    }
    public Bishop(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
