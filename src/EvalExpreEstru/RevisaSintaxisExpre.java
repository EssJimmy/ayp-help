package EvalExpreEstru;
import Stacks.*;
import java.util.StringTokenizer;

/**
 * 
 * @author ANTONIO FABIAN RODRIGUEZ MARTINEZ, ADRIAN JANUS GONZALEZ ADAMUZ, XOCHITL AXALLI LOPEZ CHAVARRIA, JAIME ARMANDO PEREZ GARCIA
 */
public class RevisaSintaxisExpre {
    String infixStr;
    String infixArrStr[];
    String errSintaxis;
    String expresionStr[];
    
    public RevisaSintaxisExpre(){
        infixStr = null;
        infixArrStr = null;
        errSintaxis = "";
    }
    /**
     * Getter
     * @return errSintaxis 
     */
    public String getErrorMsg(){
        return errSintaxis;
    }
    /**
     * Getter
     * @return infixArrStr 
     */
    public String[] getArrStr(){
        return infixArrStr;
    }
    /**
     * Crea un Tokenizer de una expresión para luego determinar si la expresión es valida
     * si los parentesis estan balanceados y si no hay dos singos incoherentes juntos,
     * ademas si encuentra un operador unario lo cambia por un menos
     * @param expre
     * @return Un valor boolean que nos indica si esta bien la expresión
     */
    public boolean sintaxisExpre(String expre){
        if(expre == null) throw new
            ADTsException("RevisorParentesis(): infixStr is null.\n");
        
        int tam;
        boolean parenBalan, operaJuntos, ans;
        infixStr = expre.replace(" ","");
        StringTokenizer st = new StringTokenizer(infixStr, "()+-/*",true);
        tam = st.countTokens();
        infixArrStr = new String[tam];
        
        for(int j = 0; j<tam; j++)
            infixArrStr[j] = st.nextToken();
        parenBalan = parenteBalan();
        operaJuntos = sinParenOperaJuntos();
        ans = parenBalan && operaJuntos;
        if(ans)
            errSintaxis = "<Sin errrores>";
        for(int k = 0; k<tam; k++)
            if(infixArrStr[k].contains("~"))
                infixArrStr[k] = infixArrStr[k].replace("~","-");
        return ans;
    }
    /**
     * En cuanto encuentra un parentesis que abre lo mete a un Stack.
     * En cuanto encuentra un parentesis que cierra lo saca del Stack.
     * Si al final de la operación queda un parentesis en el stack marca error
     * porque los parentesis no estan balanceados.
     * @return un valor booleano indicando si la expresión esta balanceada
     */ 
    private boolean parenteBalan(){
        int i = 0;
        boolean ans = true;
        String token;
        ArrayStack<String> stackParen = new ArrayStack<>();
        
        while(i<infixArrStr.length && ans){
            token = infixArrStr[i];
            switch(token){
                case "(" ->{
                    stackParen.push(token);
                    break;
                }
                case ")" -> {
                    if(!stackParen.isEmpty() && stackParen.peek().equals("("))
                        stackParen.pop();
                    else 
                        ans = false;
                }
                default ->{
                    break;
                }
            }
            i++;
        }
        if(!stackParen.isEmpty()){
            errSintaxis = "<ERROR: parentesis no balanceados.>";
            ans = false;
        }
        return ans;
    }
    /**
     * Determina si el caracter es un operador
     * @param ch
     * @return un booleano indicando si el caracter es un operador
     */ 
    private boolean isOperator(char ch){
        return (ch == '+') || (ch == '-') || (ch == '/') || (ch == '*') ;
    }
    /**
     * Determina si dos operadores no lógicos estan juntos
     * @return un valor booleano indicando si hay operadores juntos;
     */
    private boolean sinParenOperaJuntos(){
        int tam = infixArrStr.length, i = 0;
        boolean ans;
        char ant, act;
        
        try{
        do{
            ant = infixArrStr[i].charAt(0);
            act = infixArrStr[i+1].charAt(0);
            if(ant == '(' && act == '-')
                ans = true;
            else
                ans = !((isOperator(ant) && (isOperator(act) || act == ')')) || (ant == '(' && isOperator(act)));
            i++;
        }while(i<tam-1 && ans);
        if(!ans)
            errSintaxis = errSintaxis + "<ERROR: () +-*/ consecutivos>";
        }
        catch(Exception ex){
            errSintaxis = errSintaxis + "<ERROR SINTACTICO>";
            ans = false;
        }
        return ans;
    }
}
