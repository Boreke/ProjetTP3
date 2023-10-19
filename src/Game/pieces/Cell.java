package Game.pieces;
import Game.Chess;
public class Cell extends Position {

    public boolean isEmpty() {
        isEmpty = (this.getContent() == null);
        return isEmpty;
    }

    public Cell(boolean isEmpty, Position position) {
        this.isEmpty = isEmpty;
        this.position=position;

    }

    private boolean isEmpty;
    private final Position position;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content = null;

    public Position getPosition() {
        return position;
    }
}
