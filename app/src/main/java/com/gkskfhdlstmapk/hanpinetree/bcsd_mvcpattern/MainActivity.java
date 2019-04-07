package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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

                        break;
                    case 2 :

                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linearLayout, fragment);
                fragmentTransaction.commit();
                drawerLayout.openDrawer(Gravity.LEFT);

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
