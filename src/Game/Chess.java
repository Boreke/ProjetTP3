package Game;

import Game.pieces.Cell;
import Game.pieces.Position;

import java.util.Scanner;

public class Chess {
    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void play(){
        while (true) {
            createPlayers();
            initialiseBoard();
            while (!isCheckMate()) {
                printBoard();
                String move;
                do {
                    move = askMove();
                }
                while (!isValidMove(move));
                updateBoard(move);
                switchPlayer();
            }
        }

    }
    private void createPlayers(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez le nom du premier joueur:");
        String name1=sc.nextLine();
        System.out.println("entrez la couleur du premier joueur(blanc ou noir)");
        String color1=sc.nextLine();
        int c1=(color1.equals("blanc"))?0:1;
        int c2 = 0;
        System.out.println("Entrez le nom du deuxieme joueur:");
        String name2=sc.nextLine();
        System.out.println("entrez la couleur du deuxieme joueur (blanc ou noir)");
        String color2=sc.nextLine();
        if (color1.equals(color2)){
            System.out.println("les deux joueurs ne peuvent pas avoir la même couleur, la couleur du deuxieme joueur à été modifiée");
            c2=(color1.equals("blanc"))?1:0;
        }
        players[0]= new Player(name1,c1);
        players[1]= new Player(name2,c2);

    }
    private void initialiseBoard(){
        char[] columnLetters={'a','b','c','d','e','f','g','h'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j]=new Cell(true,new Position(columnLetters[i],j));
            }
        }
    }
    private void printBoard(){

    }
    private String askMove(){
        return "bite";
    }
    private boolean isCheckMate(){
        return false;
    }
    private boolean isValidMove(String move){
        return false;
    }
    private void updateBoard(String move){

    }
    private void switchPlayer(){

    }
}
