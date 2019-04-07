package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Dictionary;

public class NoticeBoardActivity extends Fragment {
    private View mView;
    private ArrayList<NoticeBoardItem> mNoticeArray;
    private NoticeBoardAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.activity_notice_board, null);
        init(mView);

        return mView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notice_board);


    }

    public void init(View view) {
        mRecyclerView = (RecyclerView)view.findViewById(R.id.activity_notice_board_recyclerview);
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


        //데이터추가 기능 구현하는 부분! 따로 activity 연결해줄 예정입니다.
//        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
//        buttonInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                count++;
//
//                // Dictionary 생성자를 사용하여 ArrayList에 삽입할 데이터를 만듭니다.
//                Dictionary dict = new Dictionary(count+"",
//                        "apple" + count, "사과" + count);
//
//                //mArrayList.add(0, dict); //RecyclerView의 첫 줄에 삽입
//                mArrayList.add(dict); // RecyclerView의 마지막 줄에 삽입
//
//                mAdapter.notifyDataSetChanged(); //변경된 데이터를 화면에 반영
//            }
//        });

    }
}
