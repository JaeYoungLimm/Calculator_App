package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //연산 기호를 누르기 전 값을 저장하는 배열
    ArrayList arrayList = new ArrayList();

    int cnt = 0;

    //결과창
    EditText editText;

    //리셋버튼
    Button resetbtn;

    // = 버튼
    Button resultbtn;

    //연산자 버튼
    Button modbtn;
    Button addbtn;
    Button subbtn;
    Button mulbtn;
    Button divbtn;

    //소수점 버튼
    Button floatbtn;

    //번호 버튼
    Button num1btn;
    Button num2btn;
    Button num3btn;
    Button num4btn;
    Button num5btn;
    Button num6btn;
    Button num7btn;
    Button num8btn;
    Button num9btn;
    Button num0btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText)findViewById(R.id.editText);


        resetbtn = (Button)findViewById(R.id.resetbtn);
        modbtn = (Button)findViewById(R.id.modbtn);
        addbtn = (Button)findViewById(R.id.addbtn);
        subbtn = (Button)findViewById(R.id.subbtn);
        mulbtn = (Button)findViewById(R.id.mulbtn);
        divbtn = (Button)findViewById(R.id.divbtn);
        resultbtn = (Button)findViewById(R.id.resultbtn);
        floatbtn = (Button)findViewById(R.id.floatbtn);

        num0btn  = (Button)findViewById(R.id.num0btn);
        num1btn  = (Button)findViewById(R.id.num1btn);
        num2btn  = (Button)findViewById(R.id.num2btn);
        num3btn  = (Button)findViewById(R.id.num3btn);
        num4btn  = (Button)findViewById(R.id.num4btn);
        num5btn  = (Button)findViewById(R.id.num5btn);
        num6btn  = (Button)findViewById(R.id.num6btn);
        num7btn  = (Button)findViewById(R.id.num7btn);
        num8btn  = (Button)findViewById(R.id.num8btn);
        num9btn  = (Button)findViewById(R.id.num9btn);

        //연산 , 기타 리스너

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.clear();
                editText.setText("");
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(editText.getText().toString());
                editText.setText("");
                cnt = 1;
            }
        });
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(editText.getText().toString());
                editText.setText("");
                cnt = 2;
            }
        });
        mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(editText.getText().toString());
                editText.setText("");
                cnt = 3;
            }
        });
        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(editText.getText().toString());
                editText.setText("");
                cnt = 4;
            }
        });

        modbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(editText.getText().toString());
                editText.setText("");
                cnt = 5;
            }
        });

        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString()+".");
            }
        });

        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s1 = 0, s2 = 0, s3 = 0,cnt2 = 0;
                double f1 = 0, f2 = 0, f3 = 0;
                String st;

                if(arrayList.isEmpty()){
                    editText.setText("");
                }else{

                    Object obj = arrayList.get(0);
                    String num1 = (String)obj;
                    String num2 = editText.getText().toString();

                    //점이 있다면 소수
                    if(num1.contains(".") || num2.contains(".")){
                        cnt2 = 1;
                        f1 = Float.parseFloat(num1);
                        f2 = Float.parseFloat(num2);
                    }else{
                        s1 = Integer.parseInt(num1);
                        s2 = Integer.parseInt(num2);
                    }


                    switch(cnt){
                        case 0:
                            editText.setText("");
                            break;

                        case 1: // 덧셈

                            //소수일 때
                            if(cnt2 == 1){
                                f3 = f1 + f2;
                                st = String.valueOf(f3);
                            }else{
                                s3 = s1 + s2;
                                st = String.valueOf(s3);
                            }

                            editText.setText(st);
                            arrayList.clear();
                            break;
                        case 2: //뺄셈
                            if(cnt2 == 1){
                                f3 = f1 - f2;
                                st = String.valueOf(f3);
                            }else{
                                s3 = s1 - s2;
                                st = String.valueOf(s3);
                            }

                            editText.setText(st);
                            arrayList.clear();
                            break;
                        case 3: //곱셈
                            if(cnt2 == 1){
                                f3 = f1 * f2;
                                st = String.valueOf(f3);
                            }else{
                                s3 = s1 * s2;
                                st = String.valueOf(s3);
                            }

                            editText.setText(st);
                            arrayList.clear();
                            break;
                        case 4: //나눗셈
                            if(cnt2 == 1){
                                f3 = f1 / f2;

                                st = String.valueOf(f3);

                            }else{
                                s3 = s1 / s2;
                                st = String.valueOf(s3);
                            }

                            editText.setText(st);
                            arrayList.clear();
                            break;
                        case 5: //나머지
                            if(cnt2 == 1){
                                f3 = f1 % f2;
                                st = String.valueOf(f3);
                            }else{
                                s3 = s1 % s2;
                                st = String.valueOf(s3);
                            }

                            editText.setText(st);
                            arrayList.clear();
                            break;
                    }



                }
            }
        });


        //숫자 버튼 리스너

        num0btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "0");
            }
        });

        num1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "1");
            }
        });

        num2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "2");
            }
        });

        num3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "3");
            }
        });

        num4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "4");
            }
        });

        num5btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "5");
            }
        });

        num6btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "6");
            }
        });

        num7btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "7");
            }
        });

        num8btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "8");
            }
        });

        num9btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + "9");
            }
        });




    }
}
