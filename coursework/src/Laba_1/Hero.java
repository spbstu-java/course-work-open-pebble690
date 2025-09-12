package Laba_1;

import java.util.function.Consumer;

public class Hero
{
    private String name;
    private Strategy strategy;

    public Hero(String name)
    {
        this.name = name;
    }

    public void setStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public void move(String from, String to, Consumer<String> output)
    {
        if (strategy == null)
        {
            output.accept("Error: No movement strategy selected!");
            return;
        }

        strategy.move(from, to, name, output);
    }

    public void move(String from, String to)
    {
        move(from, to, System.out::println);
    }
}