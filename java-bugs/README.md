#java-bugs常见bug与修正模块<br />
##1.Malicious code vulnerability可能受到的恶意攻击<br />
### 1.May expose internal representation by incorporating reference to mutable object<br />
   public void setExcuteTime(Date excuteTime) {<br />
           this.excuteTime = excuteTime;<br />
       }<br />
   }<br />
   改后
   public void setExcuteTime(Date excuteTime) {<br />
       if(excuteTime!=null){<br />
           this.excuteTime = (Date)excuteTime.clone();<br />
       }else {<br />
           this.excuteTime = null;<br />
       }<br />
   }<br />
### 2.May expose internal representation by returning reference to mutable object<br />
   public Date getExcuteTime() {<br />
       return excuteTime ;<br />
   }<br />
   改后<br />
   public Date getExcuteTime() {<br />
       Date excTime = null;<br />
       if(excuteTime!=null){<br />
           excTime = (Date)excuteTime.clone();<br />
       }<br />
       return excTime;<br />
   }<br />
###   3.Field isn't final but should be<br />
   public class MqDispatcherThread implements Runnable {<br />

       private static final Logger logger = Logger.getLogger(MqDispatcherThread.class);<br />

       public  static final ConcurrentMap<String,MqService> listenerMaps=new ConcurrentHashMap<>();<br />
   改后<br />
   public class MqDispatcherThread implements Runnable {<br />

       private static final Logger logger = Logger.getLogger(MqDispatcherThread.class);<br />

       public  static final ConcurrentMap<String,MqService> listenerMaps=new ConcurrentHashMap<>();<br />
##  2、Dodgy code糟糕的代码<br />
###   1.Write to static field from instance method<br />
###   2.Useless object created<br />
   ArrayList<String> dataList = new ArrayList<String>();<br />
   for(int k=0;k<=200;k++){<br />
       dataList.add(""+k);<br />
   }<br />
   List<ArrayList<String>> resultList = new ArrayList<>();<br />
   ArrayList<String> chartList = new ArrayList<String>();<br />
   for (int i=0; i<=200; i++) {<br />
       if (i % 100 == 0) {<br />
           chartList = new ArrayList<String>(100);<br />
           resultList.add(chartList);<br />
       }<br />
       chartList.add(dataList.get(i));<br />
   }<br />
   System.out.println(resultList.size());<br />
   改成<br />
   ArrayList<String> dataList = new ArrayList<String>();<br />
   for(int k=0;k<=200;k++){<br />
       dataList.add(""+k);<br />
   }<br />
   List<ArrayList<String>> resultList = new ArrayList<>();<br />
   ArrayList<String> chartList = null;<br />
   for (int i=0; i<=200; i++) {<br />
       if (i % 100 == 0) {<br />
           chartList = new ArrayList<String>(100);<br />
           resultList.add(chartList);<br />
       }<br />
       chartList.add(dataList.get(i));<br />
   }<br />
   System.out.println(resultList.size());<br />
###   3.Redundant nullcheck of value known to be non-null<br />
   if (preSubProcess == null || (preSubProcess != null && !(EnumConstTaskProcessStatus.FINISH.equals(preSubProcess.getSubProcessStatus())))) {<br />
       run = false;<br />
       break;<br />
   }<br />
   改为
   if (preSubProcess == null || (!(EnumConstTaskProcessStatus.FINISH.equals(preSubProcess.getSubProcessStatus())))) {<br />
       run = false;<br />
       break;<br />
   }<br />


