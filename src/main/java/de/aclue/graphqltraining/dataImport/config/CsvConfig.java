package de.aclue.graphqltraining.dataImport.config;

import org.apache.commons.csv.CSVFormat;

public class CsvConfig {

    private CsvConfig(){
        //empty
    }

    public static final String HEROES_CSV = "./dev_support/test_data/heroes.csv";
    public static final int CSV_INDEX_ID = 0;
    public static final int CSV_INDEX_API_ID = 1;
    public static final int CSV_INDEX_NAME = 2;
    public static final int CSV_INDEX_DESCRIPTION = 3;
    public static final int CSV_INDEX_THUMBNAIL_URL = 4;
    public static final int CSV_INDEX_PUBLISHER = 5;

    public static CSVFormat HERO_CSV_FORMAT =
            CSVFormat.Builder.create()
                    .setHeader("ID", "API_ID", "NAME", "DESCRIPTION", "THUMBNAIL_URL", "PUBLISHER")
                    .setSkipHeaderRecord(true)
                    .build();
}
