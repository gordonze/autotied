package com.gordon.database.result;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContentRow {
    private List<Content> contents = new ArrayList<>();

    public ContentRow() {
    }
    public  List<Content> getContents(){
        return this.contents;
    }
    public Content getContent(int idex){
        return this.contents.get(idex);
    }
    public Content getContent(String headerName){
        Iterator<Content> iterator = this.getContents().iterator();
        Content content;

        do {
            if(!iterator.hasNext()){
                return  new Content();
            }
            content = iterator.next();
        }while(!StringUtils.equalsIgnoreCase(content.getHeader().getHeaderName(),headerName));

        return content;
    }

    public int size(){
        return this.getContents().size();
    }

    public boolean isEmty(){
        return this.contents.isEmpty();
    }
    public Content [] getContentAsArray(){
        return this.contents.toArray(new Content[0]);
    }

    public void setContentRow(List<Content> contents) {

        this.contents=contents;
    }
}

