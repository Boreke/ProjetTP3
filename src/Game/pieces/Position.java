package Game.pieces;

public class Position {
    private int row;
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }



    private char column;

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "game.pieces.Position{" + column + row + "}";
    }

    public Position() {
    }
    public Position(char column,int row){
        setColumn(column);
        setRow(row);
    }
}
