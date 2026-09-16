package com.exfil;

import com.exfil.risk.RiskScorer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RiskScorerTest {

    @Test
    void testRiskScoreRange() {

        RiskScorer scorer = new RiskScorer();

        int score = scorer.calculateRisk(
                80000000,
                150,
                "unknown_external",
                25,
                7.0,
                2,
                25000
        );

        assertTrue(score >= 0);
        assertTrue(score <= 100);
    }
}
