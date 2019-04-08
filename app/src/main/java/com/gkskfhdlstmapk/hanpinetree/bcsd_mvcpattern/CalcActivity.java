package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private String saveResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_calc);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.activity_calc, null);
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_calc,menu);//파라미터로 받은 메뉴에다가 붙여달라.
    }

    //옵션메뉴가 선택됐을 때 자동으로 호출되는 콜백함수 (메뉴함수 선택 시 )
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //선택된 아이템
        int curId = item.getItemId();
        switch (curId){
            case R.id.menu_save:
                Toast.makeText(getContext(),"계산 내용을 저장합니다.",Toast.LENGTH_SHORT).show();
                saveResult = mUpdateTextview.getText().toString();
                break;
            case R.id.menu_load:
                Toast.makeText(getContext(),"계산 내용을 불러옵니다.",Toast.LENGTH_SHORT).show();
                show();
                mUpdateText.setLength(0);
                mUpdateText.append(saveResult);
                mUpdateTextview.setText(saveResult+"");

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //alertDialog함수
    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("계산결과");
        builder.setMessage(saveResult);

        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "예를 선택했습니다.", Toast.LENGTH_LONG).show();
                    }
                });

        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "아니오를 선택했습니다.", Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }


    //
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
