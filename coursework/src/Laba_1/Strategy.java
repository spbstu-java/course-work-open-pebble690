package Laba_1;

import java.util.function.Consumer;

public interface Strategy
{
    default void move(String from, String to, String name)
    {
        move(from, to, name, System.out::println);
    }

    void move(String from, String to, String name, Consumer<String> output);
}