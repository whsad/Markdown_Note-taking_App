package com.kirito.note_app;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private String html;

    public ResponseResult(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
