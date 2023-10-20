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



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the king's possible moves in chess
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()){
            int deltaColumn=abs((newPosition.getColumn()-97)-(this.position.getColumn()-97));
            int deltaRow= abs(newPosition.getRow()-this.position.getRow());
            board[newPosition.getColumn()-97][newPosition.getRow()].setContent(this);//changes the cell's content
            board[this.position.getColumn()-97][this.position.getRow()].setContent(null);
            return (deltaRow<=1 || deltaColumn<=1);
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
