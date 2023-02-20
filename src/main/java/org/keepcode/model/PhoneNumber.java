package org.keepcode.model;

import org.json.JSONObject;

import java.util.Objects;

public class PhoneNumber {
    private String number;
    private Long country;
    private String updatedAt;
    private String dataHumans;
    private String fullNumber;
    private String countryText;
    private String maxDate;
    private String status;

    public PhoneNumber(JSONObject jsonObject) {
        this.number = jsonObject.getString("number");
        this.country = jsonObject.getLong("country");
        this.updatedAt = jsonObject.getString("updated_at");
        this.dataHumans = jsonObject.getString("data_humans");
        this.fullNumber = jsonObject.getString("full_number");
        this.countryText = jsonObject.getString("country_text");
        this.maxDate = jsonObject.getString("maxdate");
        this.status = jsonObject.getString("status");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDataHumans() {
        return dataHumans;
    }

    public void setDataHumans(String dataHumans) {
        this.dataHumans = dataHumans;
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                ", country=" + country +
                ", updatedAt='" + updatedAt + '\'' +
                ", dataHumans='" + dataHumans + '\'' +
                ", fullNumber='" + fullNumber + '\'' +
                ", countryText='" + countryText + '\'' +
                ", maxDate='" + maxDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (!Objects.equals(number, that.number)) return false;
        if (!Objects.equals(country, that.country)) return false;
        if (!Objects.equals(updatedAt, that.updatedAt)) return false;
        if (!Objects.equals(dataHumans, that.dataHumans)) return false;
        if (!Objects.equals(fullNumber, that.fullNumber)) return false;
        if (!Objects.equals(countryText, that.countryText)) return false;
        if (!Objects.equals(maxDate, that.maxDate)) return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (dataHumans != null ? dataHumans.hashCode() : 0);
        result = 31 * result + (fullNumber != null ? fullNumber.hashCode() : 0);
        result = 31 * result + (countryText != null ? countryText.hashCode() : 0);
        result = 31 * result + (maxDate != null ? maxDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
