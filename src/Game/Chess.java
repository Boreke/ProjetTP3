package Game;

import Game.pieces.*;


import java.util.Scanner;

public class Chess {
    private Cell[][] board;
    private Player[] players= new Player[2];
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
        System.out.println("Entrez le nom du deuxieme joueur:");
        String name2=sc.nextLine();

        players[0]= new Player(name1,0);
        players[1]= new Player(name2,1);
        currentPlayer=players[0];
    }
    private void initialiseBoard(){
        board= new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j]=new Cell(true,new Position((char) (j+'a'),i));
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
        board[0][5].setContent(new Bishop(0,board[0][5].getPosition(),"B"));
        board[0][6].setContent(new Knight(0,board[0][6].getPosition(),"N"));
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
        System.out.print("\n");
    }
    private String askMove() {
        Scanner sc = new Scanner(System.in);
        String scan;
        do {
            System.out.println("Entrez votre movement sous la forme  piece colonne ligne (e.g:Pe2 Pe7)");
            scan = sc.nextLine();
        } while (scan.length()!=7);
        return scan;
    }
    private boolean isCheckMate(){
        return false;
    }
    private boolean isValidMove(String m){
        String[] moves= m.split(" ");
        int column=moves[0].charAt(1)-'a';
        int newColumn=moves[1].charAt(1)-'a';
        int row = Character.getNumericValue(moves[0].charAt(2))-1;
        int newRow=Character.getNumericValue(moves[1].charAt(2))-1;
        if (!(new Position(moves[1].charAt(1), newRow).isValid()) || board[row][column].getContent()==null||
                board[row][column].getContent().getColor()!=currentPlayer.getColor()) {
            System.out.println("invalid move, please enter a valid move");
            return false;
        }
        else {
            if (board[row][column].getContent().isValidMove(new Position(moves[1].charAt(1), newRow), board)){
                return true;
            }
            return false;
        }
    }
    private void updateBoard(String move){
        String[] parts = move.split(" ");
        String source = parts[0];
        String target = parts[1];
        int row = Character.getNumericValue(source.charAt(2))-1;
        int column = source.charAt(1)-'a';
        int newRow = Character.getNumericValue(target.charAt(2))-1;
        int newColumn =target.charAt(1)-'a';
        Pieces pieceToMove = board[row][column].getContent();
        board[row][column].setContent(null);
        board[newRow][newColumn].setContent(pieceToMove);



    }
    private void switchPlayer(){
        if (currentPlayer.getColor()==1){
            currentPlayer=players[0];
        }else{
            currentPlayer=players[1];
        }
    }
}
