package Game.pieces;

import static java.lang.Math.abs;

public class Queen extends Pieces{

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
                    for (int y = minY + 1; y < maxY; y++) {
                        if (!board[this.position.getRow()][y].isEmpty()) {
                            return false;
                        }
                    }
                }
                if (this.position.getColumn() == newPosition.getColumn()) {
                    for (int x = minX + 1; x < maxX; x++) {
                        if (!board[x][this.position.getColumn()-'a'].isEmpty()) {
                            return false;
                        }
                    }
                }
                if (!board[newPosition.getRow()][newPosition.getColumn()]. isEmpty()
                        && board[newPosition.getRow()][newPosition.getColumn()].getContent().getColor()==this.getColor()){
                    return true;
                } else return board[this.position.getRow()][newPosition.getColumn()].isEmpty();
            }

            // Vérifier le mouvement en diagonale
            if (deltaX == deltaY) {
                // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
                for (int x = minX + 1, y = minY + 1; x < maxX; x++, y++) {
                    if (!board[x][y].isEmpty()) {
                        return false;
                    }
                }
                if (!board[newPosition.getRow()][newPosition.getColumn()]. isEmpty()
                     && board[newPosition.getRow()][newPosition.getColumn()].getContent().getColor()==this.getColor()){
                    return true;
                } else return board[this.position.getRow()][newPosition.getColumn()].isEmpty();
            }


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
