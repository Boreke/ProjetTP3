package Game.pieces;

import static java.lang.Math.abs;

public class King extends Pieces {
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public King() {
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
            super.getDeltaRow(newPosition.getRow());
            super.getDeltaColumn(newPosition.getColumnNumber());
            board[newPosition.getColumnNumber()][newPosition.getRow()].setContent(this.toString());//changes the cell's content
            board[this.position.getColumnNumber()][this.position.getRow()].setContent(null);
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
