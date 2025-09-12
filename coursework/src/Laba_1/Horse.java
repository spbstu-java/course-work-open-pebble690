package Laba_1;

import java.util.function.Consumer;

public class Horse implements Strategy
{
    @Override
    public void move(String from, String to, String name, Consumer<String> output)
    {
        output.accept(name + " rides a horse from " + from + " to " + to);
    }
}