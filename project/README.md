Учебный командный проект по Java: консольное приложение, которое сортирует массивы объектов `Car` с использованием паттернов **Strategy** и **Builder**. Пользователь выбирает способ заполнения массива (файл/рандом/вручную), длину массива и алгоритм сортировки. Программа работает в цикле до выбора пункта «Выход».

## Быстрый старт

```bash
mvn clean package
java -cp target/car-sorter-1.0-SNAPSHOT.jar com.yourteam.project.App


# Формат входного файла (CSV)
Каждая строка: `power,model,year`
Пример:
```
120, Civic, 2018
200, Corolla, 2019
150, Focus, 2015
```
```
# Структура проекта
src/main/java/com/yourteam/project/
├─ App.java
├─ model/Car.java
├─ strategy/SortStrategy.java
├─ strategy/InsertionSort.java
├─ strategy/SelectionSort.java
├─ strategy/QuickSort.java
├─ io/CarFileReader.java
├─ io/CarRandomGenerator.java
├─ io/CarManualInput.java
├─ util/CarComparator.java
└─ validation/CarValidator.java
```
```
## Роли и задачи 

### Садыков Фарух
- App.java (главное меню, цикл)
- README + согласование требований
- Финальный merge

### Кирилл Бабанин — сортировки (Strategy)
- Реализовать минимум **2–3 алгоритма** (Insertion/Selection/Quick).
- Все алгоритмы используют **CarComparator**, чтобы сортировка шла по 3 полям.
- Проверить корректность сортировки на тестовых данных.


### Алексей Пронченко — ввод/вывод
- Чтение из файла CSV.
- Генерация случайных данных.
- Ручной ввод с проверкой формата.

### Данил Кузьминых — модель и валидация
- Класс `Car` с Builder.
- Валидация полей (`power`, `model`, `year`).

