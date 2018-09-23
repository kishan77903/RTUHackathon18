package com.example.aayushgarg.skit_college;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aayushgarg on 9/17/18.
 */

public class Addapter_class extends RecyclerView.Adapter<Addapter_class.ViewHolder> {

    private List<key_table> item;
    private Context context;
    public static  ArrayList<String> inpur1;

    public Addapter_class(List<key_table> item, Context context, ArrayList<String> inpur1) {
        this.item = item;
        this.context = context;
        this.inpur1 = inpur1;
    }

    @Override
    public Addapter_class.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.featores_list,   parent,false);
        final Addapter_class.ViewHolder viewHolder=new Addapter_class.ViewHolder(v);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(Addapter_class.ViewHolder holder, int position) {

        key_table listItem =item.get(position);
        String aa=listItem.getName().substring(2,listItem.getName().length());
        holder.t1.setText(listItem.getName());
        inpur1.add("");





    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView t1;
public  AutoCompleteTextView t2;

        public ViewHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.name_of_fetur);
            t2=(AutoCompleteTextView)itemView.findViewById(R.id.fetu_input);


            t2.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                    inpur1.add("");
                  String aa=inpur1.get(getAdapterPosition());
                    int temp=getAdapterPosition();
                    inpur1.set(getAdapterPosition(), s.toString());
                }
                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
 }
    }


    public  ArrayList<String> getSetupList(){

        return inpur1;

    }


}
