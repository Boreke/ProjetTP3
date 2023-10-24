package Game.pieces;

import static java.lang.Math.abs;

public class Bishop extends Pieces{

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the bishop's possible moves in chess
        if (newPosition.isValid()) {
            int minX = Math.min(this.position.getRow(), newPosition.getRow());
            int minY = Math.min(this.position.getColumn(), newPosition.getColumn())-'a';
            int maxX = Math.max(this.position.getRow(), newPosition.getRow());
            int maxY = Math.max(this.position.getColumn(), newPosition.getColumn())-'a';
            int deltaX = newPosition.getRow() - this.position.getRow();
            int deltaY = newPosition.getColumn() - this.position.getColumn();
            if (abs(deltaX) == abs(deltaY)) {
                // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
                if (deltaX>0 && deltaY<0) {
                    for (int x = maxX - 1, y = minY + 1; x > minX|| y<maxY; x--, y++) {
                        if (!board[x][y].isEmpty()) {
                            return false;
                        }
                    }
                } else if (deltaX>0 && deltaY>0) {
                    for (int x = maxX - 1, y = maxY-1; x > minX || y>minY; x--, y--) {
                        if (!board[x][y].isEmpty()) {
                            return false;
                        }
                    }
                }else if (deltaX<0 && deltaY>0) {
                    for (int x = minX+ 1, y = maxY-1; x <maxX|| y>minY; x++, y--) {
                        if (!board[x][y].isEmpty()) {
                            return false;
                        }
                    }
                }else if (deltaX<0 && deltaY<0) {
                    for (int x = minX+ 1, y = minY+1; x <maxX|| y<maxY; x++, y++) {
                        if (!board[x][y].isEmpty()) {
                            return false;
                        }
                    }
                }
                if(!board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty() && this.getColor()!=
                        board[newPosition.getRow()][newPosition.getColumn()-'a'].getContent().getColor()) {
                    return true;
                }else if (board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty())return true;
            }
            return false;
        }
        return false;
    }
    public String toString(){
        return "B";
    }
    public Bishop(int c, Position startPos,String type){
        super(c,startPos,type);

    }

}
