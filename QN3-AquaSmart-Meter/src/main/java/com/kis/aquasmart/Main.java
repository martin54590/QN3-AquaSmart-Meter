package com.kis.aquasmart;

public class Main {
    public static void main(String[] args) {
        SmartMeter meter = new SmartMeter("KIS-MTR-001", 5000);

        System.out.println("=== SmartMeter Demo ===");
        System.out.println("Meter: " + meter.getMeterId());
        System.out.println("Initial Credit: UGX " + meter.getCreditBalance());
        System.out.println("Valve Open: " + meter.isValveOpen());

        System.out.println("\n--- Consume 20 litres (UGX 1000) ---");
        boolean dispensed = meter.recordConsumption(20);
        System.out.println("Dispensed: " + dispensed);
        System.out.println("Credit: UGX " + meter.getCreditBalance());

        System.out.println("\n--- Try consuming 200 litres (UGX 10000, not enough credit) ---");
        dispensed = meter.recordConsumption(200);
        System.out.println("Dispensed: " + dispensed);
        System.out.println("Credit: UGX " + meter.getCreditBalance());
        System.out.println("Valve Open: " + meter.isValveOpen());

        System.out.println("\n--- Load token of UGX 2000 ---");
        double newBalance = meter.loadToken(2000);
        System.out.println("New Balance: UGX " + newBalance);
        System.out.println("Valve Open: " + meter.isValveOpen());
    }
}
