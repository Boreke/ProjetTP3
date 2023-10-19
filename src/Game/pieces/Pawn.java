package Game.pieces;

import static java.lang.Math.abs;

public class Pawn {
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
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()) {

            int deltaRow=abs(newPosition.getRow() - this.position.getRow());
            switch (this.color) {
                case 0:
                    if (deltaRow == 2 && this.position.getRow() == 1 && board[this.position.getColumnNumber()][newPosition.getRow()-1].isEmpty()) {
                        board[newPosition.getColumnNumber()][newPosition.getRow()].setContent(this.toString());
                        board[this.position.getColumnNumber()][this.position.getRow()].setContent(this.toString());
                        return true;
                    } else return deltaRow == 1;
                case 1:
                    if (deltaRow == 2 && this.position.getRow() == 6 && board[this.position.getColumnNumber()][newPosition.getRow()+1].isEmpty()) {
                        board[newPosition.getColumnNumber()][newPosition.getRow()].setContent(this.toString());
                        return true;
                    } else return deltaRow == 1;
            }
        }
        return false;
    }

    public String toString(){
        return "P";
    }
    public Pawn(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }

    public Pawn() {
    }
}
