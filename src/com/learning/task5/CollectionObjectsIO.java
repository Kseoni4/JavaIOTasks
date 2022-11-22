package com.learning.task5;

import com.learning.IOTask;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CollectionObjectsIO implements IOTask<ArrayList<Mob>> {
    @Override
    public void input(String fileName) throws IOException {
        //TODO проверить гипотезу: дочерний класс наследует от родительского реализацию Serializable
        //TODO загрузить из файла коллекцию объектов класса Mob.
    }

    @Override
    public void output(ArrayList<Mob> data) throws IOException {
        //TODO сохранить в файл коллекцию объектов класса Mob
    }
}
