package com.example.david.rgb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class RGB extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    SeekBar piros,zold,kek;
    TextView vpiros,vzold,vkek,hex,color;
    int r=0,v=0,a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb);
        piros=(SeekBar)findViewById(R.id.piros);
        zold=(SeekBar)findViewById(R.id.zold);
        kek=(SeekBar)findViewById(R.id.kek);
        hex= (TextView) findViewById(R.id.hex);
        color= (TextView) findViewById(R.id.color);
        vpiros= (TextView) findViewById(R.id.vpiros);
        vzold= (TextView) findViewById(R.id.vzold);
        vkek= (TextView) findViewById(R.id.vkek);
        piros.setOnSeekBarChangeListener(this);
        zold.setOnSeekBarChangeListener(this);
        kek.setOnSeekBarChangeListener(this);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        switch(seekBar.getId()) {
            case R.id.piros:
                v=progress;
                break;
            case R.id.zold:
                r=progress;
                break;
            case R.id.kek:
                a=progress;
                break;
        }
        String c=ColorHex(v,r,a);
        hex.setText("HEX: "+c);
        color.setBackgroundColor(android.graphics.Color.rgb(v,r,a));

    }
    public String ColorHex(int r, int v,int a) {
        String color="";
        color="#";
        color+=Integer.toHexString(v);
        color+=Integer.toHexString(r);
        color+=Integer.toHexString(a);
        return color;

    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        vpiros.setText("R: "+v);
        vzold.setText("G: "+r);
        vkek.setText("B: "+a);


    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        vpiros.setText("R: "+v);
        vzold.setText("G: "+r);
        vkek.setText("B: "+a);
    }
}
