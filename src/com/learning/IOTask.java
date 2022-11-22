package com.learning;

import java.io.IOException;

public interface IOTask<T> {

    void input(String fileName) throws IOException;

    void output(T data) throws IOException;

}
