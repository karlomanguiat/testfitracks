package com.example.mydatabase;

import java.util.ArrayList;

public class Global {
    private static Global instance;
    private static String Foodchoice;

    private Global(){}

    public void setFoodchoice(String Foodchoice){
        Global.Foodchoice=Foodchoice;
    }
    public String getFoodchoice(){
        return Global.Foodchoice;
    }
    public static synchronized Global getInstance(){
        if(instance==null){
            instance=new Global();
        }
        return  instance;
    }
}
