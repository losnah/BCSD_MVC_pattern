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

        Intent intent = getIntent();
        Toast.makeText(getApplicationContext(),"테스트",Toast.LENGTH_SHORT).show();
        String title;
        String name;
        String time;

        if(intent != null) {
            NoticeBoardActivity myfragment = new NoticeBoardActivity();
            Bundle bundle = new Bundle();
            title = intent.getStringExtra("title");
            name =  intent.getStringExtra("name");
            time =  intent.getStringExtra("time");

            bundle.putString("title", title);
            bundle.putString("name", name);
            bundle.putString("time", time);

            myfragment.setArguments(bundle);

        }
        fragment = new NoticeBoardActivity();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.linearLayout, fragment);
        fragmentTransaction.commit();


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

}
