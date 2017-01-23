package com.performance.bugs.malicious;

import java.util.Date;

/**
 * @author xiaoxiong
 * May expose internal representation by incorporating reference to mutable object
 */
public class DateBug {

    Date excuteTime;

    /**
     * 错误代码修改前
     * @param excuteTime
     */
   /* public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime ;
    }*/

    /**
     * 错误代码修改后
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
