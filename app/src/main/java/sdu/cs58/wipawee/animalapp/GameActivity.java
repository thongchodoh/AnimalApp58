package sdu.cs58.wipawee.animalapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    //Explicit ประกาศตัวแปล
    Button btn1,btn2,btn3,btn4;
    ImageView questionImageView;
    ImageButton volumnImageButton;
    MediaPlayer mediaPlayer;// เล่นไฟล์เสียง
    int questionCount = 1;// เก็บขจำนวนข้อคำถาม
    ArrayList<Integer> qID = new ArrayList<Integer>();//ตัวแปลqID เป็นตัวแปลสุชนิดarrayแบบสุ่มคำถาม
    String answer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //Initial view ผูกตัวแปลบน java
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);

        //แสดงคำถาม
        for (int i=1;i<= questionCount;i++) {
            qID.add(i);
        }
        Collections.shuffle(qID);//กำหนดให้คำถามแบบสุ่ม
        setQueastion(qID.remove(0));
    }// end onCreate Method

    private void setQueastion(int qID) {//ใช้กำหนดข้อคำถามและเฉลยในแต่ละข้อ

        if (qID == 1){
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>(); // กำหนดการแรนด้อมช้อย
            choice.add("นก");
            choice.add("ยุง");
            choice.add("หมู");
            choice.add("แมว");
            Collections.shuffle(choice);//กำหนดแรนด้อม
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));
        }

    }//end setQuestion Method
    public void playSound(View view){
        mediaPlayer.start();


    }//end playSound
}//end Class
