Preprocessing:
package com.exfil.preprocessing;

import com.exfil.data.ActivityRecord;

import java.util.*;

public class DataPreprocessor {

    public List<ActivityRecord> clean(
            List<ActivityRecord> records) {

        List<ActivityRecord> cleaned = new ArrayList<>();

        Set<String> uniqueRecords = new HashSet<>();

        for (ActivityRecord r : records) {

            if (r.getUserId() == null ||
                r.getUserId().isBlank()) {
                continue;
            }

            if (r.getBytesSent() < 0 ||
                r.getBytesReceived() < 0) {
                continue;
            }

            String key =
                    r.getUserId() + "|" + r.getTimestamp();

            if (uniqueRecords.add(key)) {
                cleaned.add(r);
            }
        }

        return cleaned;
    }
}
