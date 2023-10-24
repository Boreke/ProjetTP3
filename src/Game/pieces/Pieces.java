package Game.pieces;

public abstract class Pieces {
    int color;
    Position position;
    String type;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pieces(int color, Position position, String type) {
        this.color = color;
        setPosition(position);
        this.type = type;
    }


    public abstract boolean isValidMove(Position position, Cell[][] board);
}
