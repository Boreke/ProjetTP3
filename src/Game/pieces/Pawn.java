package Game.pieces;

import static java.lang.Math.abs;

public class Pawn extends Pieces{

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        //is the move valid according to the pawn's possible moves in chess
        if (newPosition.isValid() ) {
            int deltaX = abs(newPosition.getRow() - this.position.getRow());
            int deltaY = abs(newPosition.getColumn() - this.position.getColumn());
            if(board[newPosition.getRow()][newPosition.getColumn()-'a'].isEmpty()) {
                if (this.position.getRow() == newPosition.getRow()
                        && this.position.getColumn() == newPosition.getColumn()) {
                    return false;
                }

                // Vérifier les déplacements valides
                if ((this.position.getRow() == 1 && this.getColor() == 0)
                        || (this.position.getRow() == 6 && this.getColor() == 1)) {
                    // Première avance d'un pion : peut avancer de 1 ou 2 cases
                    if (deltaX == 1 || deltaX == 2) {
                        int minX = Math.min(this.position.getRow(), newPosition.getRow());
                        int maxX = Math.max(this.position.getRow(), newPosition.getRow());
                        for (int x = minX + 1; x < maxX; x++) {
                            if (!board[x][this.position.getColumn()-'a'].isEmpty()) {
                                return false;
                            }
                        }
                        if (this.getColor()==0) {
                            return (this.position.getRow() < newPosition.getRow()) &&
                                    (this.position.getColumn() == newPosition.getColumn());
                        }else{
                            return (this.position.getRow() > newPosition.getRow()) &&
                                    (this.position.getColumn() == newPosition.getColumn());
                        }
                    }
                } else {
                    // Avance normale d'un pion : peut avancer d'une seule case
                    if (deltaX == 1) {
                        if (this.getColor()==0) {
                            return (this.position.getRow() < newPosition.getRow()) &&
                                    (this.position.getColumn() == newPosition.getColumn());
                        }else{
                            return (this.position.getRow() > newPosition.getRow()) &&
                                    (this.position.getColumn() == newPosition.getColumn());
                        }
                    }
                }
            }
            // Vérifier les captures diagonales
            if (deltaY == 1 && deltaX == 1) {
                if (this.getColor()==0) {
                    return (this.position.getRow() < newPosition.getRow())&&
                      board[newPosition.getRow()][newPosition.getColumn()-'a'].getContent().getColor()!=this.getColor();
                }else{
                    return (this.position.getRow() > newPosition.getRow())&&
                      board[newPosition.getRow()][newPosition.getColumn()-'a'].getContent().getColor()!=this.getColor();
                }
            }

            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public Pawn(int c, Position startPos, String type){
        super(c,startPos,type);
    }

}
