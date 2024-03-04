import LibClass.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


public class Main {

    Main() {
        ArrayList<Student> students = new ArrayList<Student>();
        final ListOfStudents[] listOfStudents = new ListOfStudents[1];
        RepositoryClass repositoryClass = new RepositoryClass();

        JFrame frame = new JFrame("Графическое окно");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        DefaultListModel<String> list = new DefaultListModel<>();

        JLabel label = new JLabel("Students");
        label.setBounds(10, 60, 250, 30);
        frame.add(label, BorderLayout.WEST);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 100, 250, 200);
        frame.add(textArea, BorderLayout.WEST);

        JButton button1 = new JButton("Добавить");
        button1.setBounds(300, 100, 120, 30);
        frame.add(button1, BorderLayout.EAST);

        JButton button2 = new JButton("Отобразить");
        button2.setBounds(300, 130, 120, 30);
        frame.add(button2);

        JButton button3 = new JButton("Удалить");
        button3.setBounds(300, 160, 120, 30);
        frame.add(button3);

        //вызов окна добавления студента
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addFrame = new JFrame("Окно добавления студента");

                //форма для ввода имени
                JLabel nameLabel = new JLabel("Имя");
                nameLabel.setBounds(10, 10, 100, 30);
                addFrame.add(nameLabel);

                JTextField nameTextField = new JTextField();
                nameTextField.setBounds(10, 40, 100, 30);
                addFrame.add(nameTextField);

                //форма для ввода образования
                JLabel educationLabel = new JLabel("Образование");
                educationLabel.setBounds(10, 65, 100, 30);
                addFrame.add(educationLabel);

                JTextField educationTextField = new JTextField();
                educationTextField.setBounds(10, 100, 100, 30);
                addFrame.add(educationTextField);

                //форма для ввода оценки
                JLabel markLabel = new JLabel("Оценка");
                markLabel.setBounds(10, 135, 100, 30);
                addFrame.add(markLabel);

                JTextField markTextField = new JTextField();
                markTextField.setBounds(10, 165, 100, 30);
                addFrame.add(markTextField);

                JButton addButton = new JButton("Добавить");
                addButton.setBounds(10, 220, 90, 30);
                addFrame.add(addButton);
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FormOfEducation education;
                        switch (educationTextField.getText().toLowerCase()) {
                            case "budget":
                                education = FormOfEducation.Budget;
                                break;
                            default:
                                education = FormOfEducation.Paid;
                                break;
                        }
                        students.add(new Student(nameTextField.getText(), education, Float.parseFloat(markTextField.getText())));
                    }
                });

                // submit button
                JButton submitButton = new JButton("Подтвердить");
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        listOfStudents[0] = new ListOfStudents(students);
                        addFrame.dispose();
                    }
                });
                submitButton.setBounds(10, 250, 100, 30);
                addFrame.add(submitButton);

                //инициалищация окна
                addFrame.setSize(200, 400);
                addFrame.setLayout(null);
                addFrame.setVisible(true);

            }
        });

        // вызов окна для удаления студента
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame deleteFrame = new JFrame("Окно удаления");

                JLabel deleteLabel = new JLabel("Введите номер студента");
                deleteLabel.setBounds(10, 30, 150, 30);
                deleteFrame.add(deleteLabel);

                JTextField deleteTextField = new JTextField();
                deleteTextField.setBounds(10, 60, 80, 30);
                deleteFrame.add(deleteTextField);

                JButton submitButton = new JButton("Подтвердить");
                submitButton.setBounds(10, 200, 120, 30);
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        repositoryClass.DeleteStudent(students, Integer.parseInt(deleteTextField.getText()));
                        deleteFrame.dispose();
                    }
                });
                deleteFrame.add(submitButton);

                deleteFrame.setSize(200, 300);
                deleteFrame.setLayout(null);
                deleteFrame.setVisible(true);
            }
        });


        //вызов окна со списком студентов
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for(Student student : students)
                {
                    textArea.append("\nИмя: " + student.GetName() + "\nОбразование: " + student.GetFormOfEducation() + "\nОценка: " + student.GetMark());
                }

            }
        });



        frame.setSize(500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Main main = new Main();
    }
}
