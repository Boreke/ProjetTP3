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
            board[newPosition.getColumnNumber()][newPosition.getRow()].setEmpty(false);
            int deltaRow=abs(newPosition.getRow() - this.position.getRow());
            switch (this.color) {
                case 0:
                    if (deltaRow == 2 && this.position.getRow() == 2) {
                        return true;
                    } else return deltaRow == 1;
                case 1:
                    if (deltaRow == 2 && this.position.getRow() == 6) {
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
}
