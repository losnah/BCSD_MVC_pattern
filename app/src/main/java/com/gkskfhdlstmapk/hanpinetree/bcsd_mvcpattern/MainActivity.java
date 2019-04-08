package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mDrawerListView;
    private Fragment fragment = null;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :
                        fragment = new NoticeBoardActivity();
                        break;
                    case 1 :
                        fragment = new CalcActivity();
                        break;
                    case 2 :
                        fragment = new WebViewActivity();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linearLayout, fragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(Gravity.LEFT);

            }
        });

    }

    public void init(){
        drawerLayout = (DrawerLayout)findViewById(R.id.activity_main_drawer);
        final String[] items =  {"notice board", "Calculator","WebView"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,items); //텍스트 하나만 넣음
        mDrawerListView = (ListView)findViewById(R.id.activitiy_main_drawer_listview);
        mDrawerListView.setAdapter(adapter);

        drawerLayout.closeDrawer(Gravity.LEFT);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main,menu);//파라미터로 받은 메뉴에다가 붙여달라.
//        return true;
//    }
//
//    //옵션메뉴가 선택됐을 때 자동으로 호출되는 콜백함수 (메뉴함수 선택 시 )
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        //선택된 아이템
//        int curId = item.getItemId();
//        switch (curId){
//            case R.id.menu_enroll:
//                Intent intent = new Intent(getApplicationContext(),NoticeEnrollActivity.class);
//                Toast.makeText(this,"글을 작성합니다.",Toast.LENGTH_SHORT).show();
//                startActivity(intent);
//                break;
//            case R.id.menu_search:
//                Toast.makeText(this,"검색 메뉴 클릭됨",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menu_settings:
//                Toast.makeText(this,"옵션 메뉴 클릭됨",Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
