public class Calculator {
    private  int first;
    private  String operator;
    private  int second;
    private double result;

    public Calculator() {
    }

    public Calculator(int first, String operator, int second) {
        this.first = first;
        this.operator = operator;
        this.second = second;
    }

    public String calculate( ){

        switch (operator){
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                try {
                    result = first / second;
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
        return ""+result;

    }

    @Override
    public String toString() {
        return ""+result;
    }
}
