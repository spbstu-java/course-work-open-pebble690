package Laba_1;

import java.util.function.Consumer;

public class Walk implements Strategy
{
    @Override
    public void move(String from, String to, String name, Consumer<String> output)
    {
        output.accept(name + " is walking from " + from + " to " + to);
    }
}