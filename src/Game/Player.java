package Game;

public class Player {
    private String name;

    private int color;
    public String getName(){
        return this.name;
    }
    public  int getColor(){
        return this.color;
    }
    public void setName(String n){
        name=n;
    }
    public void setColor(int color) {
        this.color = color;
    }


    public Player(String n, int c){
        setName(n);
        setColor(c);
    }
}
