package Laba_3.src;
import java.util.List;

public class TranslatorService
{
    private final List<DictionaryEntry> dictionary;

    public TranslatorService(List<DictionaryEntry> dictionary)
    {
        this.dictionary = dictionary;
    }

    public String translate(String input)
    {
        String lowerInput = input.toLowerCase();
        String result = lowerInput;

        for (DictionaryEntry entry : dictionary)
        {
            String source = entry.getSource();
            String translation = entry.getTranslation();

            result = result.replaceAll("\\b" + source + "\\b", translation);
        }

        return result;
    }
}