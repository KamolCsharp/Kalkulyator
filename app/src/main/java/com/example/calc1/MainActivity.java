package com.example.calc1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private int openParenthesis = 0;
    private boolean dotUsed = false;
    private boolean equalClicked = false;
    private String lastExpression = "";
    private final static int EXCEPTION = -1;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_OPEN_PARENTHESIS = 2;
    private final static int IS_CLOSE_PARENTHESIS = 3;
    private final static int IS_DOT = 4;
    Button buttonNumber0;
    Button buttonNumber1;
    Button buttonNumber2;
    Button buttonNumber3;
    Button buttonNumber4;
    Button buttonNumber5;
    Button buttonNumber6;
    Button buttonNumber7;
    Button buttonNumber8;
    Button buttonNumber9;
    private String lastInput;

    Button buttonClear;
    Button buttonParentheses;
    Button buttonPercent;
    Button buttonDivision;
    Button buttonMultiplication;
    Button buttonSubtraction;
    Button buttonAddition;
    Button buttonEqual;
    Button buttonDot;
    Button buttonTozalash;
    StringBuffer str;
    TextView textViewInputNumbers;
    boolean t;

    ScriptEngine scriptEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str = new StringBuffer();
        scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
        initializeViewVariables();
        setOnClickListeners();
        setOnTouchListener();
    }

    private void setOnClickListeners() {
        buttonNumber0.setOnClickListener(this);
        buttonNumber1.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);

        buttonClear.setOnClickListener(this);
        buttonParentheses.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonTozalash.setOnClickListener(this);
    }

    private void initializeViewVariables() {
        buttonNumber0 = findViewById(R.id.button_zero);
        buttonNumber1 = findViewById(R.id.button_one);
        buttonNumber2 = findViewById(R.id.button_two);
        buttonNumber3 = findViewById(R.id.button_three);
        buttonNumber4 = findViewById(R.id.button_four);
        buttonNumber5 = findViewById(R.id.button_five);
        buttonNumber6 = findViewById(R.id.button_six);
        buttonNumber7 = findViewById(R.id.button_seven);
        buttonNumber8 = findViewById(R.id.button_eight);
        buttonNumber9 = findViewById(R.id.button_nine);

        buttonClear = findViewById(R.id.button_clear);
        buttonParentheses = findViewById(R.id.button_parentheses);
        buttonPercent = findViewById(R.id.button_percent);
        buttonDivision = findViewById(R.id.button_division);
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonSubtraction = findViewById(R.id.button_subtraction);
        buttonAddition = findViewById(R.id.button_addition);
        buttonEqual = findViewById(R.id.button_equal);
        buttonDot = findViewById(R.id.button_dot);
        buttonTozalash = findViewById(R.id.button_tozalash);
        textViewInputNumbers = findViewById(R.id.textView_input_numbers);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setOnTouchListener() {
        buttonNumber0.setOnTouchListener(this);
        buttonNumber1.setOnTouchListener(this);
        buttonNumber2.setOnTouchListener(this);
        buttonNumber3.setOnTouchListener(this);
        buttonNumber4.setOnTouchListener(this);
        buttonNumber5.setOnTouchListener(this);
        buttonNumber6.setOnTouchListener(this);
        buttonNumber7.setOnTouchListener(this);
        buttonNumber8.setOnTouchListener(this);
        buttonNumber9.setOnTouchListener(this);

        buttonClear.setOnTouchListener(this);
        buttonParentheses.setOnTouchListener(this);
        buttonPercent.setOnTouchListener(this);
        buttonDivision.setOnTouchListener(this);
        buttonMultiplication.setOnTouchListener(this);
        buttonSubtraction.setOnTouchListener(this);
        buttonAddition.setOnTouchListener(this);
        buttonDot.setOnTouchListener(this);
        buttonTozalash.setOnTouchListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_zero:
                if (addNumber("0")) equalClicked = false;
                t=false;
                break;
            case R.id.button_one:
                if (addNumber("1")) equalClicked = false;
                t=false;
                break;
            case R.id.button_two:
                if (addNumber("2")) equalClicked = false;
                t=false;
                break;
            case R.id.button_three:
                if (addNumber("3")) equalClicked = false;
                t=false;
                break;
            case R.id.button_four:
                if (addNumber("4")) equalClicked = false;
                t=false;
                break;
            case R.id.button_five:
                if (addNumber("5")) equalClicked = false;
                t=false;
                break;
            case R.id.button_six:
                if (addNumber("6")) equalClicked = false;
                t=false;
                break;
            case R.id.button_seven:
                if (addNumber("7")) equalClicked = false;
                t=false;
                break;
            case R.id.button_eight:
                if (addNumber("8")) equalClicked = false;
                t=false;
                break;
            case R.id.button_nine:
                if (addNumber("9")) equalClicked = false;
                t=false;
                break;
            case R.id.button_addition:
                if(t){
                    textViewInputNumbers.setText(textViewInputNumbers.getText().toString().substring(0,textViewInputNumbers.getText().toString().length()-1));
                    lastInput=lastInput.substring(0,lastInput.length()-1);
                    if (addOperand("+")) equalClicked = false;
                    t=true;
                }
                else{
                    if (addOperand("+")) equalClicked = false;
                    t=true;
                }

                break;
            case R.id.button_subtraction:
                if(t){
                    textViewInputNumbers.setText(textViewInputNumbers.getText().toString().substring(0,textViewInputNumbers.getText().toString().length()-1));

                    lastInput=lastInput.substring(0,lastInput.length()-1);
                    if (addOperand("-")) equalClicked = false;
                    t=true;
                }
                else{
                    if (addOperand("-")) equalClicked = false;
                    t=true;
                }
                break;
            case R.id.button_multiplication:
                if(t){
                    textViewInputNumbers.setText(textViewInputNumbers.getText().toString().substring(0,textViewInputNumbers.getText().toString().length()-1));

                    lastInput=lastInput.substring(0,lastInput.length()-1);
                    if (addOperand("x")) equalClicked = false;
                    t=true;
                }
                else{
                    if (addOperand("x")) equalClicked = false;
                    t=true;
                }
                break;
            case R.id.button_division:
                if(t){
                    textViewInputNumbers.setText(textViewInputNumbers.getText().toString().substring(0,textViewInputNumbers.getText().toString().length()-1));

                    lastInput=lastInput.substring(0,lastInput.length()-1);
                    if (addOperand("\u00F7")) equalClicked = false;
                    t=true;
                }
                else{
                    if (addOperand("\u00F7")) equalClicked = false;
                    t = true;
                }
                break;
            case R.id.button_percent:
                if (addOperand("%")) equalClicked = false;
                break;
            case R.id.button_dot:
                if (addDot()) equalClicked = false;
                break;
            case R.id.button_parentheses:
                if (addParenthesis()) equalClicked = false;
                break;
            case R.id.button_clear:
                textViewInputNumbers.setText("");
                openParenthesis = 0;
                t=false;
                dotUsed = false;
                lastExpression = "";
                equalClicked = false;
                break;
            case R.id.button_tozalash: {
                if (textViewInputNumbers.getText().length() > 0) {
                    str.append(textViewInputNumbers.getText().toString());
                    str.delete(str.length() - 1, str.length());
                    textViewInputNumbers.setText(str);
                    t=false;
                    str.delete(0, str.length());
                } else {
                    Toast.makeText(getApplicationContext(), "raqam qolmadi", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case R.id.button_equal:
                if (textViewInputNumbers.getText().toString() != null && !textViewInputNumbers.getText().toString().equals(""))
                    calculate(textViewInputNumbers.getText().toString());
                break;
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }

    @SuppressLint("SetTextI18n")
    private boolean addDot() {
        boolean done = false;

        if (textViewInputNumbers.getText().length() == 0 ) {
            textViewInputNumbers.setText("0.");
            dotUsed = true;
            done = true;
        } else if (dotUsed) {
        } else if (defineLastCharacter(textViewInputNumbers.getText().charAt(textViewInputNumbers.getText().length() - 1) + "") == IS_OPERAND ) {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + "0.");
            done = true;
            dotUsed = true;
        } else if (defineLastCharacter(textViewInputNumbers.getText().charAt(textViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER ) {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + ".");
            done = true;
            dotUsed = true;
        }
        return done;
    }

    @SuppressLint("SetTextI18n")
    private boolean addParenthesis() {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();

        if (operationLength == 0) {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
            dotUsed = false;
            openParenthesis++;
            done = true;
        } else if (openParenthesis > 0 && operationLength > 0) {
            String lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            switch (defineLastCharacter(lastInput)) {
                case IS_NUMBER:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + ")");
                    done = true;
                    openParenthesis--;
                    dotUsed = false;
                    break;
                case IS_OPERAND:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
                    done = true;
                    openParenthesis++;
                    dotUsed = false;
                    break;
                case IS_OPEN_PARENTHESIS:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
                    done = true;
                    openParenthesis++;
                    dotUsed = false;
                    break;
                case IS_CLOSE_PARENTHESIS:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + ")");
                    done = true;
                    openParenthesis--;
                    dotUsed = false;
                    break;
            }
        } else if (openParenthesis == 0 && operationLength > 0) {
            String lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            if (defineLastCharacter(lastInput) == IS_OPERAND) {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
                done = true;
                dotUsed = false;
                openParenthesis++;
            } else {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "x(");
                done = true;
                dotUsed = false;
                openParenthesis++;
            }
        }
        return done;
    }

    @SuppressLint("SetTextI18n")
    private boolean addOperand(String operand) {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();
        if (operationLength > 0) {
            lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            if ((lastInput.equals("+") || lastInput.equals("-") || lastInput.equals("*") || lastInput.equals("\u00F7") || lastInput.equals("%"))) {
                Toast.makeText(getApplicationContext(), "Xatolik yuz berdi", Toast.LENGTH_LONG).show();
            } else if (operand.equals("%") && defineLastCharacter(lastInput) == IS_NUMBER) {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            } else if (!operand.equals("%")) {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Xatolik yuz berdi", Toast.LENGTH_LONG).show();
        }
        return done;
    }

    private boolean addNumber(String number) {
        boolean done = false;

        int operationLength = textViewInputNumbers.getText().length();
        if (operationLength > 0) {
            String lastCharacter = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            int lastCharacterState = defineLastCharacter(lastCharacter);

            if (operationLength == 1 && lastCharacterState == IS_NUMBER && lastCharacter.equals("0")) {
                textViewInputNumbers.setText(number);
                done = true;
            } else if (lastCharacterState == IS_OPEN_PARENTHESIS) {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
                done = true;
            } else if (lastCharacterState == IS_CLOSE_PARENTHESIS || lastCharacter.equals("%")) {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "x" + number);
                done = true;
            } else if (lastCharacterState == IS_NUMBER || lastCharacterState == IS_OPERAND || lastCharacterState == IS_DOT) {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
                done = true;
            }
        } else {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
            done = true;
        }
        return done;
    }


    private void calculate(String input) {
        String result = "";
        try {
            String temp = input;
            if (equalClicked) {
                temp = input + lastExpression;
            } else {
                saveLastExpression(input);
            }
            result = scriptEngine.eval(temp.replaceAll("%", "/100").replaceAll("x", "*").replaceAll("[^\\x00-\\x7F]", "/")).toString();
            BigDecimal decimal = new BigDecimal(result);
            result = decimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString();
            equalClicked = true;


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Notogri format", Toast.LENGTH_SHORT).show();
            return;
        }

        if (result.equals("Infinity")) {
            Toast.makeText(getApplicationContext(), "Nolga bolish mumkin emas!!!", Toast.LENGTH_SHORT).show();
            textViewInputNumbers.setText(input);

        } else if (result.contains(".")) {
            result = result.replaceAll("\\.?0*$", "");
            textViewInputNumbers.setText(result);
        }
  }

    private void saveLastExpression(String input) {
        String lastOfExpression = input.charAt(input.length() - 1) + "";
        if (input.length() > 1) {
            if (lastOfExpression.equals(")")) {
                lastExpression = ")";
                int numberOfCloseParenthesis = 1;

                for (int i = input.length() - 2; i >= 0; i--) {
                    if (numberOfCloseParenthesis > 0) {
                        String last = input.charAt(i) + "";
                        if (last.equals(")")) {
                            numberOfCloseParenthesis++;
                        } else if (last.equals("(")) {
                            numberOfCloseParenthesis--;
                        }
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(input.charAt(i) + "") == IS_OPERAND) {
                        lastExpression = input.charAt(i) + lastExpression;
                        break;
                    } else {
                        lastExpression = "";
                    }
                }
            } else if (defineLastCharacter(lastOfExpression + "") == IS_NUMBER) {
                lastExpression = lastOfExpression;
                for (int i = input.length() - 2; i >= 0; i--) {
                    String last = input.charAt(i) + "";
                    if (defineLastCharacter(last) == IS_NUMBER || defineLastCharacter(last) == IS_DOT) {
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(last) == IS_OPERAND) {
                        lastExpression = last + lastExpression;
                        break;
                    }
                    if (i == 0) {
                        lastExpression = "";
                    }
                }
            }
        }
    }

    private int defineLastCharacter(String lastCharacter) {
        try {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException e) {
        }

        if ((lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("x") || lastCharacter.equals("\u00F7") || lastCharacter.equals("%")))
            return IS_OPERAND;

        if (lastCharacter.equals("("))
            return IS_OPEN_PARENTHESIS;

        if (lastCharacter.equals(")"))
            return IS_CLOSE_PARENTHESIS;

        if (lastCharacter.equals("."))
            return IS_DOT;

        return -1;
    }
}
