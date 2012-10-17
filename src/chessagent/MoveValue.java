/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessagent;

/**
 *
 * @author gmaldonado
 */
public class MoveValue{
    private Move move;
    private double value;
	    
    public MoveValue(){
        move=null;
        value=0;
    }
	    
    public MoveValue(Move m) {
        this.move=m;
        value=0;
    }
	    
    public MoveValue(double v){
        this.value=v;
        this.move=null;
    }
	    
    public MoveValue(Move m, double v){
        this.value=v;
        this.move=m;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}
