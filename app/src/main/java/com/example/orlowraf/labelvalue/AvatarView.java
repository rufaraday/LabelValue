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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by orlowraf on 2015-12-11.
 */
public class AvatarView extends View {

    private Paint paint;
    private Paint stroke;
    private Shader shader;
    private boolean isPressed;

    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        stroke = new Paint();
        stroke.setColor(Color.MAGENTA);
        stroke.setStyle(Paint.Style.STROKE);
        stroke.setStrokeWidth(7);
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
        if (isPressed) {
            canvas.drawCircle(halfSize, halfSize, halfSize-3, stroke);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.been);
        int bitmapW = bitmap.getWidth();
        int bitmapH = bitmap.getHeight();
        float factor = Math.min(bitmapH, bitmapW) / w;
        Log.d("RO", "bitmapW=" + bitmapW + "bitmapH" + bitmapH + " " + Math.round(bitmapW*factor*w) + " " + Math.round(bitmapH*factor*w));
        shader = new BitmapShader(Bitmap.createScaledBitmap(bitmap, w, h, true),
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isPressed = true;
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isPressed = false;
                invalidate();
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}
