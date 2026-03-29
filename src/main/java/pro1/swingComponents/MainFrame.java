package pro1.swingComponents;

import pro1.drawingModel.*;
import pro1.drawingModel.Rectangle;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private DisplayPanel displayPanel;
    private List<Circle> circles = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    private int currentRadius = 20;
    private boolean hideLines = false;

    public MainFrame() {
        setTitle("PRO1 Drawing");
        /*setVisible(true);
        setSize(800, 800);*/
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        displayPanel = new DisplayPanel();
        add(displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(
                new Dimension(200, 0));
        add(leftPanel, BorderLayout.WEST);

      leftPanel.add(new JLabel("poloměr"));
      JSlider radiusSlider = new JSlider(5, 100, currentRadius);

      radiusSlider.addChangeListener( e -> {
          currentRadius = radiusSlider.getValue();
          for (Circle c : circles) c.setRadius(currentRadius);
          updateDisplay();

      });
        leftPanel.add(radiusSlider);

        JCheckBox hideCheck = new JCheckBox("Skrýt úsečky");

        hideCheck.addActionListener(e -> {
            hideLines = hideCheck.isSelected();
            updateDisplay();
        });
        leftPanel.add(hideCheck);

        JButton resetBtn = new JButton("Reset");

        resetBtn.addActionListener(e -> {
            circles.clear();
            lines.clear();
            updateDisplay();
        });
        leftPanel.add(resetBtn);



        displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                Circle newCircle = new Circle(e.getX(), e.getY(), currentRadius);


                for (Circle existing : circles) {
                    lines.add(new Line(newCircle, existing));
                }

                circles.add(newCircle);
                updateDisplay();
            }
        });

        setVisible(true);
            }


    private void updateDisplay() {

        List<Drawable> allItems = new ArrayList<>();
        if (!hideLines) {
            allItems.addAll(lines);
        }
        allItems.addAll(circles);


        Drawable[] drawables = allItems.toArray(new Drawable[0]);
        displayPanel.setDrawable(new Group(drawables, 0, 0, 0, 1, 1));
    }
}