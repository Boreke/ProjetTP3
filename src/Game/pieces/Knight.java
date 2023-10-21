package Game.pieces;

import static java.lang.Math.abs;

public class Knight extends Pieces{
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
        //is the move valid according to the knight's possible moves in chess
        if (newPosition.isValid()){
            int deltaColumn=abs((newPosition.getColumn()-97)-(this.position.getColumn()-97));
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            if (board[newPosition.getColumn()-97][newPosition.getRow()].isEmpty()) {
                return (deltaColumn == 2 && deltaRow == 1) || (deltaRow == 2 && deltaColumn == 1);
            } else {
                return ((deltaColumn == 2 && deltaRow == 1) || (deltaRow == 2 && deltaColumn == 1)) &&
                       board[newPosition.getColumn()-97][newPosition.getRow()].getContent().getColor()!=this.getColor();
            }
        }
        return false;
    }

    public String toString(){
        return type;
    }
    public Knight(int c, Position startPos, String type){
        super(c,startPos,type);
    }


}
