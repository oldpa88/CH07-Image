package tw.oldpa.m0709;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class M0709 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0709);
    }

    public void toShape(View view) {
        startActivity(new Intent(this, ShapeActivity.class));
    }

    public void toSelector(View view) {
        startActivity(new Intent(this, SelectorActivity.class));
    }

    public void toLayerList(View view) {
        startActivity(new Intent(this, LayerListActivity.class));
    }

    public void toAnimation(View view) {
        startActivity(new Intent(this, AnimationActivity.class));
    }

}
