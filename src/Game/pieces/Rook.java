package Game.pieces;

public class Rook extends Pieces {
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    Position position;
    int color;
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    public boolean isValidMove(Position newPosition, Cell[][] board) {
        // Vérifier que la tour ne reste pas sur place
        if (this.position.getRow() == newPosition.getRow() && this.position.getColumn() == newPosition.getColumn()) {
            return false;
        }

        // Vérifier si le mouvement est vertical (même colonne)
        if (this.position.getRow() == newPosition.getRow()) {
            // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
            int minY = Math.min(this.position.getColumn(), newPosition.getColumn());
            int maxY = Math.max(this.position.getColumn(), newPosition.getColumn());
            for (int i = minY + 1; i < maxY; i++) {
                if (!board[this.position.getRow()][i].isEmpty()) {
                    return false;
                }
            }
            if (!board[this.position.getRow()][newPosition.getColumn()-'a']. isEmpty()
                    && board[this.position.getRow()][newPosition.getColumn()-'a'].getContent().getColor()!=this.getColor()){
                return true;
            } else return board[this.position.getRow()][newPosition.getColumn()-'a'].isEmpty();
        }

        // Vérifier si le mouvement est horizontal (même ligne)
        if (this.position.getColumn() == newPosition.getColumn()) {
            // Vérifier qu'il n'y a pas d'autres pièces sur le chemin
            int minX = Math.min(this.position.getRow(), newPosition.getRow());
            int maxX = Math.max(this.position.getRow(), newPosition.getRow());
            for (int x = minX + 1; x < maxX; x++) {
                if (!board[x][this.position.getColumn() - 97].isEmpty()) {
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
