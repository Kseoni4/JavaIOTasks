package com.learning.task4;

import com.learning.IOTask;

import java.io.IOException;

public class ObjectFileIO implements IOTask<Cat> {
    @Override
    public void input(String fileName) throws IOException {
        //TODO прописать в Cat и VetBook implements Serializable
        //TODO из файла .cat загрузить (десериализовать) объект класса Cat в программу
    }

    @Override
    public void output(Cat data) throws IOException {
        //TODO записать (сериализовать) объект класса Cat в файл с расширением .cat
    }
}
