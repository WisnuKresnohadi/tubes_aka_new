import java.io.*;
import java.util.*;

public class Array1 {

    public static int[] data = loadArray();

    private static int[] loadArray() {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("5juta.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
