package com.example.derysudrajat.appsbbi.Quiz.Model;

public class Penjelasan {
    private String pertanyaan,jawaban,penjelasan;

    public Penjelasan(String pertanyaan, String jawaban, String penjelasan) {
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
        this.penjelasan = penjelasan;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }
}
