package Game.pieces;

public class Pawn {
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    Position position = new Position();
    int color;
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()) {
            board[newPosition.getColumnNumber()][newPosition.getRow()].setEmpty(false);
            int deltaPos;
            switch (this.color) {
                case 0:
                    deltaPos = newPosition.getRow() - this.position.getRow();
                    if (deltaPos == 2 && this.position.getRow() == 2) {
                        return true;
                    } else return deltaPos == 1;
                case 1:
                    deltaPos = -newPosition.getRow() + this.position.getRow();
                    if (deltaPos == 2 && this.position.getRow() == 6) {
                        return true;
                    } else return deltaPos == 1;
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
