package com.gql.exceptionhelper;

public class ExceptionHelper {

    public static RuntimeException usernotfound()
    {
        return new RuntimeException("User not found");
    }
}
