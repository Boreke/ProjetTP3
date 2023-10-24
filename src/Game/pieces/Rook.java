package Game.pieces;

public class Rook extends Pieces {

    public boolean isValidMove(Position newPosition, Cell[][] board) {
        // Vérifier que la tour ne reste pas sur place
        if (this.position.getRow() == newPosition.getRow() && this.position.getColumn() == newPosition.getColumn()) {
            return false;
        }

        // Vérifier si le mouvement est vertical (même colonne)
        if (this.position.getColumn() == newPosition.getColumn()) {
            // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
            int minX = Math.min(this.position.getRow(), newPosition.getRow());
            int maxX = Math.max(this.position.getRow(), newPosition.getRow());
            for (int i = minX + 1; i < maxX; i++) {
                if (!board[i][this.position.getColumn() - 97].isEmpty()) {
                    return false;
                }
            }
            if (!board[newPosition.getRow()][this.position.getColumn()-'a']. isEmpty()
                    && board[newPosition.getRow()][this.position.getColumn()-'a'].getContent().getColor()!=this.getColor()){
                return true;
            } else return board[newPosition.getRow()][this.position.getColumn()-'a'].isEmpty();
        }

        // Vérifier si le mouvement est horizontal (même ligne)
        if (this.position.getRow() == newPosition.getRow()) {
            // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
            int minY = Math.min(this.position.getColumn(), newPosition.getColumn());
            int maxY = Math.max(this.position.getColumn(), newPosition.getColumn());
            for (int y= minY + 1; y < maxY; y++) {
                if (!board[this.position.getRow()][y-'a'].isEmpty()) {
                    return false;
                }
            }
            if (!board[this.position.getRow()][newPosition.getColumn()-'a'].isEmpty()
            && board[this.position.getRow()][newPosition.getColumn()-'a'].getContent().getColor() != this.getColor()) {
                return true;
            } else return board[this.position.getRow()][newPosition.getColumn()-'a'].isEmpty();
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
