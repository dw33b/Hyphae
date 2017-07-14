/*
 * 
 * The point of this class is to drive the analysis of the segments using static methods.
 * 
 */
package hyphae;



public class SyntaxEngine{
    static int eval(String data){
        // PEMDAS, here I come!
        int marker;
        
        data = convertReserveWords(data);
        
        //Parentheses:
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '('){
                for(int j = i + 1; j < data.length(); j++){
                    if(data.charAt(j) == ')'){
                        data.replaceAll(data.substring(i + 1, j), "" + SyntaxEngine.eval(data.substring(i + 1, j)));
                        break;
                    }
                }
            }
        }
        //Exponents:
        data = Operate(data, '^', Segment.OP_BASIC_EXPONENT);
        //Multiplication:
        data = Operate(data, '*', Segment.OP_BASIC_MULTIPLY);
        //Division:
        data = Operate(data, '/', Segment.OP_BASIC_DIVIDE);
        //Addition:
        data = Operate(data, '+', Segment.OP_BASIC_ADD);
        //Subtraction:
        data = Operate(data, '-', Segment.OP_BASIC_SUBTRACT);
    }
    
    public static String Operate(String data, char Operator, int OpCode){// returns the original string if no instances of the specified operation can be located
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == Operator){
                for(int j = i + 1; j < data.length(); j++){
                    if(isNumber(data.substring(i + 1, j))) continue;
                    else for(int k = i - 1; k > 0; k--){
                        if(isNumber(data.substring(k, i))) continue;
                        else{
                            data.replaceAll(data.substring(k + 1, j), "" + (new Segment(OpCode, new Value(Integer.parseInt(data.substring(k + 1, i))), new Value(Integer.parseInt(data.substring(i + 1, j))))).eval());
                            return data;
                        }
                    }
                }
            }
        }
        return data;
    }
    
    private static String convertReserveWords(String data){
        //add a bunch of reserve word replacement operations for stuff such as total neighbors, or the value at a coordinate
    }
    
    private static boolean isNumber(String input){
        for(int i = 0; i < input.length(); i++){
            if((input.charAt(i) == '0') || (input.charAt(i) == '1') || (input.charAt(i) == '2') || (input.charAt(i) == '3') || (input.charAt(i) == '4') || (input.charAt(i) == '5') || (input.charAt(i) == '6') || (input.charAt(i) == '7') || (input.charAt(i) == '8') || (input.charAt(i) == '9')){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
