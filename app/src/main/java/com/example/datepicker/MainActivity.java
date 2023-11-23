package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText textDate;
    private Spinner spinnerString;

    private ArrayList<DavidBowie> mDavidBowie;

    private Spinner spinnerClass;
    private DavidBowieAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        textDate = findViewById(R.id.textDate);
        spinnerString = findViewById(R.id.sprinerString);
        spinnerClass =  findViewById(R.id.spinnerClass);


        spinnerString.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selecetedItem = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this,"selectedItem" + selecetedItem,
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_checked,
                getResources().getStringArray(R.array.cursos) );


        spinnerString.setAdapter(myAdapter);

        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light    ,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                textDate.setText(i2 + "/" + i1 + "/" + i);
                            }
                        },
                        year, month, day
                );
                picker.show();
            }
        });

        initList();
        mAdapter = new  DavidBowieAdapter( this, mDavidBowie);

        spinnerClass.setAdapter(mAdapter);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                DavidBowie selectedItem = (DavidBowie) adapterView.getItemAtPosition(i);
                String selectedDavidBowieName = selectedItem.getCoverName();
                Toast.makeText(MainActivity.this, selectedDavidBowieName,
                        Toast.LENGTH_SHORT).show();
            }
            @Override

            public void onNothingSelected(AdapterView<?> adapterView){
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();

            }
        });
    }

 

    private void initList(){
        mDavidBowie = new ArrayList<>();
        mDavidBowie.add(new DavidBowie("Stardust", R.drawable.db8));
        mDavidBowie.add(new DavidBowie("Stardust", R.drawable.db8));
        mDavidBowie.add(new DavidBowie("Aladdin Sane", R.drawable.db6));
        mDavidBowie.add(new DavidBowie("Low", R.drawable.db7));
        mDavidBowie.add(new DavidBowie("David Bowie", R.drawable.db3));
        mDavidBowie.add(new DavidBowie("Modern Rocks", R.drawable.db9));
        mDavidBowie.add(new DavidBowie("Young Americans", R.drawable.db10));
        mDavidBowie.add(new DavidBowie("Bowie Legacy", R.drawable.db11));
    }
}