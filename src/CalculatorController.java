import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    private StringBuilder expression = new StringBuilder("");

    @FXML
    private Button one, two, three, four, five, six, seven, eight, nine, zero, floatPoint;

    @FXML
    private Button addition, subtraction, multiplication, division, squareRoot,percentage,equal, reset;

    @FXML
    private TextField display;

    @FXML
    void handleButtonAction(ActionEvent event) {
        numberHandler(event);
        operationHandler(event);
    }

    private void numberHandler(ActionEvent event){
        if(event.getSource() == one){
            display.setText(display.getText() + "1");
            expression.append("1");
        }else if(event.getSource() == two){
            display.setText(display.getText() + "2");
            expression.append("2");
        }else if(event.getSource() == three){
            display.setText(display.getText() + "3");
            expression.append("3");
        }else if(event.getSource() == four){
            display.setText(display.getText() + "4");
            expression.append("4");
        }else if(event.getSource() == five){
            display.setText(display.getText() + "5");
            expression.append("5");
        }else if(event.getSource() == six){
            display.setText(display.getText() + "6");
            expression.append("6");
        }else if(event.getSource() == seven){
            display.setText(display.getText() + "7");
            expression.append("7");
        }else if(event.getSource() == eight){
            display.setText(display.getText() + "8");
            expression.append("8");
        }else if(event.getSource() == nine){
            display.setText(display.getText() + "9");
            expression.append("9");
        }else if(event.getSource() == zero){
            display.setText(display.getText() + "0");
            expression.append("0");
        }else if(event.getSource() == floatPoint){
            String displayString = display.getText();
            display.setText(displayString + ".");
            expression.append(".");
            floatPoint.setDisable(true);
        }
    }

    private void operationHandler(ActionEvent event){
        float firstOperand,unaryOperationResult;

        if(event.getSource() == addition) {
            display.setText("");
            expression.append("+");
        }


        else if(event.getSource() == subtraction) {
            display.setText("");
            expression.append("-");
        }

        else if(event.getSource() == multiplication) {
            display.setText("");
            floatPoint.setDisable(false);
            expression.append("*");
        }

        else if(event.getSource() == division) {
            display.setText("");
            expression.append("/");
        }

        else if(event.getSource() == squareRoot) {
            String firstOperandString = display.getText();
            if(validate(firstOperandString)) {
                firstOperand = Float.parseFloat(firstOperandString);
                unaryOperationResult = Calculator.squareRoot(firstOperand);
                display.setText(String.valueOf(unaryOperationResult));
            }
            floatPoint.setDisable(true);
        }

        else if(event.getSource() == percentage) {
            String firstOperandString = display.getText();
            if(validate(firstOperandString)) {
                firstOperand = Float.parseFloat(firstOperandString);
                unaryOperationResult = Calculator.percent(firstOperand);
                display.setText(String.valueOf(unaryOperationResult));
            }
            floatPoint.setDisable(true);
        }

        else if(event.getSource() == equal) {
            //System.out.println(expression.toString());
            String result = Calculator.calculateExpression(expression.toString());
            display.setText(result);
        }

        else if(event.getSource() == reset) {
            display.setText("");
            floatPoint.setDisable(false);
            expression = new StringBuilder("");
        }
    }

    private boolean validate(String str){
        // not implement yet
        return true;
    }
}

