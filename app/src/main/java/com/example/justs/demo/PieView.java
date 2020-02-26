package com.example.justs.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PieView extends View {

    private int[] colors = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.GRAY,Color.BLACK};
    private float startAngle = 0;
    private List<PieData> mData = new ArrayList<>();
    private int width = 1000,height = 1000;
    private Paint paint = new Paint();

    public PieView(Context context) {
        super(context);
        initData();
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float currentAngle = 0;
        canvas.translate(width/2,height/2);
        int r = (int) (0.4 * width);
        RectF rect = new RectF(-r,-r,r,r);
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            paint.setColor(pieData.getColor());
            canvas.drawArc(rect,currentAngle,pieData.getAngle(),true,paint);
            currentAngle += pieData.getAngle();
        }
    }

    private void initData(){
        mData.add(new PieData(1));
        mData.add(new PieData(2));
        mData.add(new PieData(3));
        mData.add(new PieData(4));
        mData.add(new PieData(5));

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++){
            PieData pieData = mData.get(i);
            sumValue += pieData.getValue();
            pieData.setColor(colors[i % colors.length]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++){
            PieData pieData = mData.get(i);
            pieData.setPercent(pieData.getValue() / sumValue);
            pieData.setAngle(pieData.getPercent() * 360);
            sumAngle += pieData.getAngle();
        }

    }

    class PieData{

        private int color;
        private float value;
        private float percent;
        private float angle;

        public PieData(float value) {
            this.value = value;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) {
            this.percent = percent;
        }

        public float getAngle() {
            return angle;
        }

        public void setAngle(float angle) {
            this.angle = angle;
        }
    }

}
