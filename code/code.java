import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    static final Random random = new Random(42);

    static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // ============================================================
    // ACTIVITY RECORD
    // ============================================================

    static class Activity {

        String userId;
        String timestamp;

        int day;
        int loginHour;
        int sessionDuration;

        int filesAccessed;
        long bytesSent;
        long bytesReceived;
        int packetCount;

        int destinationFrequency;
        int transferFrequency;
        int fileAccessFrequency;

        double baselineDeviation;

        String protocol;
        String destinationType;

        int actualLabel;

        int riskScore;
        String prediction;
        String riskLevel;

        Activity(
                String userId,
                String timestamp,
                int day,
                int loginHour,
                int sessionDuration,
                int filesAccessed,
                long bytesSent,
                long bytesReceived,
                int packetCount,
                int destinationFrequency,
                int transferFrequency,
                int fileAccessFrequency,
                double baselineDeviation,
                String protocol,
                String destinationType,
                int actualLabel
        ) {

            this.userId = userId;
            this.timestamp = timestamp;
            this.day = day;
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
            this.actualLabel = actualLabel;
        }
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        printTitle();

        // Generate synthetic cybersecurity activity data
        List<Activity> dataset = generateDataset();

        System.out.println("Dataset generated successfully.");
        System.out.println("Total records : " + dataset.size());
        System.out.println("Users         : 10");
        System.out.println("Days          : 7");

        System.out.println("\nStarting Data Exfiltration Analysis...");

        // Step 1
        preprocess(dataset);

        // Step 2
        calculateRisk(dataset);

        // Step 3
        classify(dataset);

        // Step 4
        printResults(dataset);

        // Step 5
        printStatistics(dataset);

        // Step 6
        printUserProfiles(dataset);

        System.out.println("\n====================================================");
        System.out.println(" DATA EXFILTRATION DETECTION COMPLETED");
        System.out.println("====================================================");
    }

    // ============================================================
    // TITLE
    // ============================================================

    static void printTitle() {

        System.out.println();
        System.out.println("====================================================");
        System.out.println(" AI-POWERED DATA EXFILTRATION DETECTION SYSTEM");
        System.out.println("====================================================");
        System.out.println("User Behavioral Risk Profiling");
        System.out.println("Cybersecurity Monitoring System");
        System.out.println("====================================================");
        System.out.println();
    }

    // ============================================================
    // DATASET GENERATION
    // ============================================================

    static List<Activity> generateDataset() {

        List<Activity> dataset = new ArrayList<>();

        String[] users = {
                "U001", "U002", "U003", "U004", "U005",
                "U006", "U007", "U008", "U009", "U010"
        };

        /*
         * 7 days
         * 20 records per day
         * Total = 140 records
         */

        for (int day = 1; day <= 7; day++) {

            for (int i = 0; i < 20; i++) {

                String userId =
                        users[random.nextInt(users.length)];

                int label = generateBehavior(day);

                LocalDateTime time = generateTime(day);

                Activity activity;

                if (label == 0) {

                    activity = generateNormal(
                            userId,
                            time,
                            day
                    );

                } else if (label == 1) {

                    activity = generateSuspicious(
                            userId,
                            time,
                            day
                    );

                } else {

                    activity = generateExfiltration(
                            userId,
                            time,
                            day
                    );
                }

                dataset.add(activity);
            }
        }

        return dataset;
    }

    // ============================================================
    // BEHAVIOR GENERATION
    // ============================================================

    static int generateBehavior(int day) {

        int value = random.nextInt(100);

        if (day <= 3) {

            if (value < 90)
                return 0;

            if (value < 98)
                return 1;

            return 2;
        }

        if (day <= 5) {

            if (value < 75)
                return 0;

            if (value < 93)
                return 1;

            return 2;
        }

        // Days 6 and 7

        if (value < 60)
            return 0;

        if (value < 82)
            return 1;

        return 2;
    }

    // ============================================================
    // TIMESTAMP GENERATION
    // ============================================================

    static LocalDateTime generateTime(int day) {

        int hour;

        if (random.nextInt(100) < 85) {

            // Normal working hours
            hour = 8 + random.nextInt(11);

        } else {

            // Unusual login hours
            if (random.nextBoolean())
                hour = random.nextInt(7);
            else
                hour = 19 + random.nextInt(5);
        }

        int minute = random.nextInt(60);
        int second = random.nextInt(60);

        return LocalDateTime.of(
                2026,
                1,
                4 + day,
                hour,
                minute,
                second
        );
    }

    // ============================================================
    // NORMAL ACTIVITY
    // ============================================================

    static Activity generateNormal(
            String userId,
            LocalDateTime time,
            int day) {

        int sessionDuration =
                1800 + random.nextInt(5400);

        int filesAccessed =
                2 + random.nextInt(20);

        long bytesSent =
                50000L + random.nextInt(450000);

        long bytesReceived =
                200000L + random.nextInt(2000000);

        int packetCount =
                100 + random.nextInt(900);

        int destinationFrequency =
                5 + random.nextInt(30);

        int transferFrequency =
                1 + random.nextInt(5);

        int fileAccessFrequency =
                2 + random.nextInt(15);

        double baselineDeviation =
                0.10 + random.nextDouble() * 1.50;

        String[] protocols = {
                "HTTP", "HTTPS", "TCP", "UDP"
        };

        String protocol =
                protocols[random.nextInt(protocols.length)];

        return new Activity(
                userId,
                time.format(FORMATTER),
                day,
                time.getHour(),
                sessionDuration,
                filesAccessed,
                bytesSent,
                bytesReceived,
                packetCount,
                destinationFrequency,
                transferFrequency,
                fileAccessFrequency,
                baselineDeviation,
                protocol,
                "internal",
                0
        );
    }

    // ============================================================
    // SUSPICIOUS ACTIVITY
    // ============================================================

    static Activity generateSuspicious(
            String userId,
            LocalDateTime time,
            int day) {

        int sessionDuration =
                3600 + random.nextInt(9000);

        int filesAccessed =
                20 + random.nextInt(80);

        long bytesSent =
                1000000L + random.nextInt(15000000);

        long bytesReceived =
                500000L + random.nextInt(5000000);

        int packetCount =
                1000 + random.nextInt(5000);

        int destinationFrequency =
                1 + random.nextInt(5);

        int transferFrequency =
                8 + random.nextInt(15);

        int fileAccessFrequency =
                15 + random.nextInt(40);

        double baselineDeviation =
                2.0 + random.nextDouble() * 5.0;

        String[] protocols = {
                "HTTP", "HTTPS", "TCP", "FTP"
        };

        String protocol =
                protocols[random.nextInt(protocols.length)];

        return new Activity(
                userId,
                time.format(FORMATTER),
                day,
                time.getHour(),
                sessionDuration,
                filesAccessed,
                bytesSent,
                bytesReceived,
                packetCount,
                destinationFrequency,
                transferFrequency,
                fileAccessFrequency,
                baselineDeviation,
                protocol,
                "external",
                1
        );
    }

    // ============================================================
    // DATA EXFILTRATION ACTIVITY
    // ============================================================

    static Activity generateExfiltration(
            String userId,
            LocalDateTime time,
            int day) {

        int sessionDuration =
                7200 + random.nextInt(18000);

        int filesAccessed =
                100 + random.nextInt(500);

        long bytesSent =
                100000000L + random.nextInt(900000000);

        long bytesReceived =
                100000L + random.nextInt(1000000);

        int packetCount =
                10000 + random.nextInt(50000);

        int destinationFrequency =
                1 + random.nextInt(3);

        int transferFrequency =
                20 + random.nextInt(50);

        int fileAccessFrequency =
                50 + random.nextInt(150);

        double baselineDeviation =
                8.0 + random.nextDouble() * 20.0;

        String protocol =
                random.nextBoolean()
                        ? "HTTPS"
                        : "FTP";

        return new Activity(
                userId,
                time.format(FORMATTER),
                day,
                time.getHour(),
                sessionDuration,
                filesAccessed,
                bytesSent,
                bytesReceived,
                packetCount,
                destinationFrequency,
                transferFrequency,
                fileAccessFrequency,
                baselineDeviation,
                protocol,
                "unknown_external",
                2
        );
    }

    // ============================================================
    // PREPROCESSING
    // ============================================================

    static void preprocess(List<Activity> dataset) {

        for (Activity a : dataset) {

            if (a.bytesSent < 0)
                a.bytesSent = 0;

            if (a.bytesReceived < 0)
                a.bytesReceived = 0;

            if (a.filesAccessed < 0)
                a.filesAccessed = 0;

            if (a.transferFrequency < 0)
                a.transferFrequency = 0;

            if (a.baselineDeviation < 0)
                a.baselineDeviation = 0;
        }

        System.out.println("✓ Data preprocessing completed");
    }

    // ============================================================
    // RISK SCORE
    // ============================================================

    static void calculateRisk(List<Activity> dataset) {

        for (Activity a : dataset) {

            int score = 0;

            // Large amount of outgoing data
            if (a.bytesSent > 50_000_000L)
                score += 35;

            // Large number of files
            if (a.filesAccessed > 100)
                score += 20;

            // Unknown destination
            if (a.destinationType.equals("unknown_external"))
                score += 20;

            // High transfer frequency
            if (a.transferFrequency > 20)
                score += 15;

            // User behavior deviation
            if (a.baselineDeviation > 5)
                score += 10;

            // Login outside normal hours
            if (a.loginHour < 7 || a.loginHour > 19)
                score += 10;

            // High packet volume
            if (a.packetCount > 20000)
                score += 5;

            // External destination
            if (a.destinationType.equals("external"))
                score += 5;

            a.riskScore = Math.min(score, 100);
        }

        System.out.println("✓ Behavioral risk scoring completed");
    }

    // ============================================================
    // CLASSIFICATION
    // ============================================================

    static void classify(List<Activity> dataset) {

        for (Activity a : dataset) {

            if (a.riskScore >= 75) {

                a.prediction = "EXFILTRATION";
                a.riskLevel = "CRITICAL";

            } else if (a.riskScore >= 50) {

                a.prediction = "SUSPICIOUS";
                a.riskLevel = "HIGH";

            } else if (a.riskScore >= 25) {

                a.prediction = "SUSPICIOUS";
                a.riskLevel = "MEDIUM";

            } else {

                a.prediction = "NORMAL";
                a.riskLevel = "LOW";
            }
        }

        System.out.println("✓ Activity classification completed");
    }

    // ============================================================
    // RESULTS
    // ============================================================

    static void printResults(List<Activity> dataset) {

        System.out.println();
        System.out.println("====================================================");
        System.out.println(" HIGH-RISK ACTIVITY DETECTION");
        System.out.println("====================================================");

        int count = 0;

        for (Activity a : dataset) {

            if (a.riskScore >= 50) {

                count++;

                System.out.println();
                System.out.println("----------------------------------------------");

                System.out.println(
                        "User            : " + a.userId);

                System.out.println(
                        "Timestamp       : " + a.timestamp);

                System.out.println(
                        "Day             : " + a.day);

                System.out.println(
                        "Files Accessed  : " + a.filesAccessed);

                System.out.println(
                        "Bytes Sent      : "
                                + formatBytes(a.bytesSent));

                System.out.println(
                        "Bytes Received  : "
                                + formatBytes(a.bytesReceived));

                System.out.println(
                        "Protocol        : " + a.protocol);

                System.out.println(
                        "Destination     : "
                                + a.destinationType);

                System.out.println(
                        "Transfer Freq.  : "
                                + a.transferFrequency);

                System.out.println(
                        "Baseline Dev.   : "
                                + String.format(
                                        "%.2f",
                                        a.baselineDeviation));

                System.out.println(
                        "Risk Score      : "
                                + a.riskScore + "/100");

                System.out.println(
                        "Risk Level      : "
                                + a.riskLevel);

                System.out.println(
                        "Prediction      : "
                                + a.prediction);

                printExplanation(a);
            }
        }

        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println(
                "High-risk records detected : " + count);
    }

    // ============================================================
    // EXPLAINABLE AI STYLE REASON
    // ============================================================

    static void printExplanation(Activity a) {

        System.out.println();
        System.out.println("Reasons for Detection:");

        if (a.bytesSent > 50_000_000L) {

            System.out.println(
                    "  • Extremely high outbound data transfer");
        }

        if (a.filesAccessed > 100) {

            System.out.println(
                    "  • Unusually large number of files accessed");
        }

        if (a.destinationType.equals("unknown_external")) {

            System.out.println(
                    "  • Data sent to unknown external destination");
        }

        if (a.transferFrequency > 20) {

            System.out.println(
                    "  • Very high transfer frequency");
        }

        if (a.baselineDeviation > 5) {

            System.out.println(
                    "  • Strong deviation from normal user behavior");
        }

        if (a.loginHour < 7 || a.loginHour > 19) {

            System.out.println(
                    "  • Activity occurred outside normal working hours");
        }

        if (a.packetCount > 20000) {

            System.out.println(
                    "  • High network packet volume");
        }
    }

    // ============================================================
    // STATISTICS
    // ============================================================

    static void printStatistics(List<Activity> dataset) {

        int normal = 0;
        int suspicious = 0;
        int exfiltration = 0;

        int low = 0;
        int medium = 0;
        int high = 0;
        int critical = 0;

        for (Activity a : dataset) {

            if (a.actualLabel == 0)
                normal++;

            else if (a.actualLabel == 1)
                suspicious++;

            else
                exfiltration++;

            if (a.riskLevel.equals("LOW"))
                low++;

            else if (a.riskLevel.equals("MEDIUM"))
                medium++;

            else if (a.riskLevel.equals("HIGH"))
                high++;

            else
                critical++;
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println(" DATASET STATISTICS");
        System.out.println("====================================================");

        System.out.println(
                "Total Records       : " + dataset.size());

        System.out.println(
                "Normal Records      : " + normal);

        System.out.println(
                "Suspicious Records  : " + suspicious);

        System.out.println(
                "Exfiltration Records: " + exfiltration);

        System.out.println();

        System.out.println("Risk Distribution:");

        System.out.println(
                "LOW                 : " + low);

        System.out.println(
                "MEDIUM              : " + medium);

        System.out.println(
                "HIGH                : " + high);

        System.out.println(
                "CRITICAL            : " + critical);
    }

    // ============================================================
    // USER BEHAVIORAL PROFILING
    // ============================================================

    static void printUserProfiles(List<Activity> dataset) {

        Map<String, Integer> total =
                new HashMap<>();

        Map<String, Long> bytes =
                new HashMap<>();

        Map<String, Integer> highRisk =
                new HashMap<>();

        for (Activity a : dataset) {

            total.put(
                    a.userId,
                    total.getOrDefault(a.userId, 0) + 1
            );

            bytes.put(
                    a.userId,
                    bytes.getOrDefault(a.userId, 0L)
                            + a.bytesSent
            );

            if (a.riskScore >= 50) {

                highRisk.put(
                        a.userId,
                        highRisk.getOrDefault(
                                a.userId,
                                0
                        ) + 1
                );
            }
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println(" USER RISK PROFILES");
        System.out.println("====================================================");

        List<String> users =
                new ArrayList<>(total.keySet());

        Collections.sort(users);

        for (String user : users) {

            int records = total.get(user);

            long sent = bytes.get(user);

            int risky =
                    highRisk.getOrDefault(user, 0);

            double riskPercentage =
                    ((double) risky / records) * 100;

            System.out.println();

            System.out.println(
                    "User              : " + user);

            System.out.println(
                    "Activity Records  : " + records);

            System.out.println(
                    "Total Data Sent   : "
                            + formatBytes(sent));

            System.out.println(
                    "High-Risk Events  : " + risky);

            System.out.println(
                    "Risk Percentage   : "
                            + String.format(
                                    "%.2f",
                                    riskPercentage)
                            + "%");
        }
    }

    // ============================================================
    // BYTE FORMATTER
    // ============================================================

    static String formatBytes(long bytes) {

        if (bytes >= 1_000_000_000L) {

            return String.format(
                    "%.2f GB",
                    bytes / 1_000_000_000.0
            );

        } else if (bytes >= 1_000_000L) {

            return String.format(
                    "%.2f MB",
                    bytes / 1_000_000.0
            );

        } else if (bytes >= 1000) {

            return String.format(
                    "%.2f KB",
                    bytes / 1000.0
            );
        }

        return bytes + " B";
    }
}
