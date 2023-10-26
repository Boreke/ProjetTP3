package Game.pieces;

import static java.lang.Math.abs;

public class Bishop extends Pieces{

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the bishop's possible moves in chess
        if (newPosition.isValid()) {
            int minX = Math.min(this.position.getRow(), newPosition.getRow());
            int minY = Math.min(this.position.getColumn(), newPosition.getColumn());
            int maxX = Math.max(this.position.getRow(), newPosition.getRow());
            int maxY = Math.max(this.position.getColumn(), newPosition.getColumn());
            int deltaX = abs(newPosition.getRow() - this.position.getRow());
            int deltaY = abs(newPosition.getColumn() - this.position.getColumn());
            if (deltaX == deltaY) {
                // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
                for (int x = minX + 1, y = minY + 1; x < maxX; x++, y++) {
                    if (!board[x][y].isEmpty()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
    @Override
    public String toString() {
        return super.toString();
    }
    public Bishop(int c, Position startPos,String type){
        super(c,startPos,type);

    }

}
