package com.example.datepicker;

public class DavidBowie {

    private String coverName;
    private int imgCover;

    public DavidBowie(String coverNamet, int imgCover) {
        this.coverName = coverNamet;
        this.imgCover = imgCover;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverNamet(String coverNamet) {
        this.coverName = coverNamet;
    }

    public int getImgCover() {
        return imgCover;
    }

    public void setImgCover(int imgCover) {
        this.imgCover = imgCover;
    }
}
