package com.learning.task3;

import com.learning.IOTask;

import java.io.IOException;
import java.io.OutputStream;

public class LowLevelFileIO implements IOTask<String> {
    @Override
    public void input(String fileName) throws IOException {
        //TODO без использования обёрток загрузить содержимое файла в программу при помощи InputStream или FileInputStream
        //То есть, используя цикл заполнения массива байт
    }

    @Override
    public void output(String data) throws IOException {
        //TODO без использования обёрток записать в файл содержимое выходной строки при помощи OutputStream или FileOutputStream
    }
}
