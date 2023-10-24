package Game.pieces;

public class Position {
    private int row;

    private char column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (0<=row&&row<8)this.row = row;
    }


    public char getColumn() {
        return this.column;
    }
    private boolean checkValidColumn(char column){
        char[] validColumn={'a','b','c','d','e','f','g','h'};
        for (int i = 0; i < 8; i++) {
            if (validColumn[i]==column) return true;
        }
        return false;
    }


    public void setColumn(char column) {
        //if(checkValidColumn(column)) {this.column = column;}
        this.column = column;
    }

    public boolean isValid(){
        return (96<= this.getColumn() && this.getColumn()< 105) && (0 <= this.getRow()&& this.getRow() < 8);
    }
    @Override
    public String toString() {
        return "game.pieces.Position{" + column + (row+1) + "}";
    }

    public Position() {
    }

    public Position(char column, int row) {
        setColumn(column);
        setRow(row);
    }
}
