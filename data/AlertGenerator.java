package com.exfil.alert;

import com.exfil.data.ActivityRecord;
import com.exfil.classification.ThreatClassifier;
import com.exfil.explainability.ExplainabilityEngine;
import com.exfil.risk.RiskScorer;

import java.util.*;

public class AlertGenerator {

    private final ThreatClassifier classifier;
    private final RiskScorer riskScorer;
    private final ExplainabilityEngine explainer;

    public AlertGenerator(
            ThreatClassifier classifier,
            RiskScorer riskScorer,
            ExplainabilityEngine explainer) {

        this.classifier = classifier;
        this.riskScorer = riskScorer;
        this.explainer = explainer;
    }

    public void generate(ActivityRecord record) {

        String prediction =
                classifier.labelName(
                        record.getPrediction()
                );

        String riskLevel =
                riskScorer.riskLevel(
                        record.getRiskScore()
                );

        if (record.getRiskScore() < 50 &&
            record.getPrediction() == 0) {

            return;
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("          SECURITY ALERT");
        System.out.println("======================================");

        System.out.println(
                "User        : " + record.getUserId());

        System.out.println(
                "Prediction  : " + prediction);

        System.out.println(
                "Risk Score  : " +
                String.format("%.2f",
                        record.getRiskScore()));

        System.out.println(
                "Risk Level  : " + riskLevel);

        System.out.println();
        System.out.println("Reasons:");

        for (String reason :
                explainer.explain(record)) {

            System.out.println(" - " + reason);
        }

        System.out.println("======================================");
    }
}
