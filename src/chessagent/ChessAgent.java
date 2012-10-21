
package chessagent;

public class ChessAgent {
    
    private int countNodes;
    
    public ChessAgent(){
        this.countNodes=0;
    }

    public MoveValue ids_minimax(Board board, int limit,int depth) {
        
        countNodes++;
        
        if(board.isCheckMate()){
            return new MoveValue(Integer.MAX_VALUE);
        }
        
        if(board.isStalemate()){
            return new MoveValue(0);
        }
        
        if (limit==depth){
            return new MoveValue(0);
        }
        
        MoveValue alpha = new MoveValue(Integer.MIN_VALUE);
        Move validMoves[] = board.getValidMoves();
        
        for(Move move : validMoves){
            Board state = board.clone();
            state.makeMove(move);
            
            MoveValue winner = minimax(state,limit+1,depth);
            winner.setMove(move);
            //winner.setValue(winner.getValue()*-1);
            
            if(alpha.getValue()<(-winner.getValue())){
               alpha = winner;
            }
            
        }
        return alpha;
    }

    public MoveValue dfs_minimax(Board board) {
        
        countNodes++;
        
        if(board.isCheckMate()){
            return new MoveValue(Integer.MAX_VALUE);
        }
        
        if(board.isStalemate()){
            return new MoveValue(0);
        }
        
        
        MoveValue alpha = new MoveValue(Integer.MIN_VALUE);
        Move validMoves[] = board.getValidMoves();
        
        for(Move move : validMoves){
            Board state = board.clone();
            state.makeMove(move);
            
            MoveValue winner = minimax(state);
            winner.setMove(move);
            
            if(alpha.getValue()<(-winner.getValue())){
               alpha = winner;
            }
            
        }
        return alpha;
    }

}
