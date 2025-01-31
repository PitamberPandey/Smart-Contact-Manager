package com.src.Helper;

public class ResourceFoundException extends RuntimeException {
    public ResourceFoundException(String message){
        super(message);
    }
    public ResourceFoundException(){
        super("Resource not found");
    }

}
