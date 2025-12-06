package com.example.simulation_of_bangladesh_bank.nowshin;

import java.time.LocalDate;

public class MonitorTransactionIntegrity {
    private String reportSl;
    private String duration;
    private LocalDate date;

    public MonitorTransactionIntegrity(String reportSl, String duration, LocalDate date) {
        this.reportSl = reportSl;
        this.duration = duration;
        this.date = date;
    }

    public String getReportSl() {
        return reportSl;
    }

    public void setReportSl(String reportSl) {
        this.reportSl = reportSl;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MonitorTransactionIntegrity{" +
                "reportSl='" + reportSl + '\'' +
                ", duration='" + duration + '\'' +
                ", date=" + date +
                '}';
    }
}
