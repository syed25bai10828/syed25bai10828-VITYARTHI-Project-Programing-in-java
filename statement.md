# Project Statement

## Project Title

**AI-Powered Data Exfiltration Detection and User Risk Profiling System**

---

## 1. Problem Statement

Data exfiltration refers to the unauthorized transfer of data from a computer system, network, or organization to an external destination.

Modern computing environments generate large amounts of user activity data, making it difficult to manually identify unusual behaviour and potentially harmful data transfers. A system is therefore required to analyse user activity, identify deviations from normal behaviour, classify potentially risky activities, and provide understandable security alerts.

The proposed **AI-Powered Data Exfiltration Detection and User Risk Profiling System** addresses this problem by processing user activity data through preprocessing, feature engineering, user behaviour profiling, anomaly detection, threat classification, risk scoring, explainability, and alert generation.

---

## 2. Project Scope

The scope of the project includes:

* Collection and loading of user activity data.
* Preprocessing and validation of activity records.
* Extraction of cybersecurity-related features.
* Creation of user behaviour profiles.
* Detection of anomalous activities.
* Classification of activities into security categories.
* Calculation of user/activity risk scores.
* Generation of human-readable explanations.
* Generation of security alerts.
* Evaluation of the implemented detection/classification approach.
* Storage of processed data and system results.

The project is designed as an academic cybersecurity application and can be extended in the future for real-time monitoring and integration with enterprise security systems.

---

## 3. Target Users

The system is intended for:

### Security Analysts

To analyse suspicious user activities and investigate potential data-exfiltration events.

### System Administrators

To monitor user activity patterns and identify unusual behaviour within a computing environment.

### Cybersecurity Students and Researchers

To study user behaviour analytics, anomaly detection, data exfiltration detection, and risk profiling.

### Academic Project Evaluators

To evaluate the implementation of a modular Java-based cybersecurity system involving data processing, machine learning/computation, testing, and documentation.

---

## 4. High-Level Features

### 4.1 Dataset Management

* Load activity records from CSV datasets.
* Maintain separation between raw and processed data.
* Validate incoming records.

### 4.2 Data Preprocessing

* Handle invalid records.
* Prepare data for analysis.
* Transform raw activity information into usable data.

### 4.3 Feature Engineering

The system extracts features related to:

* Login time
* Session duration
* Files accessed
* Bytes sent
* Bytes received
* Packet count
* Destination frequency
* Transfer frequency
* File access frequency
* Baseline deviation

### 4.4 User Behaviour Profiling

The system establishes behavioural patterns for users and uses these patterns as a baseline for identifying deviations.

### 4.5 Anomaly Detection

The system identifies activity that differs significantly from established behavioural patterns.

### 4.6 Threat Classification

Activity can be categorized as:

```text
NORMAL
SUSPICIOUS
EXFILTRATION
```

### 4.7 Risk Scoring

The system calculates a risk score and assigns a corresponding risk level:

```text
LOW
MEDIUM
HIGH
CRITICAL
```

### 4.8 Explainability

The system provides understandable reasons for detected risk, such as unusual data transfer, excessive file access, external destinations, unusual login times, or significant deviation from normal behaviour.

### 4.9 Security Alerts

The system generates alerts when activity reaches defined risk conditions.

### 4.10 Evaluation

The system includes an evaluation component for measuring detection/classification performance using metrics such as:

* Precision
* Recall
* F1 Score
* Accuracy

Actual metric values will be reported only from executed test/evaluation results.

---

## 5. High-Level System Flow

```text
Dataset
   ↓
Data Preprocessing
   ↓
Feature Engineering
   ↓
User Behaviour Profiling
   ↓
Anomaly Detection
   ↓
Threat Classification
   ↓
Risk Scoring
   ↓
Explainability
   ↓
Alert Generation
   ↓
Results
```

---

## 6. Expected Outcome

The expected outcome is a modular Java-based cybersecurity application capable of processing user activity data, identifying anomalous behaviour, classifying potentially risky activities, calculating risk levels, explaining detected risks, and generating security alerts.

The project is structured to support testing, documentation, Git-based version control, and future extension with additional datasets and machine-learning techniques.
