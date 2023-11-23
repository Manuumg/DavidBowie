package com.example.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DavidBowieAdapter extends ArrayAdapter<DavidBowie> {
    public DavidBowieAdapter(@NonNull Context context, ArrayList<DavidBowie> dbList) {
        super(context, 0, dbList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return getView1(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull
    ViewGroup parent) {
        return getView1(position, convertView, parent);
    }

    @NonNull
    private View getView1(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row, parent, false);

        }

        //Hooks
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView2 = convertView.findViewById(R.id.textView2);

        //sets
        DavidBowie currentItem = getItem(position);
        if(convertView !=null) {
            imageView.setImageResource(currentItem.getImgCover());
            textView2.setText(currentItem.getCoverName());
        }
        return convertView;
    }


}
