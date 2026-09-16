package com.exfil;

import com.exfil.data.ActivityRecord;
import com.exfil.data.DatasetLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatasetLoaderTest {

    @Test
    void testDatasetLoading() throws Exception {

        DatasetLoader loader = new DatasetLoader();

        List<ActivityRecord> records =
                loader.load("data/raw/activity.csv");

        assertNotNull(records);
        assertFalse(records.isEmpty());
    }
}
