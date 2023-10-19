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

    public Rook() {
    }

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()){
            board[newPosition.getColumnNumber()][newPosition.getRow()].setContent(this.toString());
            board[this.position.getColumnNumber()][this.position.getRow()].setContent(null);
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
