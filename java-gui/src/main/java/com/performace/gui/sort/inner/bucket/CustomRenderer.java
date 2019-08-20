package com.performace.gui.sort.inner.bucket;
import java.awt.Color;
import java.awt.Paint;

import org.jfree.chart.renderer.category.IntervalBarRenderer;

public class CustomRenderer extends IntervalBarRenderer  {
    private int index_i,index_j;
    private Paint[] colors;

    public CustomRenderer(int index_i,int index_j) {
        this.index_i=index_i;
        this.index_j=index_j;
        colors = new Paint[3];
        colors[0]=Color.RED;
        colors[1]=Color.RED;
        colors[2]=Color.GREEN;
    }

    public CustomRenderer() {
        super();
    }

    //对i,j赋予不同于其他柱子的颜色
    public Paint getItemPaint(int i, int j) {
        if(j==index_i){
            return colors[0];
        }else if(j==index_j){
            return colors[1];
        }else {
            return colors[2];
        }
    }
}
