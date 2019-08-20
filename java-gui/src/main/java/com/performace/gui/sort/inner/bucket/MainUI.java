package com.performace.gui.sort.inner.bucket;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MainUI {

    private static int sort_type=0;
    private static int speed=1;
    private static int sleeptime=100;
    private static int count=0;
    private static boolean play_flag=false;
    private static boolean start_flag=false;
    private static List<SortEntity> sortList;

    public static void main(String[] args) {
        MainUI.animation();
    }
    /**
     * 算法动画演示
     */
    public static void animation(){
        final JFrame frame=new JFrame();

        frame.setSize(1000,620);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-1000)/2,
                (Toolkit.getDefaultToolkit().getScreenSize().height-620)/2);
        frame.setTitle("Algorithm Teaching System");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sleeptime=100/speed;
        final SortUtils sortUtils=new SortUtils();
        if(sort_type==0){
            sortList=sortUtils.getQuickList();
        }else if(sort_type==1){
            sortList=sortUtils.getBubbleList();
        }else{
            sortList=sortUtils.getShellList();
        }
        final int len=sortList.size();

        JPanel jPanel_sort=new JPanel();
        HistogramUtils histogramUtils=new HistogramUtils(sortList.get(count));
        jPanel_sort=histogramUtils.createPanel();
        frame.add(jPanel_sort);
        jPanel_sort.setBounds(0, 0, 450, 600);

        JLabel jLabel_title=new JLabel("Sort Algorithm");
        frame.add(jLabel_title);
        jLabel_title.setBounds(500, 20, 120, 30);
        JRadioButton jRadioButton_quick=new JRadioButton("Qucik Sort");
        frame.add(jRadioButton_quick);
        if(sort_type==0){
            jRadioButton_quick.setSelected(true);
        }
        jRadioButton_quick.setBounds(500, 50, 120, 30);
        jRadioButton_quick.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sort_type=0;
                frame.dispose();
                MainUI.animation();
            }
        });
        JRadioButton jRadioButton_bubble=new JRadioButton("Bubble Sort");
        frame.add(jRadioButton_bubble);
        jRadioButton_bubble.setBounds(500, 80, 120, 30);
        if(sort_type==1){
            jRadioButton_bubble.setSelected(true);
        }
        jRadioButton_bubble.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                sort_type=1;
                frame.dispose();
                MainUI.animation();
            }
        });
        JRadioButton jRadioButton_shell=new JRadioButton("Shell Sort");
        frame.add(jRadioButton_shell);
        jRadioButton_shell.setBounds(500, 110, 120, 30);
        if(sort_type==2){
            jRadioButton_shell.setSelected(true);
        }
        jRadioButton_shell.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sort_type=2;
                frame.dispose();
                MainUI.animation();
            }
        });
        ButtonGroup buttonGroup_sort=new ButtonGroup();
        buttonGroup_sort.add(jRadioButton_shell);
        buttonGroup_sort.add(jRadioButton_bubble);
        buttonGroup_sort.add(jRadioButton_quick);

        JLabel jLabel_speed=new JLabel("Speed");
        frame.add(jLabel_speed);
        jLabel_speed.setBounds(620, 160, 120, 30);

        final JSlider jSlider_speed = new JSlider(1, 5, 1);
        frame.add(jSlider_speed);
        jSlider_speed.setBounds(500, 190, 300, 40);
        jSlider_speed.setMajorTickSpacing(1);
        jSlider_speed.setPaintTicks(true);
        jSlider_speed.setPaintLabels(true);
        jSlider_speed.addChangeListener(new ChangeListener() {
            
            public void stateChanged(ChangeEvent e) {
                speed=jSlider_speed.getValue();
                sleeptime=100/speed;
            }
        });

        final JButton jButton_start=new JButton("Start");
        frame.add(jButton_start);
        jButton_start.setBounds(500, 320, 80, 30);
        jButton_start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                start_flag=true;
                new Thread(){
                    @Override
                    public void run(){
                        while (count<len&&start_flag){
                            //休眠
                            try {
                                Thread.sleep(sleeptime);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

                            JPanel jPanel_sort=new JPanel();
                            HistogramUtils histogramUtils=new HistogramUtils(sortList.get(count));
                            jPanel_sort=histogramUtils.createPanel();
                            frame.add(jPanel_sort);
                            jPanel_sort.setBounds(0, 0, 450, 600);
                            count++;
                        }
                    }
                }.start();
                jButton_start.setEnabled(false);
            }
        });

        JButton jButton_restart=new JButton("Restart");
        frame.add(jButton_restart);
        jButton_restart.setBounds(600, 320, 80, 30);
        jButton_restart.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainUI.animation();
            }
        });

        final JButton jButton_pause=new JButton("Pause");
        frame.add(jButton_pause);
        jButton_pause.setBounds(700, 320, 80, 30);
        jButton_pause.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(!play_flag){
                    start_flag=false;
                    jButton_pause.setText("Play");
                    play_flag=true;
                }else{
                    start_flag=true;
                    jButton_pause.setText("Pause");
                    play_flag=false;
                    new Thread(){
                        @Override
                        public void run(){
                            while (count<len&&start_flag){
                                //休眠
                                try {
                                    Thread.sleep(sleeptime);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }

                                JPanel jPanel_sort=new JPanel();
                                HistogramUtils histogramUtils=new HistogramUtils(sortList.get(count));
                                jPanel_sort=histogramUtils.createPanel();
                                frame.add(jPanel_sort);
                                jPanel_sort.setBounds(0, 0, 450, 600);
                                count++;
                            }
                        }
                    }.start();
                }
            }
        });

        JButton jButton_forward=new JButton("Forward");
        frame.add(jButton_forward);
        jButton_forward.setBounds(800, 320, 80, 30);
        jButton_forward.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(count<len-1){
                    count++;
                    JPanel jPanel_sort=new JPanel();
                    HistogramUtils histogramUtils=new HistogramUtils(sortList.get(count));
                    jPanel_sort=histogramUtils.createPanel();
                    frame.add(jPanel_sort);
                    jPanel_sort.setBounds(0, 0, 450, 600);
                }
            }
        });

        JButton jButton_back=new JButton("Back");
        frame.add(jButton_back);
        jButton_back.setBounds(900, 320, 80, 30);
        jButton_back.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                if(count>0){
                    count--;
                    JPanel jPanel_sort=new JPanel();
                    HistogramUtils histogramUtils=new HistogramUtils(sortList.get(count));
                    jPanel_sort=histogramUtils.createPanel();
                    frame.add(jPanel_sort);
                    jPanel_sort.setBounds(0, 0, 450, 600);
                }
            }
        });

        JButton jButton_back2menu=new JButton("Back To Menu");
        frame.add(jButton_back2menu);
        jButton_back2menu.setBounds(700, 360, 120, 30);
        jButton_back2menu.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                frame.dispose();
               // MainUI.explanation();
            }
        });

        new Thread(){
            @Override
            public void run(){
                while (count<len&&start_flag){
                    //休眠
                    try {
                        Thread.sleep(sleeptime);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    JPanel jPanel_sort=new JPanel();
                    HistogramUtils histogramUtils=new HistogramUtils(sortList.get(count));
                    jPanel_sort=histogramUtils.createPanel();
                    frame.add(jPanel_sort);
                    jPanel_sort.setBounds(0, 0, 450, 600);
                    count++;
                }
            }
        }.start();
    }
}
