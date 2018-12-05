package com.example.derysudrajat.appsbbi.Quiz.Model;

//import com.pixplicity.easyprefs.library.Prefs;

public class User {
    private String username, password, nama;
    private Integer user_id,highscore;

    public User() {
        }

    public User(String username, String password, String nama,Integer highscore,Integer user_id) {

        this.username = username;
        this.password = password;
        this.nama = nama;
        this.highscore = highscore;
        this.user_id = user_id;
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

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public Integer getUserID() {
        return user_id;
    }

    public void setUserID(Integer user_id) {
        this.user_id = user_id;
    }
}
