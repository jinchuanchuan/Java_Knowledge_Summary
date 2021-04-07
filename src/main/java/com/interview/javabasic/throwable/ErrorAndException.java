package com.interview.javabasic.throwable;

import java.io.FileNotFoundException;

/**
 * Description:
 */
public class ErrorAndException {
    private void throwError() {
        throw new StackOverflowError();
    }

    private void throwRuntimeException() {
        throw new RuntimeException();
    }

    private void throwCkeckedExceptoin() {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void throwsCkeckedExceptoin() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main(String[] args) {
        ErrorAndException eae = new ErrorAndException();
        try {
            eae.throwError();
        } finally {
            System.out.println("finally");
        }
        eae.throwRuntimeException();
        eae.throwRuntimeException();
        try {
            eae.throwsCkeckedExceptoin();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}