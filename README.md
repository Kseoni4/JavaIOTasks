# JavaIOTasks

Учебный проект для изучения Java I/O и закрепления навыков работы с ним. 
Подразумевает выполнение студентом указанных в коде задач в из ```//TODO``` описания.

## Список задач
1. Простая загрузка\сохранение файлов (```SimpleFileIO```)
2. Байтовая загрузка\сохранение файлов (```ByteFileIO```)
3. Низкоуровневая загрузка\сохранение файлов (```LowLevelFileIO```)
4. Сериализация\Десериализация объекта (```ObjectFileIO```)
5. Сериализация\Десериализация коллекции объектов (```CollectionObjectsIO```)
6. Простейший парсинг CSV файла и создание объекта (```FromCSVToObjectIO```)

## Как пользоваться проектом

Проект разбит на отдельные пакеты. В каждом пакете есть класс с заданием из списка выше. В каждом классе заготована реализация двух методов из интерфейса
```IOTask<T>```: ```input()``` и ```output()```
В каждом методе задание описано в виде ```//TODO``` комментария.

Для запуска задания, в классе ApplicationStart достаточно написать похожую структуру в точке входа:
```java

private static final String WAIFU_FILE = "waifu.txt";

public static void main(String[] args) throws IOException {
        IOTask<String> task1 = new SimpleFileIO();

        task1.input(WAIFU_FILE);

        String data = "Джотаро, ты любишь кабачки?!";

        task1.output(data);

    }
```

## Сериализация и десериализация

**Сериализацией** называется сохранение данных объектного типа во внеш-нюю памяти. Как правило в файл. Для того, чтобы осуществить сериализацию необходимо, чтобы в классе указывалась реализация интерфейса ```Serializable```. Сам интерфейс является просто «маркером», не имея в своём теле каких-либо методов.
Если в полях сериализуемого класса присутствуют объектные типы, то они так же должны поддерживать сериализацию и так далее по цепочке. В случае, если по какой-то причине поле класса не должно сохраняться, то оно помечается словом **transient**.

Рассмотрим пример сериализации данных:

``` java
public class Player implements Serializable {

        private String name = "PlayerOne";
        
        private int healthPoints;
        
        private int level;

        private int experiencePoints;

        private int money;

        private Position playerPosition;

        private transient Model playerModel;
	    
}
```

Класс игрока реализует интерфейс ```serializable```, то есть его данные можно перевести в байтовом представлении, например, в файл сохранения. В него войдут все поля и их значения на момент записи, кроме того, что было помечено словом «transient». Так как по логике хранить модель (если это сложная графика) игрока в сохранении уже излишне. Вместо этого после загрузки данных, этому полю присвоит необходимое значение уже внутри кода программы. 
**Десериализацией** называется загрузка данных в память программы. Разумеется, что структура сохранённого объекта должна целиком совпадать со структурой этого класса в программе. 

Рекомендуется, чтобы в сериализуемом классе использовалось следующее поле:

```java
static final long serialVersionUID;
```

В этом поле по-умолчанию находится некоторая контрольная сумма с ко-торой сравнивается загружаемые данные. Контрольная сумма высчитывается исходя из количества полей, методов и их расположения в классе. 
Если определить поле самостоятельно и указать значение, то при измене-нии структуры класса значение поля не изменится, что позволит избежать ос-новных проблем при десериализации.
Рассмотрим пример сериализации класса ```Player``` в файл и обратно:

```java
public void savePlayerDataToFile(Player player){
        File playerDataFile = new File(player.getName()+".data");

        try(FileOutputStream fileOutputStream = new FileOut-putStream(playerDataFile);
                ObjectOutputStream objectOutputStream = new ObjectOut-putStream(fileOutputStream)) {

                objectOutputStream.writeObject(player);

                objectOutputStream.flush();

                } catch (IOException e) {
                        e.printStackTrace();
                }
           }
```
В процессе сохранения мы воспользовались новым способом управления ресурсами – **try-with-resources**, который выглядит как немного улучшенный ```try-catch``: он так же поддерживает проверку и обработку исключений, но при этом самостоятельно освобождается ресурсы после выхода из блока try. Следует напомнить, что объявленные в скобках объекты ```fileOutputStream``` и ```objectOutputStream``` имеют область видимости только внутри блока try.
Класс ```File``` используется как программная абстракция файла во внешней памяти. Поскольку при создании экземпляра этого класса не происходит со-здание физического файла, для этого требуется воспользоваться типом ```FileOutputStream``` и его методами ```write()``` и ```flush()```.
Если в названии файла не указывать путь, то по умолчанию создание произойдёт в том же каталоге, где находится программа. 

Для сохранения объектного типа данных в файл, требуется использования специального класса ObjectOutputStream, инкапсулирующий поток вывода объекта. Полученный файл будет содержать исключительно байтовое наполнение. Более того, начальной сигнатурой  будет всегда будет HEX последовательность байт «aced».
Итак, после вызова метода ```flush()``` структура и содержимое объекта player будут сохранены в файл вида «имя_игрока.data».

Как будет выглядеть десериализация:

public Player getPlayerDataFromFile(String fileName) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(fileName);    
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                  return (Player) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return new Player();
                }
}



