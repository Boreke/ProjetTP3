package Game.pieces;

import static java.lang.Math.abs;

public class Knight extends Pieces{
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPos) {
        this.position = newPos;
    }

    Position position;
    int color;

    public void setColor(int color) {
        this.color = color;
    }



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the knight's possible moves in chess
        if (newPosition.isValid()){
            int deltaColumn=abs((newPosition.getColumn()-'a')-((int)this.position.getColumn()-'a'));
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            if (board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty()) {
                return (deltaColumn == 2 && deltaRow == 1) || (deltaRow == 2 && deltaColumn == 1);
            } else {
                return ((deltaColumn == 2 && deltaRow == 1) || (deltaRow == 2 && deltaColumn == 1)) &&
                      board[newPosition.getRow()][newPosition.getColumn()-'a'].getContent().getColor()!=this.getColor();
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
