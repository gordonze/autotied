package com.gordon.database.result;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBReult {
    private HeaderRow headerRow;
    private ResultContent resultContent;

    public DBReult() {
    }
    public DBReult(ResultSet rs){

        try {
            HeaderRow headerRow = new HeaderRow();
            List<Header> headers =new ArrayList<>();
            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();
            for(int i=1;i<=columnCount;i++){
                Header header=new Header();
                header.setHeaderName(metaData.getColumnName(i));
                header.setIndex(i-1);
                header.setType(metaData.getColumnType(i));
                headers.add(header);
            }
            headerRow.setHeaders(headers);
            this.headerRow=headerRow;

            ResultContent resultContent = new ResultContent();
            List<ContentRow> contentRows = new ArrayList<>();

            while (rs.next()){
                ContentRow contentRow = new ContentRow();
                List<Content> contents =new ArrayList<>();
                for(int i=0;i<columnCount;i++){
                    Header header=headers.get(i);
                    Content content = new Content();
                    content.setHeader(header);
                    content.setIndex(i);
                    content.setContentObejct(rs.getObject(i+1));
                    contents.add(content);
                }
                contentRow.setContentRow(contents);
                contentRows.add(contentRow);
            }

            resultContent.setContentRows(contentRows);
            resultContent.setHeaderRow(headerRow);

            this.resultContent=resultContent;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  boolean hasResult(){
        return this.getResultContent()!=null&&this.getResultContent().hasResult();
    }
    public HeaderRow getHeaderRow() {
        return headerRow;
    }

    public void setHeaderRow(HeaderRow headerRow) {
        this.headerRow = headerRow;
    }

    public ResultContent getResultContent() {
        return resultContent;
    }

    public void setResultContent(ResultContent resultContent) {
        this.resultContent = resultContent;
    }
}
