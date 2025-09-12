package Laba_1;

import java.util.function.Consumer;

public class Fly implements Strategy
{
    @Override
    public void move(String from, String to, String name, Consumer<String> output)
    {
        output.accept(name + " flies from " + from + " to " + to);
    }
}