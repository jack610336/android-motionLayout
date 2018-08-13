package com.jack.motionlayout;

import android.os.Handler;
import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    MotionLayout ml;
    boolean anmotion = true;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        ml = findViewById(R.id.motion_container);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (anmotion) {
                            handler.post(runnable);
                            handler.post(runnable2);
                            anmotion = false;
                        } else {
                            handler.removeCallbacks(runnable);
                            handler.removeCallbacks(runnable2);
                            anmotion = true;
                        }
                    }
                });
            }
        });
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            ml.transitionToEnd();
            handler.postDelayed(this, 505);
        }
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            ml.transitionToStart();
            handler.postDelayed(this, 505);
        }
    };

}
