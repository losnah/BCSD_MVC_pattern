package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.StringTokenizer;

public class CalcActivity extends Fragment implements View.OnClickListener {
    View mView;
    private StringBuilder mUpdateText;
    private TextView mUpdateTextview;

    private Button[] mButton = new Button[10];
    private Button mButtonResult;
    private Button mButtonCE;

    private Button mButtonPlus;
    private Button mButtonMinus;
    private Button mButtonMulti;
    private Button mButtonDiv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_calc);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.activity_calc, null);

        init();
        return mView;
    }

    public void init(){
        for(int i = 0 ; i < 10; i++){
            String buttonID = "activity_calc_"+i+"_button";
            int resID = getResources().getIdentifier(buttonID, "id","com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern");
            mButton[i] = mView.findViewById(resID);
            mButton[i].setOnClickListener(this);
        }
        mButtonResult = (Button)mView.findViewById(R.id.activity_calc_result_button);
        mButtonCE = (Button)mView.findViewById(R.id.activity_calc_CE_button);

        mButtonPlus = (Button)mView.findViewById(R.id.activity_calc_plus_button);
        mButtonMinus = (Button)mView.findViewById(R.id.activity_calc_minus_button);
        mButtonMulti = (Button)mView.findViewById(R.id.activity_calc_multi_button);
        mButtonDiv = (Button)mView.findViewById(R.id.activity_calc_div_button);

        mUpdateText = new StringBuilder("");
        mUpdateTextview = (TextView)mView.findViewById(R.id.activity_calc_result_textview);
        mUpdateTextview.setText(mUpdateText);
        mButtonResult.setOnClickListener(this);
        mButtonCE.setOnClickListener(this);

        mButtonPlus.setOnClickListener(this);
        mButtonMinus.setOnClickListener(this);
        mButtonMulti.setOnClickListener(this);
        mButtonDiv.setOnClickListener(this);

    }


    public int calculaeResult(StringBuilder str){

        StringTokenizer st = new StringTokenizer(str.toString());
        int result = 0;
        int count = 0;
        int a = 0; int b; char op;
        while(st.hasMoreTokens()) {
            if(count == 0) a = Integer.parseInt(st.nextToken());
            else a = result;

            op = st.nextToken().charAt(0);
            if(op == '=') break;
            b = Integer.parseInt(st.nextToken());
            result = calc(a,op,b);
            count++;
        }
        return result;


    }
    public static int calc(int a, char op, int b) {
        switch(op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case 'x':
                return a*b;
            case '/':
                return a/b;
        }
        return -1;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_calc_0_button:
                mUpdateText.append("0");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_1_button:
                mUpdateText.append("1");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_2_button:
                mUpdateText.append("2");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_3_button:
                mUpdateText.append("3");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_4_button:
                mUpdateText.append("4");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_5_button:
                mUpdateText.append("5");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_6_button:
                mUpdateText.append("6");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_7_button:
                mUpdateText.append("7");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_8_button:
                mUpdateText.append("8");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_9_button:
                mUpdateText.append("9");
                mUpdateTextview.setText(mUpdateText);
                break;
            //activity_calc_plus_button
            case R.id.activity_calc_plus_button:
                mUpdateText.append(" + ");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_minus_button:
                mUpdateText.append(" - ");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_multi_button:
                mUpdateText.append(" x ");
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_div_button:
                mUpdateText.append(" / ");
                mUpdateTextview.setText(mUpdateText);
                break;

            case R.id.activity_calc_CE_button:
                mUpdateText.setLength(0);
                mUpdateTextview.setText(mUpdateText);
                break;
            case R.id.activity_calc_result_button:
                int calResult = calculaeResult(mUpdateText);
                mUpdateText.setLength(0);
                mUpdateText.append(Integer.toString(calResult));
                mUpdateTextview.setText(calResult+"");
                break;

        }
    }
}
