package Game.pieces;

public class Pawn {
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
        int deltaPos=newPosition.getRow()-this.position.getRow();
        if (this.color==0){
            if (this.position.getRow()==2){
                if (newPosition.getRow()-this.position.getRow()==2||newPosition.getRow()-this.position.getRow()==2);
            }
        }
    }

    public String toString(){
        return "P";
    }
    public Pawn(int c, Position startPos){
        setColor(c);
        setPosition(startPos);
    }
}
