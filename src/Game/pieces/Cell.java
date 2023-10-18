package Game.pieces;

public class Cell extends Position {

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Cell(boolean isEmpty, Position position) {
        this.isEmpty = isEmpty;
        this.position=position;

    }

    private boolean isEmpty;
    private final Position position;

    public Position getPosition() {
        return position;
    }
}
