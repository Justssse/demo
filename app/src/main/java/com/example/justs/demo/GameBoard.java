package com.example.justs.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameBoard extends View {

    private int nSquares = 8, colorA = Color.BLUE, colorB = Color.WHITE;

    private Paint paint = new Paint();
    private int squareDimX;
    private int squareDimY;

    public GameBoard(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int row = 0; row < nSquares; row++) {
            paint.setColor(((row & 1 ) == 0) ? colorA : colorB);
            for (int col = 0; col < nSquares; col++) {
                int a = col * squareDimX;
                int b = row * squareDimY;
                paint.setColor((paint.getColor() == colorA) ? colorB : colorA);
                canvas.drawRect(a, b, a + squareDimX, b + squareDimY, paint);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
        squareDimX = width / nSquares;
        squareDimY = height / nSquares;
    }

}
