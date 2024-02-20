package EvalExpreEstru;
import java.util.Stack;

/**
 * @author ANTONIO FABIAN RODRIGUEZ MARTINEZ, ADRIAN JANUS GONZALEZ ADAMUZ, XOCHITL AXALLI LOPEZ CHAVARRIA, JAIME ARMANDO PEREZ GARCIA
 */
public class PostfixEvaluator {
    
    // Pila o Stack de evaluacion de operandos
    private Stack<Double> stackOprnd;
  
    //Constructor.
    public PostfixEvaluator() {
        stackOprnd = new Stack<>();
    }

    /**
    * Evalua la operacion postfija especificada.Si se encuentra un operando,
    * se guarda en la pila.Si se encuentra un operador, se obtienen
    *  los dos operandos del tope, se evalua la operacion y el resultado
    *  se vuelve a guardar en la pila. Regresa el valor (real) de la expresion (que es el unico que esta 
    * en la pila).
     * @param Postfix
     * @return 
    */
    public double evaluate (String Postfix[]) {
        double op1, op2, result = 0;
        int ex;
        String token;
        char sch;

        // Parsing
        ex = Postfix.length;
        for(int i = 0; i < ex; i++) {
            token = Postfix[i];
            if(token.length()>1 && token.contains("-"))
                sch = token.charAt(1);
            else
                sch = token.charAt(0);
            if (isOperator(sch)) {
                op2 = stackOprnd.pop();
                op1 = stackOprnd.pop();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stackOprnd.push(result);
            }
            else {
                stackOprnd.push(Double.parseDouble(token));
            }
            //stack.push(new Double(String.valueOf(car)));
        }
        result= stackOprnd.pop();
        while(!stackOprnd.isEmpty()) {
            stackOprnd.pop();
            result = 0.0;    //Error si quedo algo más
        }
        return result;
    }
  
    /**
     * Determina si el caracter especificado es un operador.
     * @param ch
     * @return Regresa verdadero, si lo es; falso, en caso contrario.
     */
    private boolean isOperator (char ch) {
          boolean b;
          b = (ch == '+') || (ch == '-') ||
                  (ch == '*') || (ch == '/');          
    return b;
  }

  /**
   * Realiza una evaluacion sobre una expresion simple consistente
   * del operador especificado y dos operandos.
   * op1 es el primer operando y op2 el segundo.
   * @param operation
   * @param op1
   * @param op2
   * @return  * Regresa el valor (real) de la expresion.
   */
  private double evaluateSingleOperator (char operation, double op1, double op2) {
    double result = 0;

    switch (operation) {
      case '+':
        result = op1 + op2;
        break;
      case '-':
        result = op1 - op2;
        break;
      case '*':
        result = op1 * op2;
        break;
      case '/':
        result = op1 / op2;
    }
    return result;    
  }
    
}
