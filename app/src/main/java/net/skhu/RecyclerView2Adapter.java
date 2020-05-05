package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView2Adapter extends RecyclerView.Adapter<RecyclerView2Adapter.ViewHolder> {
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
        } public void setData() {
            memo memo = arrayList.get(getAdapterPosition());
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
        }
    } LayoutInflater layoutInflater;
    ArrayList<memo> arrayList;
    public RecyclerView2Adapter(Context context, ArrayList<memo> arrayList) {
        this.layoutInflater = LayoutInflater.from(context); this.arrayList = arrayList;
    } @Override
    public int getItemCount() {
        return arrayList.size();
    } @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.memo, viewGroup, false);
        return new ViewHolder(view);
    } @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }
}