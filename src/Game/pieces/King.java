package Game.pieces;

import static java.lang.Math.abs;

public class King extends Pieces {
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


    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the king's possible moves in chess
        if (newPosition.isValid() && board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty()){
            int deltaColumn=abs((newPosition.getColumn())-(this.position.getColumn()));
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            return (deltaRow<=1 && deltaColumn<=1);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public King(int c, Position startPos,String type){
        super(c,startPos,type);
    }
}
