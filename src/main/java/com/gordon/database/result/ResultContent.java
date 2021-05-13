package com.gordon.database.result;

import com.gordon.framework.controller.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultContent {
    private List<ContentRow> contentRows = new ArrayList<>();
    private HeaderRow headerRow = new HeaderRow();

    public ResultContent() {
    }

    public ResultContent(List<ContentRow> contentRows, HeaderRow headerRow) {
        this.contentRows = contentRows;
        this.headerRow = headerRow;
    }

    public int getRowNumber(){
        return  this.contentRows.size();
    }
    public ContentRow getContentRow(int index){
        if(index>0&&index<this.getRowNumber()){
            return this.getContentRows().get(index);
        }else{
            return null;
        }
    }
    public List<ContentRow> getContentRows(){
        return this.contentRows;
    }

    public ContentRow firsstRow(){

        return  getContentRow(0);
    }
    public ContentRow lastRow(){
        return getContentRow(getRowNumber()-1);
    }

    public List<Content> getColumnContent(String headerName){
        return this.getContentRows().stream().map((t) -> {
            return  t.getContent(this.getHeaderRow().getHeadersAsStringList().indexOf(headerName));
        }).collect(Collectors.toList());
    }

    public ContentRow[] getContentAsArray(){
        return this.getContentRows().toArray(new ContentRow[0]);
    }

    public  boolean equals(List<ContentRow> listRow){
        return this.getContentRows().equals(listRow);
    }
    public void setContentRows(List<ContentRow> contentRows) {
        this.contentRows = contentRows;
    }

    public HeaderRow getHeaderRow() {
        return headerRow;
    }

    public void setHeaderRow(HeaderRow headerRow) {
        this.headerRow = headerRow;
    }
    public  boolean hasResult(){
        return this.getRowNumber()>0;
    }
}
