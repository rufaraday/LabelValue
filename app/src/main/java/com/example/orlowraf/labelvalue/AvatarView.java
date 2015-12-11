package com.example.orlowraf.labelvalue;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by orlowraf on 2015-12-11.
 */
public class AvatarView extends View {

    private Paint paint;
    private Shader shader;

    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.RED);
        paint = new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = Math.min(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        setMeasuredDimension(
                resolveSize(size, widthMeasureSpec),
                resolveSize(size, heightMeasureSpec)
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setShader(shader);
        paint.setAntiAlias(true);
        float halfSize = canvas.getHeight()/2;
        canvas.drawCircle(halfSize, halfSize, halfSize, paint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.been);
        shader = new BitmapShader(Bitmap.createScaledBitmap(bitmap, w, h, true),
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
    }
}
