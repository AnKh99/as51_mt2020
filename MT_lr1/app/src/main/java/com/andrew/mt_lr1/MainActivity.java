package com.andrew.mt_lr1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Button resetBtn;

    int[] scheme = {
            1,2,5,4,
            2,3,3,6,
            7,5,8,1,
            7,4,6,8};
    int[] resources = {
            R.drawable.ic_1,
            R.drawable.ic_2,
            R.drawable.ic_3,
            R.drawable.ic_4,
            R.drawable.ic_5,
            R.drawable.ic_6,
            R.drawable.ic_7,
            R.drawable.ic_8,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.grid_view);
        resetBtn = findViewById(R.id.reset_btn);

        final GridAdapter gridAdapter = new GridAdapter(this.getBaseContext(), getScheme(), resources);
        gridView.setAdapter(gridAdapter);

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gridAdapter = new GridAdapter(view.getContext(), scheme, resources);
                gridView.setAdapter(new GridAdapter(view.getContext(), getScheme(), resources));
            }
        });
    }

    public int[] getScheme() {
        Random random = new Random(SystemClock.elapsedRealtime());
        for(int i = 0; i<scheme.length; i++){
            swap(scheme, i, random.nextInt(scheme.length));
        }
        return scheme;
    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}