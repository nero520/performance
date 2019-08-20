package com.performace.gui.sort.inner.bucket;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistogramUtils {

    private SortEntity sortEntity;

    public HistogramUtils(SortEntity sortEntity) {
        this.sortEntity=sortEntity;
    }
    /**
     * 创建柱状图数据集
     * @return
     */
    public CategoryDataset createDataset(){
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        int[] dataList=sortEntity.getDataList();
        for(int i=0;i<dataList.length;i++){
            if(sortEntity.getIndex_i()==i){
                dataset.setValue(sortEntity.getDataList()[i],"", sortEntity.getDataList()[i]+"  i");
            }else if(sortEntity.getIndex_j()==i){
                dataset.setValue(sortEntity.getDataList()[i],"", sortEntity.getDataList()[i]+"  j");
            }else{
                dataset.setValue(sortEntity.getDataList()[i],"", sortEntity.getDataList()[i]+"");
            }
        }

        return dataset;
    }
    /**
     * 用数据集创建一个图表
     * @param dataset
     * @return
     */
    public JFreeChart createChart(CategoryDataset dataset){
        JFreeChart chart=ChartFactory.createBarChart("", "","", dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
        chart.setTitle(new TextTitle("",new Font("宋体",Font.BOLD+Font.ITALIC,40)));//可以重新设置标题，替换“hi”标题
        CategoryPlot plot=(CategoryPlot)chart.getPlot();//获得图标中间部分，即plot
        CategoryAxis categoryAxis=plot.getDomainAxis();//获得横坐标
        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,10));//设置横坐标字体
        categoryAxis.setMaximumCategoryLabelWidthRatio(2f);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_90);
        return chart;
    }
    /**
     * 生成一个Jpanel
     * @return
     */
    public JPanel createPanel(){
        JFreeChart chart =createChart(createDataset());
        CategoryPlot categoryplot =(CategoryPlot)chart.getCategoryPlot();
        BarRenderer renderer = new CustomRenderer(sortEntity.getIndex_i(), sortEntity.getIndex_j());
        //在柱子上显示相应信息
       // renderer.setBaseItemLabelsVisible(true);
        CategoryTextAnnotation a = new CategoryTextAnnotation("_________________________________________________________", "", sortEntity.getPivot());
        a.setCategoryAnchor(CategoryAnchor.START);
        a.setFont(new Font("SansSerif", Font.PLAIN, 12));
        a.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryplot.addAnnotation(a);
        categoryplot.setRenderer(renderer);
        return new ChartPanel(chart); //将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
    }
}
