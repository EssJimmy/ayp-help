package EvalExpreEstru;
import Stacks.*;

/**
 *  @author ANTONIO FABIAN RODRIGUEZ MARTINEZ, ADRIAN JANUS GONZALEZ ADAMUZ, XOCHITL AXALLI LOPEZ CHAVARRIA, JAIME ARMANDO PEREZ GARCIA
 */
public class InfixToPostfix {
    private boolean conv;

    public InfixToPostfix() {
        conv = true;    // conversion ok
    }
    
    // Get-ter
    // Estuvo OK la conversión?
    public boolean convOK() {
        return conv;
    } 
    /**
     * Se le proporciona una expresión aritmetica infija para convertirla a una expresion posfija
     * @param infix
     * @return La expresion aritmetica convertida de infijo a posfijo
     */
    public String[] convInfixPostfix(String [] infix) {
        if (infix == null)
            throw new ADTsException("convInfixPostfix: Infix null.\n");
               
        RevisaSintaxisExpre rse = new RevisaSintaxisExpre();
        StringBuilder aux = new StringBuilder();
        String aux1, aux2;
        String postfix[] = new String[infix.length-numParentesis(infix)];
        String token;
        int cont = 0;
        ArrayStack<String> stackOper = new ArrayStack<>();
        
        for (String infix1 : infix)
            aux.append(infix1);
        aux1 = aux.toString().replace(" ","");
        conv = rse.sintaxisExpre(aux1);
        if(conv){
            for(int i = 0; i<infix.length; i++){
                token = infix[i];
                if(isOperator(token)){
                    while(!stackOper.isEmpty() && precedencia(stackOper.peek())>=precedencia(token)){
                        postfix[cont] = stackOper.pop();
                        cont++;
                    }
                stackOper.push(token);
                }
                else if(token.equals("(")){
                    stackOper.push(infix[i]);
                }
                else if(token.equals(")")){
                    aux2 = stackOper.pop();
                    while(!stackOper.isEmpty() && !aux2.equals("(")){
                        postfix[cont] = aux2;
                        cont++;
                        aux2 = stackOper.pop();
                    }
                }
                else if(isOperand(token)){
                    postfix[cont] = token;
                    cont++;
                }
            }
            while(!stackOper.isEmpty()){
                postfix[cont] = stackOper.pop();
                cont++;
            }
        }
        else throw new
            ADTsException(rse.getErrorMsg());
        return postfix;
    }
  
    /**
     *  Determina si el caracter especificado no es un operador o parentesis.
     * @param ch
     * @return Regresa verdadero, suponiendo operando; falso, en caso contrario.
     */
    private boolean isOperand (String ch) {
        boolean b;
        b = (ch.equals("(")) || (ch.equals(")")) || isOperator(ch);          
        return !b;
    }    
    /**
     *Determina si el caracter especificado es un operador.
     * @param ch
     * @return Regresa verdadero, si lo es; falso, en caso contrario.
     */
    private boolean isOperator (String ch) {
        boolean b;
        b = (ch.equals("+")) || (ch.equals("-")) ||
                  (ch.equals("*")) || (ch.equals("/"));          
        return b;
    }

    /**
    *Determina la precedencia de los operadores de la expresion. 
     * @param str
     * @return Regresa un numero mayor dependiendo de la precedencia.
     */
    private int precedencia(String str){
        int ans = -1;
        
        switch(str){
            case "+", "-" -> ans = 1;
            case "*", "/" -> ans = 2;
            case "^" -> ans = 3;
        }
        return ans;
    }
    /**
     * Cuenta el numero de parentesis en una expresión
     * @param infix
     * @return un contador int con el numero de parentesis.
     */
    private int numParentesis(String infix[]){
        int ans = 0;
        
        for (String infix1 : infix)
            if (infix1.equals("(") || infix1.equals(")")) 
                ans++;
        return ans;
    }
}
