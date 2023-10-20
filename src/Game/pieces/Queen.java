package Game.pieces;

import static java.lang.Math.abs;

public class Queen extends Pieces{
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
        //is the move valid according to the queen's possible moves in chess
        if (newPosition.isValid()){
            int deltaColumn = abs((newPosition.getColumn() - 97) - (this.position.getColumn() - 97));
            int deltaRow = abs(newPosition.getRow() - this.position.getRow());
            if (board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()) {

            }return deltaRow==deltaColumn || this.position.getColumnNumber()==newPosition.getColumnNumber() || this.position.getRow()== newPosition.getRow();
        }
        return false;
    }

    public String toString(){
        return type;
    }
    public Queen(int c, Position startPos,String type){
        super(c,startPos,type);
    }
}
