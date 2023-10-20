package Game;

import Game.pieces.*;


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

    public Pawn[] whitePawns=new Pawn[8];
    public Pawn[] blackPawns=new Pawn[8];

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
        board= new Cell[8][8];
        for (char i = 'a'; i < 'i'; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j]=new Cell(true,new Position(i,j));
            }
        }

        for (int i = 0; i < 8; i++) {

            whitePawns[i] = new Pawn(0,board[1][i].getPosition(),"P");
            board[1][i].setContent(whitePawns[i]);
        }


        for (int i = 0; i < 8; i++) {
            blackPawns[i] = new Pawn(0,board[6][i].getPosition(),"P");
            board[6][i].setContent(blackPawns[i]);
        }
        board[0][0].setContent(new Rook(0,board[0][0].getPosition(),"R"));
        board[0][1].setContent(new Knight(0,board[0][1].getPosition(),"N"));
        board[0][2].setContent(new Bishop(0,board[0][2].getPosition(),"B"));
        board[0][3].setContent(new Queen(0,board[0][3].getPosition(),"Q"));
        board[0][4].setContent(new King(0,board[0][4].getPosition(),"K"));
        board[0][5].setContent(new Knight(0,board[0][5].getPosition(),"B"));
        board[0][6].setContent(new Bishop(0,board[0][6].getPosition(),"N"));
        board[0][7].setContent(new Rook(0,board[0][7].getPosition(),"R"));

        board[7][0].setContent(new Rook(1,board[7][0].getPosition(),"R"));
        board[7][1].setContent(new Knight(1,board[7][1].getPosition(),"N"));
        board[7][2].setContent(new Bishop(1,board[7][2].getPosition(),"B"));
        board[7][3].setContent(new Queen(1,board[7][3].getPosition(),"Q"));
        board[7][4].setContent(new King(1,board[7][4].getPosition(),"K"));
        board[7][5].setContent(new Knight(1,board[7][5].getPosition(),"B"));
        board[7][6].setContent(new Bishop(1,board[7][6].getPosition(),"N"));
        board[7][7].setContent(new Rook(1,board[7][7].getPosition(),"R"));
    }
    private void printBoard(){
        System.out.print("  a  b  c  d  e  f  g  h ");
        for (int i = 0; i < 8; i++) {
            System.out.print("\n");
            System.out.print(i+1);
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getContent()==null){
                    System.out.print("[ ]");
                }
                else {
                    System.out.print("[" + board[i][j].getContent().toString() + "]");
                }
            }

        }
    }
    private String askMove(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entrez votre movement sous la forme  piece colonne ligne (e.g:Pe2 Pe7)");
        return sc.nextLine();
    }
    private boolean isCheckMate(){
        return false;
    }
    private boolean isValidMove(String move){
        String[] moves= move.split(" ");
        int column=moves[0].charAt(1)-97;
        int row = moves[0].charAt(2)-48;
        return false;
    }
    private void updateBoard(String move){

    }
    private void switchPlayer(){

    }
}
