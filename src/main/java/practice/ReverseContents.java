package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseContents {

    public static void reverseFile(String inputFilePath, String outputFilePath) throws IOException {
        StringBuilder content = new StringBuilder();

        // Read the content of the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        // Reverse the content
        content.reverse();

        // Write the reversed content to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(content.toString());
        }
    }
}
