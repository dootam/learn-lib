package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The File utils class
 * for various fs-related
 * utility methods.
 */
public class FileUtils {
    /**
     * Load data list.
     *
     * @param path          the path
     * @param headerPresent the header present
     * @return the list
     * @throws IOException the io exception
     */
    public static List<List<Double>> loadData(String path, boolean headerPresent) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String curr;
        if (headerPresent)
            bufferedReader.readLine();
        List<List<Double>> csvData = new ArrayList<>();
        while ((curr = bufferedReader.readLine()) != null) {
            List<Double> row = Arrays.stream(curr.split(",")).map(Double::parseDouble).collect(Collectors.toList());
            csvData.add(row);
        }
        return csvData;
    }
}
