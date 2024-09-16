package com.jabrix.student;

import java.util.StringTokenizer;

public class mahasiswa {
    private String fullname;
    private String username;
    private String email;
    private String nim;
    private String password;
    private String tanggal;
    private String alamat;
    private String nohp;


    public mahasiswa(String fullname, String username, String email, String nim, String password, String tanggal, String alamat, String nohp){
            this.fullname = fullname;
            this.username = username;
            this.email = email;
            this.nim = nim;
            this.password = password;
            this.tanggal = tanggal;
            this.alamat = alamat;
            this.nohp = nohp;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

}
