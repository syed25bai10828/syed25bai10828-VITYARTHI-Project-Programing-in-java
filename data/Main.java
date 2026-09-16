package com.exfil;

import com.exfil.data.*;
import com.exfil.preprocessing.*;
import com.exfil.features.*;
import com.exfil.profiling.*;
import com.exfil.anomaly.*;
import com.exfil.classification.*;
import com.exfil.risk.*;
import com.exfil.explainability.*;
import com.exfil.alert.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("=================================================");
        System.out.println(" AI-POWERED DATA EXFILTRATION DETECTION SYSTEM");
        System.out.println("=================================================");

        try {

            // ==========================================
            // 1. DATASET
            // ==========================================

            DatasetLoader loader =
                    new DatasetLoader();

            List<ActivityRecord> records =
                    loader.load(
                        "data/raw/activity.csv"
                    );

            System.out.println(
                    "[1] Dataset loaded: "
                    + records.size()
                    + " records"
            );


            // ==========================================
            // 2. PREPROCESSING
            // ==========================================

            DataPreprocessor preprocessor =
                    new DataPreprocessor();

            records =
                    preprocessor.clean(records);

            System.out.println(
                    "[2] Preprocessing completed"
            );


            // ==========================================
            // 3. FEATURE ENGINEERING
            // ==========================================

            FeatureEngineer engineer =
                    new FeatureEngineer();

            List<double[]> featureList =
                    new ArrayList<>();

            for (ActivityRecord record : records) {

                featureList.add(
                        engineer.transform(record)
                );
            }

            double[][] features =
                    featureList.toArray(
                            new double[0][]
                    );

            System.out.println(
                    "[3] Feature engineering completed"
            );


            // ==========================================
            // 4. BEHAVIOUR PROFILING
            // ==========================================

            BehaviourProfiler profiler =
                    new BehaviourProfiler();

            Map<String, double[]> profiles =
                    profiler.buildProfiles(records);

            System.out.println(
                    "[4] User profiles created: "
                    + profiles.size()
            );


            // ==========================================
            // 5. ANOMALY DETECTION
            // ==========================================

            AnomalyDetector detector =
                    new AnomalyDetector();

            detector.train(features);

            System.out.println(
                    "[5] Isolation Forest trained"
            );


            // ==========================================
            // 6. CLASSIFICATION
            // ==========================================

            ThreatClassifier classifier =
                    new ThreatClassifier();

            System.out.println(
                    "[6] Threat classification initialized"
            );


            // ==========================================
            // 7. RISK SCORING
            // ==========================================

            RiskScorer riskScorer =
                    new RiskScorer();


            // ==========================================
            // 8. EXPLAINABILITY
            // ==========================================

            ExplainabilityEngine explainer =
                    new ExplainabilityEngine();


            // ==========================================
            // 9. ALERT GENERATION
            // ==========================================

            AlertGenerator alertGenerator =
                    new AlertGenerator(
                            classifier,
                            riskScorer,
                            explainer
                    );


            // ==========================================
            // COMPLETE PIPELINE
            // ==========================================

            for (int i = 0; i < records.size(); i++) {

                ActivityRecord record =
                        records.get(i);

                double anomalyScore =
                        detector.predict(
                                record,
                                features[i]
                        );

                int prediction =
                        classifier.classify(
                                record,
                                anomalyScore
                        );

                record.setPrediction(
                        prediction
                );

                riskScorer.calculate(record);

                alertGenerator.generate(record);
            }


            System.out.println();
            System.out.println(
                    "================================================="
            );

            System.out.println(
                    "PIPELINE EXECUTION COMPLETED"
            );

            System.out.println(
                    "================================================="
            );

        } catch (Exception e) {

            System.err.println(
                    "ERROR: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }
}
