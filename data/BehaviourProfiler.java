Behaviour Profiling :
package com.exfil.profiling;

import com.exfil.data.ActivityRecord;

import java.util.*;

public class BehaviourProfiler {

    public Map<String, double[]> buildProfiles(
            List<ActivityRecord> records) {

        Map<String, List<ActivityRecord>> users =
                new HashMap<>();

        for (ActivityRecord r : records) {
            users.computeIfAbsent(
                    r.getUserId(),
                    k -> new ArrayList<>()
            ).add(r);
        }

        Map<String, double[]> profiles =
                new HashMap<>();

        for (Map.Entry<String, List<ActivityRecord>> entry
                : users.entrySet()) {

            List<ActivityRecord> list = entry.getValue();

            double avgBytes = list.stream()
                    .mapToDouble(ActivityRecord::getBytesSent)
                    .average()
                    .orElse(0);

            double avgFiles = list.stream()
                    .mapToDouble(ActivityRecord::getFilesAccessed)
                    .average()
                    .orElse(0);

            double avgTransfers = list.stream()
                    .mapToDouble(ActivityRecord::getTransferFrequency)
                    .average()
                    .orElse(0);

            profiles.put(
                    entry.getKey(),
                    new double[] {
                            avgBytes,
                            avgFiles,
                            avgTransfers
                    }
            );
        }

        return profiles;
    }
}
