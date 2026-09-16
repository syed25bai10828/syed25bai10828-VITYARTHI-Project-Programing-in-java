Classification:
Now classify the activity:

0 → NORMAL
1 → SUSPICIOUS
2 → EXFILTRATION

package com.exfil.classification;

import com.exfil.data.ActivityRecord;

import java.util.*;

public class ThreatClassifier {

    /*
     * This class is the model boundary.
     *
     * In the final ML implementation this method
     * should call the trained Random Forest model.
     */

    public int classify(
            ActivityRecord record,
            double anomalyScore) {

        if (anomalyScore >= 0.80 ||
            record.getBytesSent() > 100_000_000 ||
            record.getFilesAccessed() > 100) {

            return 2; // EXFILTRATION
        }

        if (anomalyScore >= 0.60 ||
            record.getBytesSent() > 5_000_000 ||
            record.getFilesAccessed() > 30) {

            return 1; // SUSPICIOUS
        }

        return 0; // NORMAL
    }

    public String labelName(int prediction) {

        return switch (prediction) {
            case 0 -> "NORMAL";
            case 1 -> "SUSPICIOUS";
            case 2 -> "EXFILTRATION";
            default -> "UNKNOWN";
        };
    }
}
