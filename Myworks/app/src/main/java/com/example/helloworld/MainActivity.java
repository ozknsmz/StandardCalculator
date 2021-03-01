package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result_screen;
    private Button ac_b, square_b, delete_b, divisor_b, seven_b ,eight_b, nine_b, multip_b, four_b, five_b, six_b, mines_b, one_b, two_b, three_b, plus_b, zeroes_b, point_b, answer_b, equal_b;
    private String input,Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_screen=findViewById(R.id.result_screen);
        ac_b=findViewById(R.id.ac_b);
        square_b=findViewById(R.id.square_b);
        delete_b=findViewById(R.id.delete_b);
        divisor_b=findViewById(R.id.divisor_b);
        seven_b=findViewById(R.id.seven_b);
        eight_b=findViewById(R.id.eight_b);
        nine_b=findViewById(R.id.nine_b);
        multip_b=findViewById(R.id.multip_b);
        four_b=findViewById(R.id.four_b);
        five_b=findViewById(R.id.five_b);
        six_b=findViewById(R.id.six_b);
        mines_b=findViewById(R.id.mines_b);
        one_b=findViewById(R.id.one_b);
        two_b=findViewById(R.id.two_b);
        three_b=findViewById(R.id.three_b);
        plus_b=findViewById(R.id.plus_b);
        zeroes_b=findViewById(R.id.zeroes_b);
        point_b=findViewById(R.id.point_b);
        answer_b=findViewById(R.id.answer_b);
        equal_b=findViewById(R.id.equal_b);
    }

    public void ButtonClick(View View)
    {
        Button button = (Button) View;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                input="";
                break;

            case "ANS":
                input+=Answer;
                break;
            case "*":
                solve();
                input+="*";
                break;
            case "^":
                solve();
                input+="^";
                break;
            case "=":
                solve();
                Answer=input;
                break;

            case "D":
                String newText = input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-")|| data.equals("/")){
                    solve();
                }
                input+=data;

        }
        result_screen.setText(input);
    }

    private void solve(){

        if(input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input=mul+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }

        else if(input.split("/").length==2){
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input=div+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }

        else if(input.split("\\^").length==2){
            String number[] = input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input=pow+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }

        else if(input.split("-").length>1){
            String number[] = input.split("-");
            if(number[0]=="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double sub = 0;
                 if(number.length==2){
                    sub= Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                 }
                else if(number.length==3){
                    sub= -Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                 }
                input=sub+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }

        else if(input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input=sum+"";
            }
            catch (Exception e){
                //Toggle error
            }
        }

        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
    result_screen.setText(input);
    }
}