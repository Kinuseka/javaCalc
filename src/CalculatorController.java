import java.math.BigDecimal;

public class CalculatorController {
    private double firstNumber = 0;
    private String operator = "";
    private final CalculatorEngine engine;

    public CalculatorController(){
        this.engine = new CalculatorEngine();
    }

    public void setOperator(String op, String currentDisplay){
        if (!currentDisplay.isEmpty()){
            firstNumber = Double.parseDouble(currentDisplay);
            operator = op;
        }
    }

    public String calculate(String currentDisplay){
        if (currentDisplay.isEmpty()) return "";

        double secondNumber = Double.parseDouble(currentDisplay);
        double res = 0;

        switch(operator){
            case "+":
                res = engine.add(firstNumber, secondNumber);
                break;
            case "-":
                res = engine.subtract(firstNumber, secondNumber);
                break;
            case "*":
                res = engine.multiply(firstNumber, secondNumber);
                break;
            case "/":
                res = engine.divide(firstNumber, secondNumber);
                break;
        }

        return formatNumber(res);
    }

    private static String formatNumber(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().toPlainString();
        // long nearest = Math.round(value);
        // if (Math.abs(value - nearest) < 1e-9) {
        //     return Long.toString(nearest);
        // }
        // return Double.toString(value);
    }

    public void clear(){
        firstNumber = 0;
        operator = "";
    }

}
