import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Задача:
//        На лекции был написан фрейм, содержащий одну кнопку – начать игру и расположением самого окна настроек автоматически,
//        относительно игрового окна.
//        Добавить на экран компоновщик-сетку с одним столбцом и добавить над существующей кнопкой следующие компоненты в заданном порядке:
//        JLabel с заголовком «Выберите режим игры»,
//        сгруппированные в ButtonGroup переключаемые JRadioButton с указанием режимов
//        «Человек против компьютера» и «Человек против человека», JLabel с заголовком «Выберите размеры поля»,
//        JLabel с заголовком «Установленный размер поля:»,
//        JSlider со значениями 3..10,
//        JLabel с заголовком «Выберите длину для победы»,
//        JLabel с заголовком «Установленная длина:»,
//        JSlider со значениями 3..10.

public class SettingWindow extends JFrame {
    private static final int WIDTH = 230;
    private static final int HEIGHT = 350;
    String currentWinValue = "Установленная длина: ";
    String currentFieldValue = "Установленный размер поля: ";
    JRadioButton hUman;
    JRadioButton aI;
    ButtonGroup buttonGroup;
    JLabel choiceHA;
    JButton btnStart;
    JPanel mainPanel;
    JLabel fieldSize;
    JLabel currentFieldSize;
    JSlider sliderFieldSize;
    JLabel winSize;
    JLabel currentWinSize;
    JSlider sliderWinSize;

    final int minSize = 3;




    SettingWindow(GameWindow gameWindow){
        hUman = new JRadioButton("Человек против Человека");
        aI = new JRadioButton("Робот против Человека");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(aI);
        buttonGroup.add(hUman);
        btnStart = new JButton("Start new game");
        mainPanel = new JPanel(new GridLayout(9, 1));
        fieldSize = new JLabel("Выберите размер поля");
        choiceHA = new JLabel("Выберите режим игры");
        currentFieldSize = new JLabel(currentFieldValue + minSize);
        sliderFieldSize = new JSlider(minSize, 10, minSize);
        currentFieldSize = new JLabel("Установленная длина");
        currentWinSize = new JLabel(currentWinValue + minSize);
        winSize = new JLabel("Выберите длину для победы: " );
        sliderWinSize = new JSlider(minSize, 10, minSize);
        mainPanel.add(choiceHA);
        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gameWindow.startNewGame(0, 3, 3, 3);
            }
        });
        sliderWinSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentWinSize.setText(currentWinValue + sliderWinSize.getValue());
            }
        });

        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentFieldSize.setText(currentFieldValue + sliderFieldSize.getValue());
            }
        });



        mainPanel.add(aI);
        aI.setSelected(true);
        mainPanel.add(hUman);
        mainPanel.add(fieldSize);
        mainPanel.add(currentFieldSize);
        mainPanel.add(sliderFieldSize);
        mainPanel.add(winSize);
        mainPanel.add(currentWinSize);
        mainPanel.add(sliderWinSize);
        add(mainPanel);
        add(btnStart,BorderLayout.SOUTH);
    }
}