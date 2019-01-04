package com.example.derysudrajat.appsbbi.Quiz.Model;

public class User {
    private String username, password, nama,user_id, asal_sekolah;

    public User() {
        }

    public User(String username, String password, String nama, String asal_sekolah) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.asal_sekolah = asal_sekolah;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUserID() {
        return user_id;
    }

    public void setUserID(String user_id) {
        this.user_id = user_id;
    }

    public String getAsal_sekolah() {
        return asal_sekolah;
    }

    public void setAsal_sekolah(String asal_sekolah) {
        this.asal_sekolah = asal_sekolah;
    }
}
