/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Bluechip
 */
public class Function {
    String result = "";
    public String cal(Double x, Double y, String operator){
        switch (operator){
            case "+":
                result = String.valueOf(x+y);
                break;
            case "-":
                result = String.valueOf(x-y);
                break;
            case "*":
                result = String.valueOf(x*y);
                break;
            case "/":
                if(y==0)
                    result = "Math Error";
                result = String.valueOf(x/y);
                break;
                
            default:
                result = "0";
        }
        
        return result;
    }
}
