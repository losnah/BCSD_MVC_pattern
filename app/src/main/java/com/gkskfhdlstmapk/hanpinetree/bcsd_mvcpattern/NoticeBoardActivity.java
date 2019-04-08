package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;

public class NoticeBoardActivity extends Fragment {
    private View mView;
    private ArrayList<NoticeBoardItem> mNoticeArray;
    private NoticeBoardAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private Button mPlusButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.activity_notice_board, null);
        init(mView);
        setHasOptionsMenu(true);


        return mView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notice_board);
    }

    public void init(View view) {
        mRecyclerView = (RecyclerView)view.findViewById(R.id.activity_notice_board_recyclerview);
        mPlusButton = (Button)view.findViewById(R.id.activity_notice_board_plus_button);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

         // NoticeBoardActivity에서 RecyclerView의 데이터에 접근시 사용됩니다.
        mNoticeArray = new ArrayList<NoticeBoardItem>();

        // RecyclerView를 위해 CustomAdapter를 사용합니다.
        mAdapter = new NoticeBoardAdapter(mNoticeArray);
        mRecyclerView.setAdapter(mAdapter);

        // RecyclerView의 줄(row) 사이에 수평선을 넣기위해 사용됩니다.
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        NoticeBoardItem basic = new NoticeBoardItem("컴퓨터개론","김이름","10시 10분");
        mNoticeArray.add(basic);
        mAdapter.notifyDataSetChanged();

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
       inflater.inflate(R.menu.menu_main,menu);//파라미터로 받은 메뉴에다가 붙여달라.
    }

    //옵션메뉴가 선택됐을 때 자동으로 호출되는 콜백함수 (메뉴함수 선택 시 )
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //선택된 아이템
        int curId = item.getItemId();
        switch (curId){
            case R.id.menu_enroll:
                //Intent intent = new Intent(getApplicationContext(),NoticeEnrollActivity.class);
                Toast.makeText(getContext(),"글을 작성합니다.",Toast.LENGTH_SHORT).show();
                //startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
