package Game.pieces;

public class Rook extends Pieces {
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
        //is the move valid according to the rook's possible moves in chess
        if (newPosition.isValid() && board[newPosition.getColumnNumber()][newPosition.getRow()].isEmpty()){
            board[newPosition.getColumn()-97][newPosition.getRow()].setContent(this);//changes the cell's content
            board[this.position.getColumn()-97][this.position.getRow()].setContent(null);
            return newPosition.getRow() == this.position.getRow()  || this.position.getColumn() == newPosition.getColumn();
        }
        return false;
    }

    public String toString(){
        return type;
    }
    public Rook(int c, Position startPos, String type){
        super(c,startPos,type);
    }
}
