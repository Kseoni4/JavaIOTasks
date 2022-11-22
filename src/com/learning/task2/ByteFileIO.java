package com.learning.task2;

import com.learning.IOTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileIO implements IOTask<String> {
    @Override
    public void input(String fileName) throws IOException {
        //TODO Прочитать содержимое текстового файла в виде набора байт с помощью FileInputStream и получить объект String
    }

    @Override
    public void output(String data) throws IOException {
        //TODO Перевести текстовые данные в массив байт и сохранить в файл с помощью FileOutputStream
    }
}
