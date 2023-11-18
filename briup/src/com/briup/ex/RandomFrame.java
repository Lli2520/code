package com.briup.ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomFrame extends JFrame {
    List<Student> list = null;
    Random r = new Random();

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sxx\\IdeaProjects\\bttc-java-basic-code\\01code\\src\\com\\briup\\ex\\stu.txt"));) {
            list = br.lines()
                    .map(i -> i.split("[-]"))
                    .map(i -> new Student(i[0], i[1], i[2]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
        }

    }

    public void addContainer() {
        BorderLayout layout = new BorderLayout();
        JPanel panel = new JPanel(layout);
        panel.setBackground(new Color(133, 192, 33));
        this.add(panel);
        JButton button = new JButton("开始点名");

        button.setFont(new Font("宋体", Font.BOLD, 30));
        TextArea area = new TextArea("");
        area.setEditable(false);
        area.setFocusable(false);
        area.setBackground(Color.green);
        area.setFont(new Font("黑体", Font.BOLD, 40));
        button.setSize(300, 100);
        panel.add(button, BorderLayout.NORTH);
        panel.add(area, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton sourceBtn = (JButton) e.getSource();
                sourceBtn.setText("点名中...");
                sourceBtn.setEnabled(false);
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 50; i++) {
                            Student student = list.get(r.nextInt(list.size()));
                            area.setText(student.toString());
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        sourceBtn.setText("开始点名");
                        sourceBtn.setEnabled(true);
                    }
                }.start();


            }
        });
    }

    public RandomFrame(String title) throws HeadlessException {
        super(title);
        readFile();
        addContainer();
    }

    public static void main(String[] args) {
        RandomFrame frame = new RandomFrame("点名器");
        frame.setSize(400, 600);
        frame.setLocation((1920 - 400) / 2, (1080 - 600) / 2);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
