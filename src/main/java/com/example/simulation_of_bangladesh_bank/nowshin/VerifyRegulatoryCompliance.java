package com.example.simulation_of_bangladesh_bank.nowshin;

import java.time.LocalDate;

public class VerifyRegulatoryCompliance {
    private String regulationId;
    private String regulationTitle;
    private LocalDate effectiveDate;

    public VerifyRegulatoryCompliance(String regulationId, String regulationTitle, LocalDate effectiveDate) {
        this.regulationId = regulationId;
        this.regulationTitle = regulationTitle;
        this.effectiveDate = effectiveDate;
    }

    public String getRegulationId() {
        return regulationId;
    }

    public void setRegulationId(String regulationId) {
        this.regulationId = regulationId;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getRegulationTitle() {
        return regulationTitle;
    }

    public void setRegulationTitle(String regulationTitle) {
        this.regulationTitle = regulationTitle;
    }

    @Override
    public String toString() {
        return "VerifyRegulatoryCompliance{" +
                "regulationId='" + regulationId + '\'' +
                ", regulationTitle='" + regulationTitle + '\'' +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
