
package chessagent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    private static Board board;
    private static int temporalBoard[][];
    private static final int rows=8;
    private static ChessAgent chessAgent;
    
    public static void main(String[] args) {
        board = new Board();
        chessAgent = new ChessAgent();
        temporalBoard = new int[rows][rows];
        readFile(args[0]);
        System.out.println(chessAgent.minimax(board,0,6).getMove().toString());
    }
    
    private static void readFile(String filePath){
      File file = null;
      FileReader fileReader = null;
      BufferedReader bufferedReader = null;
      String line;
      int turnWhite = Board.TURNWHITE;
      int turnBlack = Board.TURNBLACK;
      
      try{
          file = new File(filePath);
          fileReader = new FileReader(file);
          bufferedReader = new BufferedReader(fileReader);
          
          for(int i=0;i<rows;i++){
              line = bufferedReader.readLine();
              String slots[] = line.split("\\s");
              for(int j=0;j<rows;j++){
                  temporalBoard[i][j] = Integer.parseInt(slots[j]);
              }
          }

          board.fromArray(temporalBoard);
          board.setShortCastle(turnWhite,false);
          board.setShortCastle(turnBlack,false);
          board.setLongCastle(turnWhite,false);
          board.setLongCastle(turnBlack,false);
          
          line = bufferedReader.readLine();
          if(line.equals("B")){
              board.setTurn(turnWhite);
          }
          else{
              board.setTurn(turnBlack);
          }
          
          line = bufferedReader.readLine();
          while(line!=null){
              if(line.equals("EnroqueL_B")){
                  board.setLongCastle(turnWhite, true);
              }
              if(line.equals("EnroqueC_B")){
                  board.setShortCastle(turnWhite, true);
              }
              if(line.equals("EnroqueL_N")){
                  board.setLongCastle(turnBlack,true);
              }
              if(line.equals("EnroqueC_N")){
                  board.setShortCastle(turnBlack, true);
              }
              /*if(line.contains("MovsHastaEmpate")){
                  String[] movements = line.split(" ");
                  int movsCounter = Integer.parseInt(movements[1]);
                  board.movestodraw = movsCounter;
              }
              if(line.contains("AlPaso")){
              }*/
        
              
              line = bufferedReader.readLine();
          }
      }
      catch(Exception exception){
          
      }
    }
}
