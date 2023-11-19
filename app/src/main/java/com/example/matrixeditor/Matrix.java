package com.example.matrixeditor;

public class Matrix
{
    private long id;
    private int width;
    private int height;
    private String data;

    public Matrix()
    {

    }

    public Matrix(int width, int height, String data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public String getDataAsString() {
        return data;
    }
}
