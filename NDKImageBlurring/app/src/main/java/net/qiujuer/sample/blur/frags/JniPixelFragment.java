package net.qiujuer.sample.blur.frags;


import android.graphics.Bitmap;

import net.qiujuer.genius.blur.StackBlur;

public class JniPixelFragment extends BaseFragment {

    @Override
    protected void show(long time) {
        super.show(time);
        mText.setText("Jni Pixel");
    }

    @Override
    protected Bitmap blur(Bitmap bitmap, int radius) {
        return StackBlur.blurNativelyPixels(bitmap, radius, true);
    }
}
