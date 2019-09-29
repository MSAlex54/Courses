package Java0.Lesson_6;

import java.awt.*;

public class VerticalLayout implements LayoutManager {

    private Dimension size = new Dimension();

    @Override
    public void addLayoutComponent(String name, Component comp) {}

    @Override
    public void removeLayoutComponent(Component comp) {}

    @Override
    public Dimension preferredLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    @Override
    public Dimension minimumLayoutSize(Container c) {
        return calculateBestSize(c);
    }

    @Override
    public void layoutContainer(Container c) {
        // Список компонентов
        Component list[] = c.getComponents();
        int currentY = 5;
        for (int i = 0; i < list.length; i++) {
            // Определение предпочтительного размера компонента
            Dimension pref = list[i].getPreferredSize();
            // Размещение компонента на экране
            list[i].setBounds(5, currentY, pref.width, pref.height);
            // Учитываем промежуток в 5 пикселов
            currentY += 5;
            // Смещаем вертикальную позицию компонента
            currentY += pref.height;
        }
    }

    private Dimension calculateBestSize(Container c) {
        // Вычисление длины контейнера
        Component[] list = c.getComponents();
        int maxWidth = 0 ;
        for ( int i = 0 ; i < list.length; i++) {
            int width = list[i].getWidth();
            // Поиск компонента с максимальной длиной
            if ( width > maxWidth )
                maxWidth = width;
        }
        // Размер контейнера в длину с учетом левого отступа
        size.width = maxWidth + 5 ;
        // Вычисление высоты контейнера
        int height = 0 ;
        for ( int i = 0 ; i < list.length; i++) {
            height += 5 ;
            height += list[i].getHeight();
        }
        size.height = height;
        return size;
    }
}
