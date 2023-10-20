package Game.pieces;

import static java.lang.Math.abs;

public class Bishop extends Pieces{
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
        //is the move valid according to the bishop's possible moves in chess
        int deltaColumn = (newPosition.getColumn() - 97) - (this.position.getColumn() - 97);
        int deltaRow = newPosition.getRow() - this.position.getRow();
        if (newPosition.isValid() &&abs(deltaColumn) == abs(deltaRow)) {
            if (board[newPosition.getColumn() - 97][newPosition.getRow()].isEmpty()) {
                if (deltaColumn < 0) {
                    for (int i = 0; i != deltaRow; i--) {
                        if (!(board[newPosition.getColumn() - 97 + i][newPosition.getRow() + i].isEmpty())) {
                            return false;
                        }
                    }
                } else {
                    for (int i = 0; i != deltaRow; i++) {
                        if (!(board[newPosition.getColumn() - 97 - i][newPosition.getRow() - i].isEmpty())) {
                            return false;
                        }
                    }
                }
            }
            return board[newPosition.getColumnNumber()][newPosition.getRow()].getContent().getColor()!=this.getColor();
        }
        return false;
    }
    public String toString(){
        return "B";
    }
    public Bishop(int c, Position startPos,String type){
        super(c,startPos,type);

    }

}
