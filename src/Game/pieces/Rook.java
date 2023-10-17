package Game.pieces;

public class Rook {
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
        if (0< newPosition.getRow() <9 && board.isEmpty()){
            return newPosition.getRow() == this.position.getRow()  || this.position.getColumn() == newPosition.getColumn();
        }
        return false;
    }

    public String toString(){
        return "R";
    }
    public Rook(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
