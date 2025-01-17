package Game;

import Game.pieces.*;


import java.util.Scanner;

public class Chess {
    private Cell[][] board;
    private Player[] players= new Player[2];
    private Player currentPlayer;

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
        for (int i = 7; i >=0; i--) {
            for (int j = 7; j >=0; j--) {
                board[i][j]=new Cell(true,new Position((char) (j+'a'),i));
            }
        }

        for (int i = 7; i >= 0; i--) {
            board[1][i].setContent(new Pawn(0,board[1][i].getPosition(),"P"));
        }
        for (int i = 7; i >=0; i--) {
            board[6][i].setContent(new Pawn(1,board[6][i].getPosition(),"P"));
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
        board[7][5].setContent(new Bishop(1,board[7][5].getPosition(),"B"));
        board[7][6].setContent(new Knight(1,board[7][6].getPosition(),"N"));
        board[7][7].setContent(new Rook(1,board[7][7].getPosition(),"R"));
    }
    private void printBoard(){

        for (int i = 7; i>=0; i--) {
            System.out.print("\n");
            System.out.print(i+1);
            for (int j = 0; j<8; j++) {
                if (((i + j) % 2 == 0)){
                    if (board[i][j].getContent() == null) {
                        System.out.print("\033[40m" + "   "+"\033[m");
                    } else {
                        if (board[i][j].getContent().getColor()==0) {
                            System.out.print("\033[40;97m"+" "+
                                    "\033[1;97m"+ board[i][j].getContent().toString()+" "+"\033[m");
                        }else{
                            System.out.print("\033[40;90m" + " "
                                    +"\033[1;90m"+board[i][j].getContent()
                                    .toString() + " "+"\033[m");
                        }
                    }
                } else{
                    if (board[i][j].getContent() == null) {
                        System.out.print("\033[47m" + "   "+"\033[m");
                    } else {
                        if (board[i][j].getContent().getColor()==0) {
                            System.out.print("\033[47;97m"+" "
                                    +"\033[1;97m"+ board[i][j].getContent().toString()+" "+"\033[m");
                        }else{
                            System.out.print("\033[47;90m" + " "
                                    +"\033[1;90m"+ board[i][j].getContent().toString()+ " "+"\033[m");
                        }
                    }
                }
            }
        }System.out.print("\n");
        System.out.println("  a  b  c  d  e  f  g  h ");

    }
    private String askMove() {
        Scanner sc = new Scanner(System.in);
        String scan;
        do {
            System.out.println(currentPlayer.getName()+
                    ", entrez votre movement sous la forme  piece colonne ligne (e.g:Pe2 Pe7)");
            scan = sc.nextLine();
            if(scan.length()!=7) System.out.println("le format du mouvement est incorrect, réessayez");
        } while (scan.length()!=7);
        return scan;
    }
    private boolean isCheckMate(){
        return false;
    }
    private Boolean isCheck(){
        // Trouver la position du roi du joueur
        int kingX = -1;
        int kingY = -1;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y].getContent() instanceof King &&
                        board[x][y].getContent().getColor() == currentPlayer.getColor()) {
                    kingX = x;
                    kingY = y;
                    break;
                }
            }
        }

        // Vérifier si le roi est menacé par une pièce adverse
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (board[x][y].getContent() != null &&
                        board[x][y].getContent().getColor() != currentPlayer.getColor()) {
                    if (board[x][y].getContent().isValidMove(board[kingX][kingY].getPosition(),board)) {
                        // Le roi est menacé
                        return true;
                    }
                }
            }
        }
        // Le roi n'est pas menacé
        return false;
    }

    private boolean isValidMove(String m){
        String[] moves= m.split(" ");
        int column=moves[0].charAt(1)-'a';
        int row = Character.getNumericValue(moves[0].charAt(2))-1;
        int newRow=Character.getNumericValue(moves[1].charAt(2))-1;
        if (board[row][column].getContent()
                != null &&moves[0].charAt(0) == board[row][column].getContent().toString().charAt(0)) {
            if (!(new Position(moves[1].charAt(1), newRow).isValid()) ||
                    board[row][column].getContent().getColor() != currentPlayer.getColor()) {
                System.out.println("invalid move, please enter a valid move");
                return false;
            } else {
                if (board[row][column].getContent().isValidMove(new Position(moves[1].charAt(1), newRow), board)) {
                    if (isCheck()){
                        System.out.println("Votre roi est menacé, protégez le.");
                        return false;
                    }
                    return true;
                }
                System.out.println("Cette piece ne peut pas bouger ainsi.");
                return false;
            }
        }else{
            System.out.println("Il n'y a pas de pieces sur cette case");
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
        board[newRow][newColumn].getContent().setPosition(board[newRow][newColumn].getPosition());
    }
    private void switchPlayer(){
        if (currentPlayer.getColor()==1){
            currentPlayer=players[0];
        }else{
            currentPlayer=players[1];
        }
    }
}
