package Laba_3.src;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class DictionaryRepository 
{
    public List<DictionaryEntry> loadDictionary(String filePath) throws FileReadException, InvalidFileFormatException 
    {
        List<DictionaryEntry> entries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) 
        {
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] parts = line.split("\\|");

                if (parts.length != 2) 
                {
                    throw new InvalidFileFormatException("Invalid dictionary line: " + line);
                }

                String source = parts[0].trim();
                String translation = parts[1].trim();
                entries.add(new DictionaryEntry(source, translation));
            }
        } 
        catch (IOException e) 
        {
            throw new FileReadException("Failed to read dictionary file", e);
        }

        entries.sort(Comparator.comparingInt((DictionaryEntry e) -> e.getSource().length()).reversed());

        return entries;
    }
}