package com.example.simulation_of_bangladesh_bank.shifat;

import java.io.Serializable;
import java.time.LocalDate;

public class ManageLoanApproval implements Serializable {
    @javafx.fxml.FXML
    private String loanId;
    private String bankName;
    private int amountRequested;
    private String purpose ;
    private LocalDate applicationDate;
    private String status;

    public ManageLoanApproval(String loanId, String bankName, int amountRequested, String purpose, LocalDate applicationDate, String status) {
        this.loanId = loanId;
        this.bankName = bankName;
        this.amountRequested = amountRequested;
        this.purpose = purpose;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getAmountRequested() {
        return amountRequested;
    }

    public void setAmountRequested(int amountRequested) {
        this.amountRequested = amountRequested;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ManageLoanApproval{" +
                "loanId='" + loanId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", amountRequested=" + amountRequested +
                ", purpose='" + purpose + '\'' +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                '}';
    }
}
