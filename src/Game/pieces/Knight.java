package Game.pieces;

import static java.lang.Math.abs;

public class Knight {
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
        if (newPosition.isValid()&&board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()){
            int deltaColumn=abs(newPosition.getColumnNumber()-this.position.getColumnNumber());
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            board[newPosition.getColumnNumber()][newPosition.getRow()].setEmpty(false);
            return (deltaColumn==3&&deltaRow==1)||(deltaRow==3&&deltaColumn==1);
        }
        return false;
    }

    public String toString(){
        return "N";
    }
    public Knight(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
