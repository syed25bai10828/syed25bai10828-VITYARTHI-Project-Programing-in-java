AnomalyDetector:
package com.exfil.anomaly;

import com.exfil.data.ActivityRecord;
import smile.anomaly.IsolationForest;

import java.util.*;

public class AnomalyDetector {

    private IsolationForest model;

    public void train(double[][] features) {

        IsolationForest.Options options =
                new IsolationForest.Options(
                        100,
                        256,
                        0,
                        42L
                );

        model = IsolationForest.fit(features, options);
    }

    public double predict(ActivityRecord record,
                           double[] features) {

        double score = model.score(features);

        record.setAnomalyScore(score);

        return score;
    }

    public boolean isAnomaly(double score) {

        return score >= 0.60;
    }
}
