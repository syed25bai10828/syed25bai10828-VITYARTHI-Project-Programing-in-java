package com.exfil.risk;

import com.exfil.data.ActivityRecord;

public class RiskScorer {

    public double calculate(ActivityRecord r) {

        double score = 0;

        // Data transfer
        if (r.getBytesSent() > 50_000_000)
            score += 30;

        // Files
        if (r.getFilesAccessed() > 100)
            score += 20;

        // Destination
        if (r.getDestinationType()
                .equalsIgnoreCase("unknown_external"))
            score += 20;

        else if (r.getDestinationType()
                .equalsIgnoreCase("external"))
            score += 10;

        // Transfer frequency
        if (r.getTransferFrequency() > 20)
            score += 10;

        // Behaviour deviation
        if (r.getBaselineDeviation() > 5)
            score += 10;

        // Night activity
        if (r.getLoginHour() < 7 ||
            r.getLoginHour() >= 20)
            score += 10;

        score = Math.min(score, 100);

        r.setRiskScore(score);

        return score;
    }

    public String riskLevel(double score) {

        if (score >= 75)
            return "CRITICAL";

        if (score >= 50)
            return "HIGH";

        if (score >= 25)
            return "MEDIUM";

        return "LOW";
    }
}
