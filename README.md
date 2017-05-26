# Simple tetris game
Swing, AWT, MVC

## Swing docs
http://www.skipy.ru/technics/gui_int.html
http://www.skipy.ru/philosophy/visualDesigners.html
http://www.skipy.ru/technics/gui_sync.html Синхронизация пользовательского интерфейса
http://docs.oracle.com/javase/tutorial/2d/basic2d/index.html
http://docs.oracle.com/javase/tutorial/uiswing/painting/index.html
http://www.oracle.com/technetwork/java/painting-140037.html
https://stackoverflow.com/questions/13453331/repaint-in-java-doesnt-re-paint-immediately
http://stackoverflow.com/questions/13750659/in-java-how-do-i-repaint-a-panel-from-an-actionperformed-thread-while-it-is-curr
## Principle of operation
В Swing каждый компонент отрисовывает сам себя в методе paintComponent(Graphics g).
То-есть при вызове метода repaint() вызовется этот метод, в котором сказано только про нарисованную линию - то, что в методе main нигде не сохранится.
Если вы хотите рисовать на компоненте, храните то, что хотите нарисовать в переменной и передавайте в метод paintComponent()

```java
public class CustomPanel extends JPanel {
     protected void paintComponent(Graphics g) {
            super.paintComponent(g); // рисуем панель
            // Рисуем все что душе угодно
     }
}
```

0. Рефакторинг (todo и убрать sout-ы)
mvc. view singleton, model сидит в view. доступ к model получаем через view??
0. установить паузу когда нажимается на меню.
1. добавить функционал меню изменить уровень.
7. добавить уровни, и ускорение на каждом уровне.
0. добавить надпись game over.
2. убрать нижнюю всегда заполненную строку
4. сделать показ очков
6. добавить показ, какая фигура следующая появится.
7. сделать rotate не 4 на 4 а для маленьких фигур матрицы меньшего размера.
8. юнит тесты
9. переписать на javafx, spring
10. сохранение результатов игры в файл.
12. по кнопке Q добавить вопрос выйти, если да, то закрыть окно игры.
13. опптимизация isTouchGround() для оптимизации проверять только когда фигура уже ниже максимальной по высоте занятой ячейки в шахте