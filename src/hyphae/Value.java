/*
 * 
 * This class extends Segment, and represents constants or parantheticals
 * 
 */

package hyphae;



public class Value extends Segment{
    
    private final boolean CONSTANTnotPAR;
    private final int value;
    private final String PAR_DATA;
    
    public Value(int value, Segment data1, Segment data2){
        super(-1, data1, data2);
        this.CONSTANTnotPAR = true;
        this.value = value;
        this.PAR_DATA = "";
    }
    public Value(int value){
        this.CONSTANTnotPAR = true;
        this.value = value;
        this.PAR_DATA = "";
    }
    public Value(String data){
        super(-1, new Segment(), new Segment());
        this.CONSTANTnotPAR = false;
        this.value = 0;
        this.PAR_DATA = "";
    }
    
    @Override
    public int eval(){
        if(CONSTANTnotPAR) return value;
        else{
            return (SyntaxEngine.eval(PAR_DATA));
        }
    }
}
