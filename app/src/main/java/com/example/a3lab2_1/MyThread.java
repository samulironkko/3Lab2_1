package com.example.a3lab2_1;

public class MyThread extends Thread {

    public interface MyInterface {
        void updateText();
    }

    public MyThread(MyInterface myInterface) {
        callBackInterface = myInterface;
    }

    MyInterface callBackInterface = null;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                callBackInterface.updateText();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}
