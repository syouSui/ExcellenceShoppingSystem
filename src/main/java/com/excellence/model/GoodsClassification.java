package com.excellence.model;

/********************************************************************************
 ** Project Name: ExcellenceShoppingSystem
 ** Author： Kaffu-Chino
 ** Date： 2020/5/18 17:11
 ** LastEditors: Kaffu-Chino
 ** Description： 
 *********************************************************************************/

public class GoodsClassification {
    private String classificationId;
    private String classificationName;

    public GoodsClassification ( ) {
    }

    public GoodsClassification(String classificationId, String classificationName) {
        this.classificationId = classificationId;
        this.classificationName = classificationName;
    }

    public String getClassificationId () {
        return classificationId;
    }

    public void setClassificationId ( String classificationId ) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }
}
