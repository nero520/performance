package com.performance.bugs.malicious;

import java.util.Date;

/**
 * @author xiaoxiong
 * May expose internal representation by incorporating reference to mutable object
 */
public class DateBug {

    Date excuteTime;

    /**
     * ��������޸�ǰ
     * @param excuteTime
     */
   /* public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime ;
    }*/

    /**
     * ��������޸ĺ�
     * @param excuteTime
     */
    public void setExcuteTime(Date excuteTime) {
        if(excuteTime!=null){
            this.excuteTime = (Date)excuteTime.clone();
        }else {
            this.excuteTime = null;
        }
    }



}
