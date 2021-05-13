package com.gordon.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> keys=null;
        List<String>line= new ArrayList<>();
        line.add("gorodn");
        line.add("doris");
        line.add("pease");
        keys=new ArrayList<>(line);
        for(String key :keys){
            System.out.println(key);

        }
    }
}
