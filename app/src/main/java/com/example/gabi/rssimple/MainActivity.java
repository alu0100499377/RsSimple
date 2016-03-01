package com.example.gabi.rssimple;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;
    RenderScript mRs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mRs = RenderScript.create(this);
        Background B = new Background();
        b.execute();

    }

    class Background extends AsyncTask<Void, Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap img = Bitmap.createBitmap(1080, 1920, Bitmap.Config.ARGB_8888);
            Allocation alloc = Allocation.createFromBitmap(mRs, img);
            ScriptC_foo foo = new ScriptC_foo(mRs);
            foo.forEach_bar(alloc);
            alloc.copyTo(img);
            return img;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
        }
    }
}
