package tw.oldpa.m0705;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;


public class M0705 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory,
        View.OnClickListener {

    // ----宣告變數----
    private TextView txtSelect, txtResult;
    private ImageButton btnScissors, btnStone, btnNet;
    private String user_select;
    private String answer;
    private MediaPlayer startmusic; //宣告媒體物件 片頭音樂
    private MediaPlayer mediaWin; // 宣告媒體物件 贏
    private MediaPlayer mediaLose; // 宣告媒體物件 輸
    private MediaPlayer mediaDraw; // 宣告媒體物件 平
    private ImageSwitcher imgSwi_comp;
    private RelativeLayout r_layout;
    private MediaPlayer endtmusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewComponent();
    }

    private void setupViewComponent() {
        // 從資源類別R中取得介面元件
        txtSelect = (TextView) findViewById(R.id.m0705_s001); // 選擇結果
        txtResult = (TextView) findViewById(R.id.m0705_f000); // 輸贏判斷
        btnScissors = (ImageButton) findViewById(R.id.m0705_b001); // 剪刀
        btnStone = (ImageButton) findViewById(R.id.m0705_b002); // 石頭
        btnNet = (ImageButton) findViewById(R.id.m0705_b003); // 布
        //---電腦出拳---
        imgSwi_comp = (ImageSwitcher) findViewById(R.id.m0705_c001);
        imgSwi_comp.setFactory(this);
        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back01);
//        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_start));
        r_layout.setBackgroundResource(R.drawable.back01);
        //---------------------------------------------------------------
        //--設定imageutton初始值為全透明B
        u_setalpha();
        // --開啟時片頭音樂-----
        startmusic = MediaPlayer.create(M0705.this, R.raw.guess);
        startmusic.start();
        // --close時片尾音樂-----
        endtmusic = MediaPlayer.create(M0705.this, R.raw.byebye);
        //--設定音樂連結--
        mediaWin = MediaPlayer.create(M0705.this, R.raw.win);
        mediaLose = MediaPlayer.create(M0705.this, R.raw.lose);
        mediaDraw = MediaPlayer.create(M0705.this, R.raw.haha);
        // ---啟動監聽事件----
        btnScissors.setOnClickListener(this);
        btnStone.setOnClickListener(this);
        btnNet.setOnClickListener(this);
    }

    private void u_setalpha() {
        btnScissors.setBackgroundResource(R.drawable.circle_shape);
        btnScissors.getBackground().setAlpha(0);

        btnStone.setBackgroundResource(R.drawable.circle_shape);
        btnStone.getBackground().setAlpha(0);

        btnNet.setBackgroundResource(R.drawable.circle_shape);
        btnNet.getBackground().setAlpha(0);

    }
//
    @Override
    public void onClick(View v) {
//-----------------------------------------------------------
        int iComPlay = (int) (Math.random() * 3 + 1);
        // 1 - scissors, 2 - stone, 3 - net.
        switch (iComPlay) {
            case 1: //電腦:剪刀scissors
                user_select = getString(R.string.m0705_s002) + getString(R.string.m0705_b001) + " ";
                imgSwi_comp.setImageResource(R.drawable.scissors); // 轉換ImageView剪刀
                break;
            case 2: //電腦:石頭stone
                user_select = getString(R.string.m0705_s002) + getString(R.string.m0705_b002) + " ";
                imgSwi_comp.setImageResource(R.drawable.stone); // 轉換ImageView石頭
                break;
            case 3: // 電腦:布net
                user_select = getString(R.string.m0705_s002) + getString(R.string.m0705_b003) + " ";
                imgSwi_comp.setImageResource(R.drawable.net); // 轉換ImageView布
                break;
        }
        //------------------------------------------------------
        switch (v.getId()) {
            case R.id.m0705_b001:
                // 選擇 剪刀scissors
                user_select += getString(R.string.m0705_s001) + getString(R.string.m0705_b001);
                //---------------------------------
                u_setalpha();
                btnScissors.getBackground().setAlpha(255);
                //---------------------------------
                switch (iComPlay) {
                    case 1:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003); // 平
                        txtResult.setTextColor(getColor(R.color.Yellow)); // 平用黃顯示
                        music(2);
                        break;
                    case 2:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002); // 輸
                        txtResult.setTextColor(getColor(R.color.Red)); // 輸用紅顯示
                        music(3);
                        break;
                    case 3:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f001); // 贏
                        txtResult.setTextColor(getColor(R.color.Lime)); // 贏用綠顯示
                        music(1);
                        break;
                }

                break;
            //----------------------------------------------
            case R.id.m0705_b002:
                // 選擇 石頭stone
                user_select += getString(R.string.m0705_s001) + getString(R.string.m0705_b002);
                //---------------------------------
                u_setalpha();
                btnStone.getBackground().setAlpha(255);
                //---------------------------------
                switch (iComPlay) {
                    case 1:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f001); // 贏
                        txtResult.setTextColor(getColor(R.color.Lime)); // 贏用綠顯示
                        music(1);
                        break;
                    case 2:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003); // 平
                        txtResult.setTextColor(getColor(R.color.Yellow)); // 平用黃顯示
                        music(2);
                        break;
                    case 3:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002); // 輸
                        txtResult.setTextColor(getColor(R.color.Red)); // 輸用紅顯示
                        music(3);
                        break;
                }
                break;
            //---------------------------------------------
            case R.id.m0705_b003:
                // 選擇 布net
                user_select += getString(R.string.m0705_s001) + getString(R.string.m0705_b003);
                //---------------------------------
                u_setalpha();
                btnNet.getBackground().setAlpha(255);
                //---------------------------------
                switch (iComPlay) {
                    case 1:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002); // 輸
                        txtResult.setTextColor(getColor(R.color.Red)); // 輸用紅顯示
                        music(3);
                        break;
                    case 2:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f001); // 贏
                        txtResult.setTextColor(getColor(R.color.Lime)); // 贏用綠顯示
                        music(1);
                        break;
                    case 3:
                        answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003); // 平
                        txtResult.setTextColor(getColor(R.color.Yellow)); // 平用黃顯示
                        music(2);
                        break;
                }
                break;
        }
        //--------電腦出拳增加動畫---------------
        imgSwi_comp.clearAnimation();
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_trans_in); //down
        anim.setInterpolator(new BounceInterpolator()); //jump
        imgSwi_comp.setAnimation(anim);
        //------------------------------------
        txtSelect.setText(user_select);
        txtResult.setText(answer);
    }


    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        // v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new
                ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }

    private void music(int i) {
        //--中斷播放中音樂--
        if (startmusic != null && startmusic.isPlaying()) {
            startmusic.stop();
//            startmusic.release();
//            startmusic = MediaPlayer.create(this, R.raw.guess);
        }
        if (mediaWin != null && mediaWin.isPlaying()) {
            mediaWin.pause();
//                mediaWin.stop();
//                mediaWin.release();
//                mediaWin = MediaPlayer.create(this, R.raw.vctory);
        }
        if (mediaDraw != null && mediaDraw.isPlaying()) {
            mediaDraw.pause();
//                mediaDraw.release();
//                mediaDraw = MediaPlayer.create(this, R.raw.haha);
        }
        if (mediaLose != null && mediaLose.isPlaying()) {
            mediaLose.pause();
//                mediaLose.release();
//                mediaLose = MediaPlayer.create(this, R.raw.lose);
        }


        //--
        switch (i) {
            case 1: //贏
                mediaWin.start();
                break;
            case 2: //平
                mediaDraw.start();
                break;
            case 3: //輸
                mediaLose.start();
                break;
            case 4: //close
                endtmusic.start();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // --close時片頭音樂-----
        music(4);

    }

    @Override
    public void finish() {
        super.finish();
        // ---關機動畫---
        overridePendingTransition(R.anim.anim_scale_rotate_out, R.anim.anim_alpha_out);
    }

    @Override
    protected void onStop() {
        super.onStop();

        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.m0705, menu);
//        return true;
//
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//
//
//            case R.id.action_settings:
//                r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_start));
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


}
