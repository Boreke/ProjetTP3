package Game.pieces;

import static java.lang.Math.abs;

public class Queen extends Pieces{
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
        //is the move valid according to the queen's possible moves in chess
        if (newPosition.isValid()){
            int minX = Math.min(this.position.getRow(), newPosition.getRow());
            int minY = Math.min(this.position.getColumn(), newPosition.getColumn());
            int maxX = Math.max(this.position.getRow(), newPosition.getRow());
            int maxY = Math.max(this.position.getColumn(), newPosition.getColumn());
            int deltaX = abs(newPosition.getRow() - this.position.getRow());
            int deltaY = abs(newPosition.getColumn() - this.position.getColumn());
            if (this.position.getRow() == newPosition.getRow() && this.position.getColumn() == newPosition.getColumn()) {
                return false;
            }
            // Vérifier le mouvement horizontal ou vertical
            if (this.position.getRow() == newPosition.getRow() || this.position.getColumn() == newPosition.getColumn()) {
                // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
                if (this.position.getRow() == newPosition.getRow()) {
                    for (int x = minX + 1; x < maxX; x++) {
                        if (!board[this.position.getColumn()-97][x].isEmpty()) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            // Vérifier le mouvement en diagonale
            if (deltaX == deltaY) {
                // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
                for (int x = minX + 1, y = minY + 1; x < maxX; x++, y++) {
                    if (!board[x][y].isEmpty()) {
                        return false;
                    }
                }
                return true;
            }

            // Si le mouvement n'est ni horizontal, vertical, ni diagonal, il est invalide
            return false;
        }
        return false;
    }


    public String toString(){
        return type;
    }
    public Queen(int c, Position startPos,String type){
        super(c,startPos,type);
    }
}
