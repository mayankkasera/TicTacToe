package com.seetop10.tic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.seetop10.tic.R.id.i1;


public class Tic extends AppCompatActivity {

    int flag = 0,com=0;
    int active[] = {2,2,2,2,2,2,2,2,2};
    int win[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int tag;
    boolean over= false;

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic);


        t = (TextView)findViewById(R.id.Text);
        t.setText("");
    }

    public void fun(View v)
    {
        tag = Integer.parseInt(v.getTag().toString());

        if((active[(tag-1)]==2)&&(over ==false))
        {
            active[tag-1] = flag;


            ImageView i = (ImageView) v;
            if (flag == 0) {
                i.setImageResource(R.drawable.r6);
                flag = 1;



            } else {
                i.setImageResource(R.drawable.i6);
                flag = 0;


            }

        }
        check();
        tai();
    }
    void tai()
    {
        if(com==0) {
            if (active[0] != 2 && active[1] != 2 && active[2] != 2 && active[3] != 2 && active[4] != 2 && active[5] != 2 && active[6] != 2 && active[7] != 2 && active[8] != 2) {


                t.setText("game is tai!!!!" );
            }
        }
    }

    void check()
    {

        for(int x[] : win){
            if((active[x[0]]==active[x[1]])&&(active[x[1]]==active[x[2]])&&active[x[0]]!=2)
            {
                over =true;

                if(active[x[0]]==0)
                {   com=1;

                    t.setText("O is win !!!!\n" );
                }
                else
                {

                    t.setText("X is win !!!!\n");
                }
            }

        }
    }

    public void playagain(View v)
    {
        t.setText("");
        flag = 0;
        com=0;
        for(int x = 0 ; x < 9 ; x++ )
            active[x] = 2;
        over= false;
        ImageView i[]=  new ImageView[9];
        i[1] = (ImageView) findViewById(i1);
        i[1].setImageResource(R.drawable.r7);
        i[2] = (ImageView) findViewById(R.id.i2);
        i[2].setImageResource(R.drawable.r7);
        i[3] = (ImageView) findViewById(R.id.i3);
        i[3].setImageResource(R.drawable.r7);
        i[4] = (ImageView) findViewById(R.id.i4);
        i[4].setImageResource(R.drawable.r7);
        i[5] = (ImageView) findViewById(R.id.i5);
        i[5].setImageResource(R.drawable.r7);
        i[6] = (ImageView) findViewById(R.id.i6);
        i[6].setImageResource(R.drawable.r7);
        i[7] = (ImageView) findViewById(R.id.i7);
        i[7].setImageResource(R.drawable.r7);
        i[8] = (ImageView) findViewById(R.id.i8);
        i[8].setImageResource(R.drawable.r7);
        i[0] = (ImageView) findViewById(R.id.i9);
        i[0].setImageResource(R.drawable.r7);


    }
}