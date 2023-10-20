package Game.pieces;
import Game.Chess;
public class Cell extends Position {

    public boolean isEmpty() {

        return isEmpty;
    }

    public Cell(boolean isEmpty, Position position) {
        this.isEmpty = isEmpty;
        this.position=position;

    }

    private boolean isEmpty;
    private final Position position;

    public Pieces getContent() {
        return content;
    }

    public void setContent(Pieces content) {
        this.content = content;
        this.isEmpty = (this.getContent() == null);
    }

    private Pieces content=null;

    public Position getPosition() {
        return position;
    }
}
