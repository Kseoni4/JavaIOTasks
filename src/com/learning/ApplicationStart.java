package com.learning;
import com.learning.task1.SimpleFileIO;

import java.io.IOException;
public class ApplicationStart {

    /**
     * Константы с ссылками на файлы
     * Можно использовать для метода input
     * Например, task1.input(WAIFU_FILE);
     */

    private static final String WAIFU_FILE = "waifu.txt";

    private static final String LOREM_IPSUM_FILE = "loremipsum.txt";

    private static final String CAT_FILE = "mark.cat";

    private static final String MOBS_FILE = "mobs.data";

    private static final String MOB_CSV_FILE = "mobinfo.csv";

    private static final String MOBS_CSV_FILE = "mobsinfo.csv";

    public static void main(String[] args) throws IOException {

        //Пример запуска задания
        //В качестве типа используется интерфейс IOTask<T>, где T - тип данных, который будет использовываться на вывод
        //В конструкторе вызывается соответствующая реализация интерфейса, например класс SimpleFileIO

       /*
        IOTask<String> task1 = new SimpleFileIO();

        task1.input(WAIFU_FILE);
        IOTask<Cat> task = new ObjectFileIO();

        String data = "Джотаро, ты любишь кабачки?!";
        task.input(CAT_FILE);

        task1.output(data);

        */

    }

}
