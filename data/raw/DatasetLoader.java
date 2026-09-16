package com.exfil.data;

import java.io.*;
import java.util.*;

public class DatasetLoader {

    public List<ActivityRecord> load(String filePath) throws IOException {

        List<ActivityRecord> records = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            String line;

            // Skip header
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] p = line.split(",");

                if (p.length < 15) {
                    continue;
                }

                ActivityRecord record = new ActivityRecord(
                        p[0],
                        p[1],
                        Integer.parseInt(p[2]),
                        Double.parseDouble(p[3]),
                        Double.parseDouble(p[4]),
                        Double.parseDouble(p[5]),
                        Double.parseDouble(p[6]),
                        Double.parseDouble(p[7]),
                        Double.parseDouble(p[8]),
                        Double.parseDouble(p[9]),
                        Double.parseDouble(p[10]),
                        Double.parseDouble(p[11]),
                        p[12],
                        p[13],
                        Integer.parseInt(p[14])
                );

                records.add(record);
            }
        }

        return records;
    }
}
