package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Zlayl on 18.08.2016.
 * Zlaylink@gmail.com
 */
public class LoggingStateThread extends Thread
{
    Thread target;

    public LoggingStateThread(Thread target)
    {
        this.target = target;
        //System.out.println(this.target.getState());
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State state = this.target.getState();
        System.out.println(state);
        while (state != State.TERMINATED){
            if (this.target.getState() != state){
                state = this.target.getState();
                System.out.println(state);
            }
        }
    }
}
