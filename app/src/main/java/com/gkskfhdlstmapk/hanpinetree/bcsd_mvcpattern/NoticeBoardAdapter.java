package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Dictionary;

public class NoticeBoardAdapter extends RecyclerView.Adapter<NoticeBoardAdapter.CustomViewHolder> {
    private ArrayList<NoticeBoardItem> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView titleTextView;
        protected TextView nameTextView;
        protected TextView timeTextView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.titleTextView = (TextView) itemView.findViewById(R.id.item_list_title);
            this.nameTextView = (TextView) itemView.findViewById(R.id.item_list_writer);
            this.timeTextView = (TextView) itemView.findViewById(R.id.item_list_time);

        }
    }

    public NoticeBoardAdapter(ArrayList<NoticeBoardItem> mList) {
        this.mList = mList;
    }


    //뷰에 대한 오버라이드 메소드, recyclerView에 새로운 데이터를 보여주기 위해 ViewHolder를 생성해야할 때 호출됩니다.
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    //// Adapter의 특정 위치(position)에 있는 데이터를 보여줘야 할때 호출됩니다.
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {
        viewholder.titleTextView.setText(mList.get(position).getTitle());
        viewholder.nameTextView.setText(mList.get(position).getName());
        viewholder.timeTextView.setText(mList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
