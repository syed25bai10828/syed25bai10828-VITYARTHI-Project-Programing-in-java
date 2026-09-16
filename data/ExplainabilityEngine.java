package com.exfil.explainability;

import com.exfil.data.ActivityRecord;

import java.util.*;

public class ExplainabilityEngine {

    public List<String> explain(ActivityRecord r) {

        List<String> reasons = new ArrayList<>();

        if (r.getBytesSent() > 50_000_000) {
            reasons.add(
                "High outbound data transfer"
            );
        }

        if (r.getFilesAccessed() > 100) {
            reasons.add(
                "Large number of files accessed"
            );
        }

        if (r.getTransferFrequency() > 20) {
            reasons.add(
                "High transfer frequency"
            );
        }

        if (r.getBaselineDeviation() > 5) {
            reasons.add(
                "Significant deviation from user baseline"
            );
        }

        if (!r.getDestinationType()
                .equalsIgnoreCase("internal")) {

            reasons.add(
                "External destination detected"
            );
        }

        if (r.getLoginHour() < 7 ||
            r.getLoginHour() >= 20) {

            reasons.add(
                "Unusual login time"
            );
        }

        if (reasons.isEmpty()) {
            reasons.add(
                "Activity is consistent with normal behaviour"
            );
        }

        return reasons;
    }
}
