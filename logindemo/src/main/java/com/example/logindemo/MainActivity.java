package com.example.logindemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText phoneEt, CodeEt, passwordEt;
    private String old="";
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneEt = (EditText) findViewById(R.id.phone_et);
        CodeEt = (EditText) findViewById(R.id.code_et);
        passwordEt = (EditText) findViewById(R.id.pass_et);
        passwordEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        login=(Button)findViewById(R.id.login);
        //限制输入框输入长度；
        CodeEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        //edittext输入内容监听
        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("ontextchange==="+s.toString()+"start="+start+" ,before="+before+",count="+count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                //输出输入框的输入内容，实时更新
                System.out.println("afterTextChanged==="+s.toString());
                if(!old.equals(s.toString())&&s.toString().length()>4){
                    passwordEt.setText(s.toString().substring(0,4));
                    //光标移动到最后
                    passwordEt.setSelection(4);

                }
                if(s.toString().length()==4){
                    login.setTextColor(Color.RED);
                    login.setClickable(true);
                    CodeEt.setFocusable(true);
                }else{
                    login.setTextColor(Color.GRAY);
                    login.setClickable(false);
                }
            }
        });
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private boolean isPhone() {
        String phone = phoneEt.getText().toString().trim();
        return Util.isPhone(phone);
    }
}
