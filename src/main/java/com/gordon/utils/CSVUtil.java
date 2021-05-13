package com.gordon.utils;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStreamReader;
import java.util.*;

public class CSVUtil {

    public static List<Object[]> getDataFromCSV(String path,Class<?> cls){

        List<Object[]> caseList =new ArrayList<>();
        InputStreamReader in = null;
        try {
            in=new InputStreamReader(ResourceUtil.getRecsourceStream(path,cls),"GBK");
        }catch (Exception e){

        }

        CSVReader<List<String>> reader = new CSVReaderBuilder<List<String>>(in).strategy(CSVStrategy.UK_DEFAULT).entryParser(new CSVEntryParser<List<String>>() {
            @Override
            public List<String> parseEntry(String... data) {
                return Arrays.asList(data);
            }
        }).build();
        try {
            List<String> keys=null;
            //获取csv头信息
            List<String> line = reader.readHeader();
            boolean isKey=true;
            do {
                //主要是获取文件头
                if(isKey){
                    keys =new ArrayList<>(line);
                    isKey=false;
                }else{  //获取文件第二行数据
                    Object[] entities =new Object[1];
                    Map<String,Object> objectMap=new HashMap<>(line.size());
                    for(int i=0;i<line.size();i++){
                        objectMap.put(keys.get(i),line.get(i));
                    }
                    Object testCase = JSONUtil.ObjectMap2Bean(objectMap, cls);
                    entities[0]=testCase;
                    caseList.add(entities);

                }
            }while ((line=reader.readNext())!=null&&!line.stream().allMatch(StringUtils::isEmpty));
        }catch (Exception e){

        }
        return caseList;
    }
}
