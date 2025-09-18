package Laba_2;

import java.lang.reflect.*;
import java.util.function.Consumer;

public class Invoker 
{
    public void invokeAnnotatedMethods(Object target, Consumer<String> output)
    {
        Class<?> targetClass = target.getClass();

        for (Method method : targetClass.getDeclaredMethods()) 
        {
            if (method.isAnnotationPresent(Repeat.class)) 
            {
                int modifiers = method.getModifiers();

                if (Modifier.isProtected(modifiers) || Modifier.isPrivate(modifiers)) 
                {
                    Repeat annotation = method.getAnnotation(Repeat.class);
                    int times = annotation.value();

                    method.setAccessible(true);

                    for (int i = 0; i < times; i++) 
                    {
                        try 
                        {
                            Object[] params = buildDefaultArguments(method.getParameterTypes());
                            Object result = method.invoke(target, params);

                            if (method.getReturnType() != void.class) 
                            {
                                output.accept("Вызван метод: " + method.getName());
                            }
                        } 
                        catch (Exception e) 
                        {
                            output.accept("Ошибка при вызове метода: " + method.getName() + " -> " + e.getMessage());
                        }
                    }
                }
            }
        }
    }

    private Object[] buildDefaultArguments(Class<?>[] types) 
    {
        Object[] args = new Object[types.length];

        for (int i = 0; i < types.length; i++) 
        {
            if (types[i] == int.class) 
            {
                args[i] = 0;
            } 
            else if (types[i] == boolean.class)
            {
                args[i] = false;
            } 
            else if (types[i] == double.class)
            {
                args[i] = 0.0;
            } 
            else 
            {
                args[i] = null;
            }
        }
        
        return args;
    }
}