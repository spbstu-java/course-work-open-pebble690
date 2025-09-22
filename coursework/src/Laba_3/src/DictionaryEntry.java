package Laba_3.src;

public class DictionaryEntry
{
    private final String source;
    private final String translation;

    public DictionaryEntry(String source, String translation)
    {
        this.source = source.toLowerCase();
        this.translation = translation;
    }

    public String getSource()
    {
        return source;
    }

    public String getTranslation()
    {
        return translation;
    }

    @Override
    public String toString()
    {
        return source + " | " + translation;
    }
}