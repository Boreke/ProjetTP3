package Game.pieces;

import static java.lang.Math.abs;

public class King {
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    Position position;
    int color;
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()){
            int deltaRow=abs(newPosition.getRow()-this.position.getRow());
            int deltaColumn=abs(newPosition.getColumnNumber()-this.position.getColumnNumber());
            return (deltaRow<=1 || deltaColumn<=1);
        }
        return false;
    }

    public String toString(){
        return "K";
    }
    public King(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
