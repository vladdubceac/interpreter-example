package learning.vladdubceac.interpreter;

public class Client {
    private InterpreterContext ic;

    public Client(InterpreterContext ic) {
        this.ic = ic;
    }

    public String interpret(String str){
        Expression expression = null;

        // perform the parsing
        if(str.contains("Hexadecimal")){
            expression = new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
        }else if(str.contains("Binary")){
            expression=new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
        }else{
            return str;
        }
        return expression.interpret(ic);
    }

    public static void main(String[] args) {
        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";

        Client ec = new Client(new InterpreterContext());
        System.out.println(str1+"= "+ec.interpret(str1));
        System.out.println(str2+"= "+ec.interpret(str2));
    }
}
