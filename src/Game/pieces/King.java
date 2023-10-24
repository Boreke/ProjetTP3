package Game.pieces;

import static java.lang.Math.abs;

public class King extends Pieces {

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the king's possible moves in chess
        if (newPosition.isValid()){
            int deltaColumn=abs((newPosition.getColumn())-(this.position.getColumn()));
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            if (deltaRow<=1 && deltaColumn<=1){
                if(board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty()){
                    return true;
                }
                return !board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty()
                        && board[newPosition.getRow()][newPosition.getColumn()-'a'].getContent().getColor()!=this.color;
            }
        }
        return false;
    }

    public String toString(){
        return type;
    }
    public King(int c, Position startPos,String type){
        super(c,startPos,type);
    }
}
