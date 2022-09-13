package com.lyjs.base;

/**
 * 参考链接：
 * ThreadLocal类：https://www.jianshu.com/p/3c5d7f09dfbd
 * threadlocal而是一个线程内部的存储类，可以在指定线程内存储数据，数据存储以后，只有指定线程可以得到存储数据
 * 做个不恰当的比喻，从表面上看ThreadLocal相当于维护了一个map，key就是当前的线程，value就是需要存储的对象。
 */
public class ThreadLocalUtil<T> {
    /**设置当前线程变量
     * @param threadLocal 线程名
     * @param value 线程的值
     * **/
    public void setThreadValue(ThreadLocal<T>threadLocal,T value){
        if(threadLocal.get()==null){
            threadLocal.set(value);
        }
    }
    public T getThreadValue(ThreadLocal<T> threadLocal){
         return threadLocal.get();
    }
}
