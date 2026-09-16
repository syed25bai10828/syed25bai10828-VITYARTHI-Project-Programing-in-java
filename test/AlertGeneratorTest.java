package com.exfil;

import com.exfil.alert.AlertGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlertGeneratorTest {

    @Test
    void testCriticalAlert() {

        AlertGenerator generator = new AlertGenerator();

        String alert = generator.generateAlert(
                "U003",
                90,
                "EXFILTRATION"
        );

        assertNotNull(alert);
        assertFalse(alert.isEmpty());
        assertTrue(alert.contains("U003"));
    }
}
