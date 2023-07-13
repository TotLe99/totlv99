package Btap_DemSoLanXuatHienMoiTuTrongMap;

import java.util.Locale;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        String str = "Day la vi du String. String nay chua tu ngu va dau cham.";
        str = str.replaceAll("[^a-zA-Z0-9 ]", "");
        String[] words = str.split("\\s+");

        TreeMap<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : words) {
            String key = word.toUpperCase();
            if (wordCountMap.containsKey(key)) {
                int count = wordCountMap.get(key);
                wordCountMap.put(key, count + 1);
            } else {
                wordCountMap.put(key, 1);
            }
        }

        for (String key: wordCountMap.keySet()) {
            int count = wordCountMap.get(key);
            System.out.println(key + ": " + count);
        }
    }
}
