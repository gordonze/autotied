package com.gordon.database.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeaderRow {
    private List<Header> headers = new ArrayList<Header>();

    public HeaderRow() {
    }

    public HeaderRow(List<Header> headers) {
        this.headers = headers;
    }
    public List<Header> getHeaders(){
        return this.headers;
    }
    public Header getHeader(int index){
        return this.getHeaders().get(index);
    }
    public Header getHeader(String headerName){
        return this.getHeaders().stream().filter((header) -> {
            return header.getHeaderName().equalsIgnoreCase(headerName);
        }).collect(Collectors.toList()).get(0);
    }
    public List<String> getHeadersAsStringList(){
        return this.getHeaders().stream().map((t) ->{
            return t.getHeaderName();
        }).collect(Collectors.toList());
    }

    public int size(){
        return this.headers.size();
    }
    public boolean equals(List<Header> list){
        return this.headers.equals(list);
    }

    public void setHeaders(List<Header> headers) {
        this.headers=headers;
    }

}
