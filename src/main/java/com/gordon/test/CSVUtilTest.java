package com.gordon.test;

import com.gordon.bean.TestCase;
import com.gordon.utils.CSVUtil;

import java.util.Iterator;
import java.util.List;

public class CSVUtilTest {

    public static void main(String[] args) {
        String path = "/gordon.csv";
        List<Object[]> dataList = CSVUtil.getDataFromCSV(path, TestCase.class);
        for (Object[] obj:dataList){
            TestCase testCase = (TestCase) obj[0];
            System.out.println(testCase.toString());
        }
    }
}
