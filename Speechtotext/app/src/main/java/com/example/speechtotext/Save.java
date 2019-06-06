package com.example.speechtotext;

public class Save {


    private String Text;
    public Save(String text){
        this.Text=text;
    }
    public String getText(){
        return Text;
    }
    public void setText(String text){this.Text=text;}
}
