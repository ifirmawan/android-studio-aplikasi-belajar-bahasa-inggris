package com.lusi.bbi.Quiz.Model;

public class Penjelasan {
    String soal,jawab,uraian;

    public Penjelasan(String soal, String jawab, String uraian) {
        this.soal = soal;
        this.jawab = jawab;
        this.uraian = uraian;
    }

    public String getSoal() {
        return soal;
    }

    public String getJawab() {
        return jawab;
    }

    public String getUraian() {
        return uraian;
    }
}
