package sub;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class GUI extends JFrame {


    public GUI() {
        Calc calc = new Calc();
        Excel excel = new Excel();

        JFrame jFrame = new JFrame("Excel");
        jFrame.setBounds(100,100,300, 150);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = jFrame.getContentPane();
        contentPane.setLayout(null);
        JButton buttonImport = new JButton("Импорт");
        buttonImport.setBounds(20,20,100,25);
        JButton buttonExport = new JButton("Экспорт");
        buttonExport.setBounds(20,65,100,25);
        JLabel inputImport = new JLabel("Путь к файлу");
        inputImport.setBounds(140,20,300,25);
        JLabel inputExport = new JLabel("Путь к файлу");
        inputExport.setBounds(140,65,300,25);
        jFrame.add(buttonExport);
        jFrame.add(buttonImport);
        jFrame.add(inputImport);
        jFrame.add(inputExport);
        jFrame.setVisible(true);


        buttonImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser("C:\\Users\\Lenovo\\Desktop");
                    int ret = fileChooser.showOpenDialog(GUI.this);
                    if (ret == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        excel.Import(file.getAbsolutePath());
                        inputImport.setText(file.getAbsolutePath());
                        JOptionPane.showMessageDialog(null, "Данные импортированы в файл", "Import", JOptionPane.PLAIN_MESSAGE);
                    }


                } catch (HeadlessException headlessException) {
                    JOptionPane.showMessageDialog(null, "Не найдено", "Error", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });

        buttonExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser fileChooser = new JFileChooser("C:\\Users\\Lenovo\\Desktop");
                            int ret = fileChooser.showSaveDialog(GUI.this);
                            if (ret == JFileChooser.APPROVE_OPTION) {
                                File file = fileChooser.getSelectedFile();
                                calc.calc(excel);
                                excel.Export(file.getAbsolutePath(), calc.getHashMap());
                                inputExport.setText(file.getAbsolutePath());
                                JOptionPane.showMessageDialog(null, "Данные экспортированы в файл", "Export", JOptionPane.PLAIN_MESSAGE);
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Не найдено", "Error", JOptionPane.PLAIN_MESSAGE);
                        }

                    }
        });


    }
    public static void main(String[] args) {

        new GUI();

    }
}
