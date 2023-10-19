package Game.pieces;

import static java.lang.Math.abs;

public class Queen {
    public Position getPosition() {
        return position;
    }

    public Queen() {
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
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()){
            int deltaRow=abs(newPosition.getRow()-this.position.getRow());
            int deltaColumn=abs(newPosition.getColumnNumber()-this.position.getColumnNumber());
            board[newPosition.getColumnNumber()][newPosition.getRow()].setContent(this.toString());
            board[this.position.getColumnNumber()][this.position.getRow()].setContent(null);
            return deltaRow==deltaColumn || this.position.getColumnNumber()==newPosition.getColumnNumber() || this.position.getRow()== newPosition.getRow();
        }
        return false;
    }

    public String toString(){
        return "Q";
    }
    public Queen(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
