package com.kis.aquasmart;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SmartMeterTest {

    @Test
    void loadToken_ReopensClosedValve() {
        SmartMeter meter = new SmartMeter("TEST-001", 100);
        meter.recordConsumption(3);
        assertFalse(meter.isValveOpen(), "Valve should be closed after exhausting credit");

        meter.loadToken(500);
        assertTrue(meter.isValveOpen(), "Valve should reopen after loading token");
    }

    @Test
    void consumptionBeyondCredit_ClosesValve() {
        SmartMeter meter = new SmartMeter("TEST-002", 200);
        boolean result = meter.recordConsumption(5);

        assertFalse(result, "Should not dispense when credit is insufficient");
        assertEquals(0, meter.getCreditBalance(), 0.001, "Balance should be 0");
        assertFalse(meter.isValveOpen(), "Valve should be closed");
    }
}
