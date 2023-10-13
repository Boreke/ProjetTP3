package Game.pieces;

public class Knight {
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

    }

    public String toString(){
        return "N";
    }
    public Knight(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
