package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide};
    private double data1 = 0, data2 =0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btn00Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit); //edit text is a widget of user interface used to retrieve and modify text date from a user, child class of Textview
        eText.setText(eText.getText()+ "0"); //adds string to current text in get text, ex when you enter 43, you need to append strings
    }

    public void btn01Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "1");
    }

    public void btn02Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "2");
    }

    public void btn03Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "3");
    }

    public void btn04Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "4");
    }

    public void btn05Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "5");
    }

    public void btn06Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "6");
    }

    public void btn07Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "7");
    }

    public void btn08Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "8");
    }
    public void btn09Click(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText()+ "9");
    }

    //less redundant function when pressing number button
    public void onClickNumericalButton(View view){
        int pressID = view.getId();
        TextView curText = (TextView)findViewById(R.id.resultEdit);

        //classifying the id of the button you just clicked
        if (pressID == R.id.btn00){
            curText.setText(curText.getText() + "0");
        }
        else if(pressID == R.id.btn01){
            curText.setText(curText.getText() + "1");
        }
        else if(pressID == R.id.btn02){
            curText.setText(curText.getText() + "2");
        }
        else if(pressID == R.id.btn03){
            curText.setText(curText.getText() + "3");
        }
        else if(pressID == R.id.btn04){
            curText.setText(curText.getText() + "4");
        }
        else if(pressID == R.id.btn05){
            curText.setText(curText.getText() + "5");
        }
        else if(pressID == R.id.btn06){
            curText.setText(curText.getText() + "6");
        }
        else if(pressID == R.id.btn07){
            curText.setText(curText.getText() + "7");
        }
        else if(pressID == R.id.btn08){
            curText.setText(curText.getText() + "8");
        }
        else if(pressID == R.id.btn09){
            curText.setText(curText.getText() + "9");
        }
        else{
            curText.setText("ERROR");
            Log.d("Error", "Error: Unknown Button pressed!");
        }
    }
    public void btnAddClick(View view){
        optr = Operator.add;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1= Double.parseDouble(eText.getText().toString()); //saves prev number under data1
        eText.setText("");
    }

    public void btnMinusClick(View view){
        optr = Operator.minus;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1= Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultiplyClick(View view){
        optr = Operator.multiply;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1= Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideClick(View view){
        optr = Operator.divide;
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        data1= Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText("");
    }
    public void btnDotClick(View view){
        EditText eText = (EditText) findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + ".");
    }

    public void btnResultClick(View view){
        if(optr != Operator.none){
            EditText eText = (EditText) findViewById(R.id.resultEdit);
            data2= Double.parseDouble(eText.getText().toString()); //sets the current number in the view to data 2, remember, operator does not display in the edittext
            double result = 0;

            if(optr == Operator.add){
                result = data1 + data2;
            }
            else if(optr == Operator.minus){
                result = data1 - data2;
            }
            else if(optr == Operator.multiply){
                result = data1 * data2;
            }
            else if(optr == Operator.divide){
                result = data1 / data2;
            }
            //setting operator back to none since u alr used it
            optr = Operator.none;
            data1 = result;

            if((result - (int)result) !=0){ //checks whether the result is a whole number, bc if its fractional, it will equal 0.0
                eText.setText(String.valueOf(result)); //thus displays the result as a string, with decimal point
            }
            else{
                eText.setText(String.valueOf((int)result));
            }
        }
    }




}