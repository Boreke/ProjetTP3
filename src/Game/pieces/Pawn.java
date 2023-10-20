package Game.pieces;

import static java.lang.Math.abs;

public class Pawn extends Pieces{
    int color;
    Position position = new Position();
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the pawn's possible moves in chess
        if (newPosition.isValid() ) {

            int deltaColumn=abs((newPosition.getColumn()-97)-(this.position.getColumn()-97));
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            if (deltaColumn==0 && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()) {
                switch (this.color) {
                    case 0:
                        if (deltaRow == 2 && this.position.getRow() == 1
                                && board[this.position.getColumnNumber()][newPosition.getRow() - 1].isEmpty()) {
                            return true;
                        } else return deltaRow == 1;
                    case 1:
                        if (deltaRow == 2 && this.position.getRow() == 6
                                && board[this.position.getColumnNumber()][newPosition.getRow() + 1].isEmpty()) {
                            return true;
                        } else return deltaRow == 1;
                }
            } else if (abs(deltaColumn)==1 && !(board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty())){
                return board[newPosition.getColumnNumber()][newPosition.getRow()].getContent().getColor()!=this.color;
            }
        }
        return false;
    }

    public String toString(){
        return type;
    }
    public Pawn(int c, Position startPos, String type){
        super(c,startPos,type);
    }

}
