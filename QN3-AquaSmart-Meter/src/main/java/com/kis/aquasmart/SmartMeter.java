package com.kis.aquasmart;

public class SmartMeter {
    private String meterId;
    private double creditBalance;
    private boolean valveOpen;

    public SmartMeter(String meterId, double openingCreditBalance) {
        this.meterId = meterId;
        this.creditBalance = openingCreditBalance;
        this.valveOpen = true;
    }

    public double loadToken(double amount) {
        creditBalance += amount;
        if (!valveOpen) {
            valveOpen = true;
        }
        return creditBalance;
    }

    public boolean recordConsumption(double litres) {
        if (!valveOpen) {
            return false;
        }
        double cost = litres * 50.0;
        if (cost > creditBalance) {
            creditBalance = 0;
            valveOpen = false;
            return false;
        }
        creditBalance -= cost;
        return true;
    }

    public String getMeterId() {
        return meterId;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public boolean isValveOpen() {
        return valveOpen;
    }
}
