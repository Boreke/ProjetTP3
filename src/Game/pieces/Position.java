package Game.pieces;

public class Position {
    private int row;
    private int columnNumber;
    private char column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (0<=row&&row<=8)this.row = row;
    }

    private void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public char getColumn() {
        return column;
    }
    private boolean checkValidColumn(char column){
        char[] validColumn={'a','b','c','d','e','f','g','h'};
        for (int i = 0; i < 8; i++) {
            if (validColumn[i]==column) return true;
        }
        return false;
    }
    public int getColumnNumber(){
        switch(this.column){
            case 'a':
                setColumnNumber(0);
                return columnNumber;
            case 'b':
                setColumnNumber(1);
                return columnNumber;
            case 'c':
                setColumnNumber(2);
                return columnNumber;
            case 'd':
                setColumnNumber(3);
                return columnNumber;
            case 'e':
                setColumnNumber(4);
                return columnNumber;
            case 'f':
                setColumnNumber(5);
                return columnNumber;
            case 'g':
                setColumnNumber(6);
                return columnNumber;
            case 'h':
                setColumnNumber(7);
                return columnNumber;
        }
        return columnNumber;
    }

    public void setColumn(char column) {
        if(checkValidColumn(column)) this.column = column;
    }

    public boolean isValid(){
        return (0 <= this.getColumnNumber() && this.getColumnNumber()< 8) && (0 <= this.getRow()&& this.getRow() < 8);
    }
    @Override
    public String toString() {
        return "game.pieces.Position{" + column + row + "}";
    }

    public Position() {
    }

    public Position(char column, int row) {
        setColumn(column);
        setRow(row);
    }
}
