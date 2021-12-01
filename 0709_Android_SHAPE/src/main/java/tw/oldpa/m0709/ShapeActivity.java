package tw.oldpa.m0709;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ShapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
    }

    public void toRectangle(View view) {
        startActivity(new Intent(this, RectangleActivity.class));
    }

    public void toOval(View view) {
        startActivity(new Intent(this, OvalActivity.class));
    }

    public void toLine(View view) {
        startActivity(new Intent(this, LineActivity.class));
    }

    public void toRing(View view) {
        startActivity(new Intent(this, RingActivity.class));
    }
}
