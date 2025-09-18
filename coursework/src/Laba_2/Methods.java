package Laba_2;

import java.util.function.Consumer;

public class Methods 
{
    private Consumer<String> output;

    public Methods(Consumer<String> output) 
    {
        this.output = output;
    }

    public Methods() 
    {
        this.output = System.out::println;
    }

    private void print(String text) 
    {
        if (output != null) 
        {
            output.accept(text);
        }
    }

    //----------------------------------------------------------------------------------

    @Repeat(2)
    public void publicMethodOne() 
    {
        print("Called publicMethodOne()");
    }

    public void publicMethodTwo(String name)
    {
        print("Called publicMethodTwo() with parameters: " + name);
    }

    public int publicMethodThree(int a, int b) 
    {
        print("Called publicMethodThree() -> " + (a + b));
        return a + b;
    }

    //----------------------------------------------------------------------------------

    @Repeat(3)
    protected void protectedMethodOne(int x) 
    {
        print("protectedMethodOne() -> x = " + x);
    }

    protected String protectedMethodTwo(String text) 
    {
        print("protectedMethodTwo() -> text = " + text);
        return "protectedMethodTwo: " + text;
    }

    @Repeat(1)
    protected void protectedMethodThree() 
    {
        print("protectedMethodThree() without parameters");
    }

    //----------------------------------------------------------------------------------
    
    @Repeat(2)
    private void privateMethodOne(String msg, int count) 
    {
        print("privateMethodOne() -> msg=" + msg + ", count=" + count);
    }

    private int privateMethodTwo() 
    {
        print("privateMethodTwo() -> 42");
        return 42;
    }

    @Repeat(4)
    private void privateMethodThree() 
    {
        print("privateMethodThree() complete");
    }
}
