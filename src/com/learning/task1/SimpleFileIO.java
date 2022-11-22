package com.learning.task1;

import com.learning.IOTask;

import java.io.*;

public class SimpleFileIO implements IOTask<String> {


    @Override
    public void input(String fileName) throws FileNotFoundException {
        //TODO Загрузить содержимое текстового файла с помощью FileReader и BufferedReader
        //TODO Вывести на экран загруженные данные
    }

    @Override
    public void output(String data) {
        //TODO сохранить данные в новый файл с помощью FileWriter и BufferedWriter
    }
}
