package Game.pieces;

import static java.lang.Math.abs;

public class Queen extends Pieces{

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the queen's possible moves in chess
        if (newPosition.isValid()) {
            int minX = Math.min(this.position.getRow(), newPosition.getRow());
            int minY = Math.min(this.position.getColumn(), newPosition.getColumn()) - 'a';
            int maxX = Math.max(this.position.getRow(), newPosition.getRow());
            int maxY = Math.max(this.position.getColumn(), newPosition.getColumn()) - 'a';
            int deltaX = newPosition.getRow() - this.position.getRow();
            int deltaY = newPosition.getColumn() - this.position.getColumn();
            if (this.position.getRow() == newPosition.getRow() && this.position.getColumn() == newPosition.getColumn()) {
                return false;
            }
            // Vérifier si le mouvement est vertical (même colonne)
            if (this.position.getColumn() == newPosition.getColumn()) {
                for (int i = minX + 1; i < maxX; i++) {
                    if (!board[i][this.position.getColumn() - 97].isEmpty()) {
                        return false;
                    }
                }
                if (!board[newPosition.getRow()][this.position.getColumn() - 'a'].isEmpty()
                        && board[newPosition.getRow()][this.position.getColumn() - 'a'].getContent().getColor() != this.getColor()) {
                    return true;
                } else return board[newPosition.getRow()][this.position.getColumn() - 'a'].isEmpty();
            }

            // Vérifier si le mouvement est horizontal (même ligne)
            if (this.position.getRow() == newPosition.getRow()) {
                // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
                for (int y = minY + 1; y < maxY; y++) {
                    if (!board[this.position.getRow()][y].isEmpty()) {
                        return false;
                    }
                }
                if (!board[this.position.getRow()][newPosition.getColumn() - 'a'].isEmpty()
                        && board[this.position.getRow()][newPosition.getColumn() - 'a'].getContent().getColor() != this.getColor()) {
                    return true;
                } else return board[this.position.getRow()][newPosition.getColumn() - 'a'].isEmpty();
            }

            // Vérifier le mouvement en diagonale
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
                }else return board[newPosition.getRow()][newPosition.getColumn() - 'a'].isEmpty();
            }
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
