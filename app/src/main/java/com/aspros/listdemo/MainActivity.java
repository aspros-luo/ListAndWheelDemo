package com.aspros.listdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aigestudio.wheelpicker.core.AbstractWheelDecor;
import com.aigestudio.wheelpicker.core.AbstractWheelPicker;
import com.aigestudio.wheelpicker.view.WheelCrossPicker;


public class MainActivity extends Activity {

    private Button btnObtainStraight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go_listView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewExample.class);
                startActivity(intent);
            }
        });

        btnObtainStraight = (Button) findViewById(R.id.main_obtain_straight_btn);

        WheelCrossPicker mWheelCrossPicker = (WheelCrossPicker) findViewById(R.id.wheelPicker);
        mWheelCrossPicker.setItemCount(5);

        mWheelCrossPicker.setItemIndex(1);
        mWheelCrossPicker.setBackgroundColor(0xFFE5DEEB);
        mWheelCrossPicker.setTextColor(0xFFA7A7DB);
        mWheelCrossPicker.setCurrentTextColor(0xFF536D8A);
        mWheelCrossPicker.setWheelDecor(true, new AbstractWheelDecor() {
            @Override
            public void drawDecor(Canvas canvas, Rect rectLast, Rect rectNext, Paint paint) {
                paint.setColor(Color.BLUE);
                canvas.drawRect(rectLast, paint);

                paint.setColor(Color.RED);
                canvas.drawRect(rectNext, paint);
            }
        });
        mWheelCrossPicker.setOnWheelChangeListener(new AbstractWheelPicker.SimpleWheelChangeListener() {
            @Override
            public void onWheelSelected(int index, String data) {
                Toast.makeText(MainActivity.this, "index:" + index + "\n" + "data:" + data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
