Dataset Loader:
package com.exfil.data;

public class ActivityRecord {

    private String userId;
    private String timestamp;
    private int loginHour;
    private double sessionDuration;
    private double filesAccessed;
    private double bytesSent;
    private double bytesReceived;
    private double packetCount;
    private double destinationFrequency;
    private double transferFrequency;
    private double fileAccessFrequency;
    private double baselineDeviation;
    private String protocol;
    private String destinationType;
    private int label;

    private double anomalyScore;
    private int prediction;
    private double riskScore;

    public ActivityRecord(
            String userId,
            String timestamp,
            int loginHour,
            double sessionDuration,
            double filesAccessed,
            double bytesSent,
            double bytesReceived,
            double packetCount,
            double destinationFrequency,
            double transferFrequency,
            double fileAccessFrequency,
            double baselineDeviation,
            String protocol,
            String destinationType,
            int label) {

        this.userId = userId;
        this.timestamp = timestamp;
        this.loginHour = loginHour;
        this.sessionDuration = sessionDuration;
        this.filesAccessed = filesAccessed;
        this.bytesSent = bytesSent;
        this.bytesReceived = bytesReceived;
        this.packetCount = packetCount;
        this.destinationFrequency = destinationFrequency;
        this.transferFrequency = transferFrequency;
        this.fileAccessFrequency = fileAccessFrequency;
        this.baselineDeviation = baselineDeviation;
        this.protocol = protocol;
        this.destinationType = destinationType;
        this.label = label;
    }

    public String getUserId() {
        return userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getLoginHour() {
        return loginHour;
    }

    public double getSessionDuration() {
        return sessionDuration;
    }

    public double getFilesAccessed() {
        return filesAccessed;
    }

    public double getBytesSent() {
        return bytesSent;
    }

    public double getBytesReceived() {
        return bytesReceived;
    }

    public double getPacketCount() {
        return packetCount;
    }

    public double getDestinationFrequency() {
        return destinationFrequency;
    }

    public double getTransferFrequency() {
        return transferFrequency;
    }

    public double getFileAccessFrequency() {
        return fileAccessFrequency;
    }

    public double getBaselineDeviation() {
        return baselineDeviation;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public int getLabel() {
        return label;
    }

    public double getAnomalyScore() {
        return anomalyScore;
    }

    public void setAnomalyScore(double anomalyScore) {
        this.anomalyScore = anomalyScore;
    }

    public int getPrediction() {
        return prediction;
    }

    public void setPrediction(int prediction) {
        this.prediction = prediction;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }
}
