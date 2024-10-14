package practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseContentsTest {
	String INPUT_FILE = "input.txt";
	String OUTPUT_FILE = "output.txt";
	
	 @BeforeEach
	    public void setUp() throws IOException {
	        // Create a sample input file for testing
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE))) {
	            writer.write("Hello World");
	        }
	    }
	 
	 @AfterEach
	    public void tearDown() {
	        new File(INPUT_FILE).delete();
	        new File(OUTPUT_FILE).delete();
	    }
	 
	 @Test
	    public void testReverseContent() throws IOException {
	        // Call the method to reverse the file content
	        ReverseContents.reverseFile(INPUT_FILE, OUTPUT_FILE);

	        // Read the reversed content from the output file
	        StringBuilder result = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                result.append(line);
	            }
	        }

	        // Expected reversed content
	        String expected = "dlroW olleH";

	        // Assert that the output matches the expected reversed content
	        assertEquals(expected, result.toString());
	    }
}
