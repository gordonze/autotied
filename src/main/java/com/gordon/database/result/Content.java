package com.gordon.database.result;

/**
 * gordon edit
 */
public class Content {
    private Object contentObejct;
    private int index;
    private Header header;

    public Content() {
    }

    public Object getContentObejct() {
        return contentObejct;
    }

    public void setContentObejct(Object contentObejct) {
        this.contentObejct = contentObejct;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
