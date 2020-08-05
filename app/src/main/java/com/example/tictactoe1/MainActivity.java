package com.example.tictactoe1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Button[] buttons = new Button[13];
    static boolean ans=false;
    static int i=0;
    static boolean choice=false;
    protected static int[] first_move = {5,3,5,7,9,3,5,9,5};
    protected static int pos1=0,pos2=0,count=0;
    protected static int[][] second_move ={{1,2,3},{1,3,2},{1,4,7},{1,7,4},{1,8,7},{1,9,4}
            ,{1,6,7}//6//,{1,6,3} will block

            ,{2,1,5},{2,4,5},{2,5,8},{2,7,1},{2,8,5},{2,9,8}
            ,{2,6,7}//13//,{2,6,5} will block

            ,{3,1,2},{3,2,1},{3,6,9},{3,7,4},{3,8,9},{3,9,6}
            ,{3,4,9}//20//,{3,4,1} will block

            ,{4,1,5},{4,3,6},{4,5,6},{4,6,5},{4,8,5},{4,9,5}
            ,{4,2,3}//27//,{4,2,5} will block

            ,{5,2,8},{5,3,7},{5,4,6},{5,6,4},{5,7,3},{5,8,2}
            ,{5,1,8}//34//,{5,1,3} will block

            ,{6,1,5},{6,2,5},{6,4,5},{6,5,4},{6,7,5},{6,9,5}
            ,{6,8,7}//41//,{6,8,5} will block

            ,{7,1,4},{7,3,2},{7,4,1},{7,6,9},{7,8,9},{7,9,8}
            ,{7,2,9}//48//,{7,2,1} will block

            ,{8,1,5},{8,2,5},{8,3,5},{8,5,2},{8,6,5},{8,7,5}
            ,{8,4,1}//55//,{8,4,5} will block

            ,{9,1,2},{9,3,6},{9,4,7},{9,6,3},{9,7,8},{9,8,7}
            ,{9,2,7}};//62//,{9,2,3}}; will block

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initialise();
            play();
        }

        protected void initialise()
        {
            buttons[0] = (Button)findViewById(R.id.btn_1);
            buttons[1] = (Button)findViewById(R.id.btn_2);
            buttons[2] = (Button)findViewById(R.id.btn_3);
            buttons[4] = (Button)findViewById(R.id.btn_5);
            buttons[3] = (Button)findViewById(R.id.btn_4);
            buttons[5] = (Button)findViewById(R.id.btn_6);
            buttons[6] = (Button)findViewById(R.id.btn_7);
            buttons[7] = (Button)findViewById(R.id.btn_8);
            buttons[8] = (Button)findViewById(R.id.btn_9);
            buttons[9] = (Button)findViewById(R.id.btn_reset);
            buttons[10] = (Button)findViewById(R.id.btn_hard);
            buttons[11] = (Button)findViewById(R.id.btn_human);
            buttons[12] = (Button)findViewById(R.id.btn_ai);

            buttons[11].setBackgroundColor(Color.RED);
            buttons[12].setBackgroundColor(Color.GREEN);

        }
        protected void choose(Button sourceButton)
        {
            if(choice==false)
            {
                ProcessEvent_ai(sourceButton);
            }
            else
            {
                ProcessEvent_human(sourceButton);
            }
            if(match())
                message(11);
        }
        protected void play()
        {
            buttons[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    choose(buttons[0]);
                }
            });

            buttons[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[1]);
                }
            });

            buttons[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[2]);
                }
            });

            buttons[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[3]);
                }
            });

            buttons[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[4]);
                }
            });

            buttons[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[5]);
                }
            });

            buttons[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[6]);
                }
            });

            buttons[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[7]);
                }
            });

            buttons[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choose(buttons[8]);
                }
            });

            buttons[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for(int i=0;i<9;i++)
                    {
                        buttons[i].setBackgroundColor(Color.GRAY);
                        buttons[i].setEnabled(true);
                        buttons[i].setText("");
                    }
                    TextView result = (TextView) findViewById(R.id.textViewResult);
                    result.setText("Welcome");
                    result.setTextColor(Color.BLACK);
                    ans=false;
                    i=0;
                }
            });

            buttons[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(buttons[10].getText().toString()=="Hard : On")
                    {
                        buttons[10].setText("Hard : Off");
                        buttons[10].setBackgroundColor(Color.GREEN);
                        for(int i=0;i<63;i++)
                        {
                            if (i==6)
                            {
                                second_move[i][0]=1;
                                second_move[i][1]=6;
                                second_move[i][2]=7;
                            }
                            else if(i==13)
                            {
                                second_move[i][0]=2;
                                second_move[i][1]=6;
                                second_move[i][2]=7;
                            }
                            else if(i==20)
                            {
                                second_move[i][0]=3;
                                second_move[i][1]=4;
                                second_move[i][2]=9;
                            }
                            else if(i==27)
                            {
                                second_move[i][0]=4;
                                second_move[i][1]=2;
                                second_move[i][2]=3;
                            }
                            else if(i==34)
                            {
                                second_move[i][0]=5;
                                second_move[i][1]=1;
                                second_move[i][2]=8;
                            }
                            else if(i==41)
                            {
                                second_move[i][0]=6;
                                second_move[i][1]=8;
                                second_move[i][2]=7;
                            }
                            else if(i==48)
                            {
                                second_move[i][0]=7;
                                second_move[i][1]=2;
                                second_move[i][2]=9;
                            }
                            else if(i==55)
                            {
                                second_move[i][0]=8;
                                second_move[i][1]=4;
                                second_move[i][2]=1;
                            }
                            else if(i==62)
                            {
                                second_move[i][0]=9;
                                second_move[i][1]=2;
                                second_move[i][2]=7;
                            }
                        }
                    }
                    else
                    {
                        buttons[10].setText("Hard : On");
                        buttons[10].setBackgroundColor(Color.RED);
                        for(int i=0;i<63;i++)
                        {
                            if (i==6)
                            {
                                second_move[i][0]=1;
                                second_move[i][1]=6;
                                second_move[i][2]=3;
                            }
                            else if(i==13)
                            {
                                second_move[i][0]=2;
                                second_move[i][1]=6;
                                second_move[i][2]=5;
                            }
                            else if(i==20)
                            {
                                second_move[i][0]=3;
                                second_move[i][1]=4;
                                second_move[i][2]=1;
                            }
                            else if(i==27)
                            {
                                second_move[i][0]=4;
                                second_move[i][1]=2;
                                second_move[i][2]=5;
                            }
                            else if(i==34)
                            {
                                second_move[i][0]=5;
                                second_move[i][1]=1;
                                second_move[i][2]=3;
                            }
                            else if(i==41)
                            {
                                second_move[i][0]=6;
                                second_move[i][1]=8;
                                second_move[i][2]=5;
                            }
                            else if(i==48)
                            {
                                second_move[i][0]=7;
                                second_move[i][1]=2;
                                second_move[i][2]=1;
                            }
                            else if(i==55)
                            {
                                second_move[i][0]=8;
                                second_move[i][1]=4;
                                second_move[i][2]=5;
                            }
                            else if(i==62)
                            {
                                second_move[i][0]=9;
                                second_move[i][1]=2;
                                second_move[i][2]=3;
                            }
                        }
                    }
                }
            });

            buttons[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttons[11].setBackgroundColor(Color.GREEN);
                    buttons[12].setBackgroundColor(Color.RED);
                    choice=true;
                    buttons[10].setVisibility(View.INVISIBLE);
                    TextView t1=(TextView) findViewById(R.id.textView1);
                    t1.setText("Human:1");
                    TextView t2=(TextView) findViewById(R.id.textView2);
                    t2.setText("     Human:2");
                }
            });

            buttons[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttons[12].setBackgroundColor(Color.GREEN);
                    buttons[11].setBackgroundColor(Color.RED);
                    choice=false;
                    buttons[10].setVisibility(View.VISIBLE);
                    TextView t1=(TextView) findViewById(R.id.textView1);
                    t1.setText("Human");
                    TextView t2=(TextView) findViewById(R.id.textView2);
                    t2.setText("AI");
                }
            });
        }

    private void ProcessEvent_ai(Button sourceButton) {

        String btnText = sourceButton.getText().toString();
        if(ans!=true)
        {
            if (btnText == "")
            {
                sourceButton.setBackgroundColor(Color.GREEN);
                sourceButton.setText("o");
                i++;
            }
                sourceButton.setEnabled(false);
                reaction();
        }
    }

    private void ProcessEvent_human(Button sourceButton)
    {

        String btnText = sourceButton.getText().toString();
        if(ans!=true) {
            if (i % 2 == 0) {
                complete();
                if (btnText == "") {
                    sourceButton.setBackgroundColor(Color.GREEN);

                    sourceButton.setText("o");
                    i++;
                    complete();
                }
                sourceButton.setEnabled(false);
            } else {
                complete();
                if (btnText == "") {
                    sourceButton.setBackgroundColor(Color.RED);

                    sourceButton.setText("x");
                    i++;
                    complete();
                }
                sourceButton.setEnabled(false);
            }
            complete();
        }
    }

    protected void reaction()
    {

        if(i==1)
        {

            first_move_dicision();
        }
        else if(i==2)
        {

            second_move_decision();
        }
        else if(i==3)
        {
            if(complete()==false)
            {
                if(finishing_move()==false)
                    if(block_user_test()==false)
                    {
                        for(int j=0;;j++)
                        {
                            if(random_num_generator())
                            {
                                break;
                            }
                        }
                    }
            }
            complete();
        }

        else if(i==4)
        {
            if(complete()==false)
            {
                if(finishing_move()==false)
                    if(block_user_test()==false)
                    {
                        for(int j=0;;j++)
                        {
                            if(random_num_generator())
                            {
                                break;
                            }
                        }
                    }
            }
            complete();

        }
        else
        {
            if(match())
                message(11);
            else
            {
                for(int j=0;;j++)
                {
                    if(random_num_generator())
                    {
                        break;
                    }
                }
            }
        }
    }


    protected boolean complete() //check if all 3 boxes are filled in any line
    {
        if((buttons[0].getText().toString()=="x" && buttons[1].getText().toString()=="x" && buttons[2].getText().toString()=="x"))
        {
            buttons[0].setText("-x-");
            buttons[1].setText("-x-");
            buttons[2].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[0].getText().toString()=="o" && buttons[1].getText().toString()=="o" && buttons[2].getText().toString()=="o"))
        {
            buttons[0].setText("-o-");
            buttons[1].setText("-o-");
            buttons[2].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[3].getText().toString()=="x" && buttons[4].getText().toString()=="x" && buttons[5].getText().toString()=="x"))
        {
            buttons[3].setText("-x-");
            buttons[4].setText("-x-");
            buttons[5].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[3].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[5].getText().toString()=="o"))
        {
            buttons[3].setText("-o-");
            buttons[4].setText("-o-");
            buttons[5].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[6].getText().toString()=="x" && buttons[7].getText().toString()=="x" && buttons[8].getText().toString()=="x"))
        {
            buttons[6].setText("-x-");
            buttons[7].setText("-x-");
            buttons[8].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[6].getText().toString()=="o" && buttons[7].getText().toString()=="o" && buttons[8].getText().toString()=="o"))
        {
            buttons[6].setText("-o-");
            buttons[7].setText("-o-");
            buttons[8].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[0].getText().toString()=="x" && buttons[3].getText().toString()=="x" && buttons[6].getText().toString()=="x"))
        {
            buttons[0].setText("-x-");
            buttons[3].setText("-x-");
            buttons[6].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[0].getText().toString()=="o" && buttons[3].getText().toString()=="o" && buttons[6].getText().toString()=="o"))
        {
            buttons[0].setText("-o-");
            buttons[3].setText("-o-");
            buttons[6].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[0].getText().toString()=="x" && buttons[4].getText().toString()=="x" && buttons[8].getText().toString()=="x"))
        {
            buttons[0].setText("-x-");
            buttons[4].setText("-x-");
            buttons[8].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[0].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[8].getText().toString()=="o"))
        {
            buttons[0].setText("-o-");
            buttons[4].setText("-o-");
            buttons[8].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[1].getText().toString()=="x" && buttons[4].getText().toString()=="x" && buttons[7].getText().toString()=="x"))
        {
            buttons[1].setText("-x-");
            buttons[4].setText("-x-");
            buttons[7].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[1].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[7].getText().toString()=="o"))
        {
            buttons[1].setText("-o-");
            buttons[4].setText("-o-");
            buttons[7].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[2].getText().toString()=="x" && buttons[5].getText().toString()=="x" && buttons[8].getText().toString()=="x"))
        {
            buttons[2].setText("-x-");
            buttons[5].setText("-x-");
            buttons[8].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[2].getText().toString()=="o" && buttons[5].getText().toString()=="o" && buttons[8].getText().toString()=="o"))
        {
            buttons[2].setText("-o-");
            buttons[5].setText("-o-");
            buttons[8].setText("-o-");
            message(1);
            return true;
        }
        else if((buttons[2].getText().toString()=="x" && buttons[4].getText().toString()=="x" && buttons[6].getText().toString()=="x"))
        {
            buttons[2].setText("-x-");
            buttons[4].setText("-x-");
            buttons[6].setText("-x-");
            message(0);
            return true;
        }
        else if((buttons[2].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[6].getText().toString()=="o"))
        {
            buttons[2].setText("-o-");
            buttons[4].setText("-o-");
            buttons[6].setText("-o-");
            message(1);
            return true;

        }
        else
        {
            return false;
        }
    }

    protected static boolean check_empty(int n)//check if any box is still empty
    {
        switch(n)
        {
            case 0 :
            case 1 :if (buttons[0].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }

            case 2 :if (buttons[1].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }

            case 3 :if (buttons[2].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }
            case 4 :if (buttons[3].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }

            case 5 :if (buttons[4].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }
            case 6 :if (buttons[5].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }

            case 7 :if (buttons[6].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }
            case 8 :if (buttons[7].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }
            case 9 :if (buttons[8].getText().toString()=="")
            {
                return true;
            }
            else
            {
                return false;
            }
            default : return false;
        }
    }

    public static boolean random_num_generator()
    {
        Random generate_random=new Random();
        int random_num=generate_random.nextInt(9) + 1;
        if(check_empty(random_num)==true)
        {
            block_user(random_num);
            return true;
        }
        else
        {
            return false;
        }
    }

    protected void message(int n)
    {
        TextView result = (TextView) findViewById(R.id.textViewResult);
        if(choice==false) {
            if (n == 1) {
                result.setText("Human wins!!");
                result.setTextColor(Color.GREEN);
                ans = true;
            } else if (n == 0) {
                result.setText("AI wins!!");
                result.setTextColor(Color.RED);
                ans = true;
            } else if (n == 11) {
                result.setText("Match Draw");
                result.setTextColor(Color.BLACK);
                ans = true;
            }
        }
        else
        {
            if (n == 1) {
                result.setText("Human:1 wins!!");
                result.setTextColor(Color.GREEN);
                ans = true;
            } else if (n == 0) {
                result.setText("Human:2 wins!!");
                result.setTextColor(Color.RED);
                ans = true;
            } else if (n == 11) {
                result.setText("Match Draw");
                result.setTextColor(Color.BLACK);
                ans = true;
            }
        }
    }

    protected boolean match()
    {
        int flag=0;
        for(int i=1;i<=9;i++)
        {
            if(check_empty(i)==true)
            {
                flag++;
            }
        }
        if(flag==0)
        {
            return true;

        }
        else
        {
            return false;
        }
    }

    protected static void first_move_dicision()
    {
        first_move[0]=5;
        first_move[1]=3;
        first_move[2]=5;
        first_move[3]=7;
        first_move[4]=9;
        first_move[5]=3;
        first_move[6]=5;
        first_move[7]=9;
        first_move[8]=5;

        int flag=0;
        for(int i=0;i<9;i++)
        {
            pos1=0;
            if(buttons[i].getText().toString()=="o")
            {
                flag=i;

                pos1=i;
                break;
            }
        }
        buttons[first_move[flag]-1].setText("x");
        buttons[first_move[flag]-1].setBackgroundColor(Color.RED);
    }

    protected static void second_move_decision()
    {

        position();
        location();
    }

    protected static void position()
    {
        pos2=0;
        for(int i=0;i<9;i++)
        {
            if(buttons[i].getText().toString()=="o")
            {
                if(pos1!=i)
                {
                    pos2=i;
                    break;
                }
            }
        }
    }

    protected static void location()
    {
        for(int i=0;i<63;i++)
        {
            if(second_move[i][0]==(pos1+1) && second_move[i][1]==(pos2+1))
            {
                buttons[second_move[i][2]-1].setText("x");
                buttons[second_move[i][2]-1].setBackgroundColor(Color.RED);
            }
        }
    }

    protected static boolean block_user_test()
    {
        if(finishing_move()!=true)
        {
            if(buttons[0].getText().toString()=="o" && buttons[1].getText().toString()=="o" && buttons[2].getText().toString()=="")
            {
                block_user(3);
                return true;
            }
            else if(buttons[1].getText().toString()=="o" && buttons[2].getText().toString()=="o" && buttons[0].getText().toString()=="")
            {
                block_user(1);
                return true;
            }
            else if(buttons[0].getText().toString()=="o" && buttons[2].getText().toString()=="o" && buttons[1].getText().toString()=="")
            {
                block_user(2);
                return true;
            }
            else if(buttons[3].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[5].getText().toString()=="")
            {
                block_user(6);
                return true;
            }
            else if(buttons[3].getText().toString()=="o" && buttons[5].getText().toString()=="o" && buttons[4].getText().toString()=="")
            {
                block_user(5);
                return true;
            }
            else if(buttons[4].getText().toString()=="o" && buttons[5].getText().toString()=="o" && buttons[3].getText().toString()=="")
            {
                block_user(4);
                return true;
            }
            else if(buttons[6].getText().toString()=="o" && buttons[7].getText().toString()=="o" && buttons[8].getText().toString()=="")
            {
                block_user(9);
                return true;
            }
            else if(buttons[6].getText().toString()=="o" && buttons[8].getText().toString()=="o" && buttons[7].getText().toString()=="")
            {
                block_user(8);
                return true;
            }
            else if(buttons[7].getText().toString()=="o" && buttons[8].getText().toString()=="o" && buttons[6].getText().toString()=="")
            {
                block_user(7);
                return true;
            }

            else if(buttons[0].getText().toString()=="o" && buttons[3].getText().toString()=="o" && buttons[6].getText().toString()=="")
            {
                block_user(7);
                return true;
            }
            else if(buttons[0].getText().toString()=="o" && buttons[6].getText().toString()=="o" && buttons[3].getText().toString()=="")
            {
                block_user(4);
                return true;
            }
            else if(buttons[3].getText().toString()=="o" && buttons[6].getText().toString()=="o" && buttons[0].getText().toString()=="")
            {
                block_user(1);
                return true;
            }
            else if(buttons[1].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[7].getText().toString()=="")
            {
                block_user(8);
                return true;
            }
            else if(buttons[1].getText().toString()=="o" && buttons[7].getText().toString()=="o" && buttons[4].getText().toString()=="")
            {
                block_user(5);
                return true;
            }
            else if(buttons[4].getText().toString()=="o" && buttons[7].getText().toString()=="o" && buttons[1].getText().toString()=="")
            {
                block_user(2);
                return true;
            }
            else if(buttons[2].getText().toString()=="o" && buttons[5].getText().toString()=="o" && buttons[8].getText().toString()=="")
            {
                block_user(9);
                return true;
            }
            else if(buttons[2].getText().toString()=="o" && buttons[8].getText().toString()=="o" && buttons[5].getText().toString()=="")
            {
                block_user(6);
                return true;
            }
            else if(buttons[5].getText().toString()=="o" && buttons[8].getText().toString()=="o" && buttons[2].getText().toString()=="")
            {
                block_user(3);
                return true;
            }

            else if(buttons[0].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[8].getText().toString()=="")
            {
                block_user(9);
                return true;
            }
            else if(buttons[0].getText().toString()=="o" && buttons[8].getText().toString()=="o" && buttons[4].getText().toString()=="")
            {
                block_user(5);
                return true;
            }
            else if(buttons[4].getText().toString()=="o" && buttons[8].getText().toString()=="o" && buttons[0].getText().toString()=="")
            {
                block_user(1);
                return true;
            }
            else if(buttons[2].getText().toString()=="o" && buttons[4].getText().toString()=="o" && buttons[6].getText().toString()=="")
            {
                block_user(7);
                return true;
            }
            else if(buttons[2].getText().toString()=="o" && buttons[6].getText().toString()=="o" && buttons[4].getText().toString()=="")
            {
                block_user(5);
                return true;
            }
            else if(buttons[4].getText().toString()=="o" && buttons[6].getText().toString()=="o" && buttons[2].getText().toString()=="")
            {
                block_user(3);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    protected static void block_user(int n)
    {
        if(check_empty(n)==true)
        {
            switch(n)
            {
                case 1: buttons[0].setBackgroundColor(Color.RED);
                    buttons[0].setText("x");
                    buttons[0].setEnabled(false);
                    break;
                case 2: buttons[1].setBackgroundColor(Color.RED);
                    buttons[1].setText("x");
                    buttons[1].setEnabled(false);
                    break;
                case 3: buttons[2].setBackgroundColor(Color.RED);
                    buttons[2].setText("x");
                    buttons[2].setEnabled(false);
                    break;
                case 4: buttons[3].setBackgroundColor(Color.RED);
                    buttons[3].setText("x");
                    buttons[3].setEnabled(false);
                    break;
                case 5: buttons[4].setBackgroundColor(Color.RED);
                    buttons[4].setText("x");
                    buttons[4].setEnabled(false);
                    break;
                case 6: buttons[5].setBackgroundColor(Color.RED);
                    buttons[5].setText("x");
                    buttons[5].setEnabled(false);
                    break;
                case 7: buttons[6].setBackgroundColor(Color.RED);
                    buttons[6].setText("x");
                    buttons[6].setEnabled(false);
                    break;
                case 8: buttons[7].setBackgroundColor(Color.RED);
                    buttons[7].setText("x");
                    buttons[7].setEnabled(false);
                    break;
                case 9: buttons[8].setBackgroundColor(Color.RED);
                    buttons[8].setText("x");
                    buttons[8].setEnabled(false);
                    break;

                default :
            }
        }
    }

    protected static boolean finishing_move()
    {
        if(buttons[0].getText().toString()=="x" && buttons[1].getText().toString()=="x")
        {
            if(check_empty(3))
            {
                block_user(3);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[1].getText().toString()=="x" && buttons[2].getText().toString()=="x")
        {
            if(check_empty(1))
            {
                block_user(1);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[0].getText().toString()=="x" && buttons[2].getText().toString()=="x")
        {
            if(check_empty(2))
            {
                block_user(2);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[3].getText().toString()=="x" && buttons[4].getText().toString()=="x")
        {
            if(check_empty(6))
            {
                block_user(6);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[3].getText().toString()=="x" && buttons[5].getText().toString()=="x")
        {
            if(check_empty(5))
            {
                block_user(5);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[4].getText().toString()=="x" && buttons[5].getText().toString()=="x")
        {
            if(check_empty(4))
            {
                block_user(4);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[6].getText().toString()=="x" && buttons[7].getText().toString()=="x")
        {
            if(check_empty(9))
            {
                block_user(9);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[6].getText().toString()=="x" && buttons[8].getText().toString()=="x")
        {
            if(check_empty(8))
            {
                block_user(8);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[7].getText().toString()=="x" && buttons[8].getText().toString()=="x")
        {
            if(check_empty(7))
            {
                block_user(7);
                return true;
            }
            else
            {
                return false;
            }
        }

        else if(buttons[0].getText().toString()=="x" && buttons[3].getText().toString()=="x")
        {
            if(check_empty(7))
            {
                block_user(7);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[0].getText().toString()=="x" && buttons[6].getText().toString()=="x")
        {
            if(check_empty(4))
            {
                block_user(4);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[3].getText().toString()=="x" && buttons[6].getText().toString()=="x")
        {
            if(check_empty(1))
            {
                block_user(1);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[1].getText().toString()=="x" && buttons[4].getText().toString()=="x")
        {
            if(check_empty(8))
            {
                block_user(8);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[1].getText().toString()=="x" && buttons[7].getText().toString()=="x")
        {
            if(check_empty(5))
            {
                block_user(5);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[4].getText().toString()=="x" && buttons[7].getText().toString()=="x")
        {
            if(check_empty(2))
            {
                block_user(2);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[2].getText().toString()=="x" && buttons[5].getText().toString()=="x")
        {
            if(check_empty(9))
            {
                block_user(9);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[2].getText().toString()=="x" && buttons[8].getText().toString()=="x")
        {
            if(check_empty(6))
            {
                block_user(6);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[5].getText().toString()=="x" && buttons[8].getText().toString()=="x")
        {
            if(check_empty(3))
            {
                block_user(3);
                return true;
            }
            else
            {
                return false;
            }
        }

        else if(buttons[0].getText().toString()=="x" && buttons[4].getText().toString()=="x")
        {
            if(check_empty(9))
            {
                block_user(9);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[0].getText().toString()=="x" && buttons[8].getText().toString()=="x")
        {
            if(check_empty(5))
            {
                block_user(5);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[4].getText().toString()=="x" && buttons[8].getText().toString()=="x")
        {
            if(check_empty(1))
            {
                block_user(1);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[2].getText().toString()=="x" && buttons[4].getText().toString()=="x")
        {
            if(check_empty(7))
            {
                block_user(7);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[2].getText().toString()=="x" && buttons[6].getText().toString()=="x")
        {
            if(check_empty(5))
            {
                block_user(5);
                return true;
            }
            else
            {
                return false;
            }
        }
        else if(buttons[4].getText().toString()=="x" && buttons[6].getText().toString()=="x")
        {
            if(check_empty(3))
            {
                block_user(3);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}