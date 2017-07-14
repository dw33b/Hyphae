/*
 * 
 * The point of this class is to hold an operation type, an evaluation method, and an array of values being operated on
 * 
 */

package hyphae;



public class Segment{
    
    public final int OPERATOR;
    public Segment data1, data2;
    
    public Segment(int operator, Segment data1, Segment data2){
        this.OPERATOR = operator;
        this.data1 = data1;
        this.data2 = data2;
    }
    public Segment(){
        this.OPERATOR = -1; // this means that the segment is a placeholder to take up space in an argument
    }
    public int eval(){
        
        switch(OPERATOR){
            
            //case OP_BASIC_PARENTHESES:
            //    return (SyntaxEngine.eval(data1));
            
            //Basic Math
            
            case OP_BASIC_ADD:
                return (data1.eval() + data2.eval());
                
            case OP_BASIC_SUBTRACT:
                return (data1.eval() - data2.eval());
                
            case OP_BASIC_MULTIPLY:
                return (data1.eval() * data2.eval());
                
            case OP_BASIC_DIVIDE:
                return (data1.eval() / data2.eval());
                
            case OP_BASIC_EXPONENT:
                return ((int)Math.pow(data1.eval(), data2.eval()));
                
            case OP_BASIC_ROOT:
                return ((int)Math.pow(data1.eval(), (1 / data2.eval())));
                
            case OP_BASIC_LOGARITHM:
                return (int)(Math.log10(data2.eval()) / Math.log10(data1.eval()));
                
            //Neighborhood
            
            case OP_NBRHD_TOTAL:
                return (int)(Math.log10(data2.eval()) / Math.log10(data1.eval()));
                
            case OP_NBRHD_COORD:
                return (int)(Math.log10(data2.eval()) / Math.log10(data1.eval()));
            
            case OP_NBRHD_AVERAGE:
                return (int)(Math.log10(data2.eval()) / Math.log10(data1.eval()));
                
            case OP_NBRHD_MAX:
                return (int)(Math.log10(data2.eval()) / Math.log10(data1.eval()));
               
            case OP_NBRHD_MIN:
                return (int)(Math.log10(data2.eval()) / Math.log10(data1.eval()));
                
            //Comparison
                
            case OP_COMPR_LESSER:
                return (data1.eval() < data2.eval())? 1 : 0;
                
            case OP_COMPR_GREATER:
                return (data1.eval() > data2.eval())? 1 : 0;
                
            case OP_COMPR_EQUAL:
                return (data1.eval() == data2.eval())? 1 : 0;
                
            case OP_COMPR_NOTEQUAL:
                return (data1.eval() != data2.eval())? 1 : 0;
                
            case OP_COMPR_AND:
                return ((data1.eval() > 0) && (data2.eval() > 0))? 1 : 0;
                
            case OP_COMPR_OR:
                return ((data1.eval() > 0) || (data2.eval() > 0))? 1 : 0;
                
            case OP_COMPR_XOR:
                return ((data1.eval() > 0) ^ (data2.eval() > 0))? 1 : 0;
                
            //Default (constant)
            
        }
        
        return 0; // debug
    }
    //       ________________                   []
    //      /                \                  []
    //      | [ BASIC MATH ] |                  []
    //      \________________/                  []
    //                                          []
    public static final int OP_BASIC_PARENTHESES =     0;
    public static final int OP_BASIC_ADD =             1;
    public static final int OP_BASIC_SUBTRACT =        2;
    public static final int OP_BASIC_MULTIPLY =        3;
    public static final int OP_BASIC_DIVIDE =          4;
    public static final int OP_BASIC_EXPONENT =        5;
    public static final int OP_BASIC_ROOT =            6;
    public static final int OP_BASIC_LOGARITHM =       7;
    //       ________________                   []
    //      /                \                  []
    //      | [NEIGHBORHOOD] |                  []
    //      \________________/                  []
    //                                          []
    public static final int OP_NBRHD_TOTAL =           8;
    public static final int OP_NBRHD_COORD =           9;
    public static final int OP_NBRHD_AVERAGE =         10;
    public static final int OP_NBRHD_MAX =             11;
    public static final int OP_NBRHD_MIN =             12;
    public static final int OP_NBRHD_reserved1 =       13;
    public static final int OP_NBRHD_reserved2 =       14;
    public static final int OP_NBRHD_reserved3 =       15;
    //       ________________                   []
    //      /                \                  []
    //      | [ COMPARISON ] |                  []
    //      \________________/                  []
    //                                          []
    public static final int OP_COMPR_LESSER =          16;
    public static final int OP_COMPR_GREATER =         17;
    public static final int OP_COMPR_EQUAL =           18;
    public static final int OP_COMPR_NOTEQUAL =        19;
    public static final int OP_COMPR_AND =             20;
    public static final int OP_COMPR_OR =              21;
    public static final int OP_COMPR_XOR =             22;
    public static final int OP_COMPR_reserved1 =       23;
}
