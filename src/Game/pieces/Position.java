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

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    private int columnNumber;

    public char getColumn() {
        return column;
    }

    public int getColumnNumber(){
        switch(this.column){
            case 'a':
                setColumnNumber(1);
                return columnNumber;
            case 'b':
                setColumnNumber(2);
                return columnNumber;
            case 'c':
                setColumnNumber(3);
                return columnNumber;
            case 'd':
                setColumnNumber(4);
                return columnNumber;
            case 'e':
                setColumnNumber(5);
                return columnNumber;
            case 'f':
                setColumnNumber(6);
                return columnNumber;
            case 'g':
                setColumnNumber(7);
                return columnNumber;
            case 'h':
                setColumnNumber(8);
                return columnNumber;
        }
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public boolean isValid(){
        return 1 < this.getColumnNumber() < 9 && 1 < this.getRow() < 9;
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
