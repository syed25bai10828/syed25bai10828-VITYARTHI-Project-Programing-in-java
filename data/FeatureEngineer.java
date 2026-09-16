FeatureEngineering:
package com.exfil.features;

import com.exfil.data.ActivityRecord;

import java.util.*;

public class FeatureEngineer {

    public double[] transform(ActivityRecord r) {

        double transferRate =
                r.getBytesSent() /
                Math.max(r.getSessionDuration(), 1);

        double fileRate =
                r.getFilesAccessed() /
                Math.max(r.getSessionDuration(), 1);

        double byteRatio =
                r.getBytesSent() /
                Math.max(r.getBytesReceived(), 1);

        double nightActivity =
                (r.getLoginHour() < 7 ||
                 r.getLoginHour() >= 20) ? 1.0 : 0.0;

        double externalActivity =
                r.getDestinationType()
                        .equalsIgnoreCase("internal")
                        ? 0.0 : 1.0;

        return new double[] {
                r.getLoginHour(),
                r.getSessionDuration(),
                r.getFilesAccessed(),
                r.getBytesSent(),
                r.getBytesReceived(),
                r.getPacketCount(),
                r.getDestinationFrequency(),
                r.getTransferFrequency(),
                r.getFileAccessFrequency(),
                r.getBaselineDeviation(),
                transferRate,
                fileRate,
                byteRatio,
                nightActivity,
                externalActivity
        };
    }
}
