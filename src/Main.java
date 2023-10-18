import Game.pieces.Position;
public class Main {
    public static void main(String[] args) {
        Position test= new Position('a',0);
        test.setColumn('i');
        System.out.println(test.getColumnNumber());

    }
}