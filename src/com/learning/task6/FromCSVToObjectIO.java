package com.learning.task6;

import com.learning.IOTask;
import com.learning.task5.Mob;

import java.io.IOException;

public class FromCSVToObjectIO implements IOTask<Mob> {
    @Override
    public void input(String fileName) throws IOException {
        /*
            TODO загрузить и разбить на массив строк содержимое CSV файла с данными объектов класса Mob
            TODO на основе полученных данных создать объект класса.
            //Для разбиения полученной строки на массив строк, можно использовать метод .split(";");
            //Для преобразования строки в формат int можно использовать статический метод класса Integer.parseInt();
            //int number = Integer.parseInt("10");
        */
    }

    @Override
    public void output(Mob data) throws IOException {
        //TODO сохранить данные из класса Mob в файл CSV, разделяя значения точкой с запятой (;)
    }
}
