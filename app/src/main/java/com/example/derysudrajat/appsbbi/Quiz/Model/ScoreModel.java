package com.example.derysudrajat.appsbbi.Quiz.Model;

public class ScoreModel {
    String name;

    String version_number;
    String feature;


    public ScoreModel(String name,  String version_number, String feature ) {
        this.name=name;
        this.version_number=version_number;
        this.feature=feature;

    }


    public String getName() {
        return name;
    }

    public String getVersion_number() {
        return version_number;
    }


    public String getFeature() {
        return feature;
    }
}
