package net.skhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView2Adapter extends RecyclerView.Adapter<RecyclerView2Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view); textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            checkBox = view.findViewById(R.id.checkBox);
            textView1.setOnClickListener(this);
            checkBox.setOnCheckedChangeListener(this);
        }
        public void setData() {
            Memo memo = arrayList.get(getAdapterPosition());
            textView1.setText(memo.getTitle());
            textView2.setText(memo.getDateFormatted());
            checkBox.setChecked(memo.isChecked());
        }
        @Override
        public void onClick(View view) {
            Memo memo = arrayList.get(super.getAdapterPosition());
            String s = String.format("index: %d, title: %s", super.getAdapterPosition(), memo.getTitle());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Memo memo = arrayList.get(super.getAdapterPosition());
            memo.setChecked(isChecked);
        }
    }
    LayoutInflater layoutInflater; ArrayList<Memo> arrayList;
    public RecyclerView2Adapter(Context context, ArrayList<Memo> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.memo2, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }
}