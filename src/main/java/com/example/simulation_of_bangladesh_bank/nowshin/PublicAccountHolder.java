package com.example.simulation_of_bangladesh_bank.nowshin;

import java.time.LocalDate;

public class PublicAccountHolder {
    private String name;
    private String id;
    private String account;
    private LocalDate date;

    public PublicAccountHolder(String name, String id, String account, LocalDate date) {
        this.name = name;
        this.id = id;
        this.account = account;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PublicAccountHolder{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", date=" + date +
                '}';
    }
}
