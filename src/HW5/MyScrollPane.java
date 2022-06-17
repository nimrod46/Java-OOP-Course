package HW5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyScrollPane extends JPanel implements ComponentListener {
    private JPanel panel;
    private JPanel mainPanel;
    JScrollBar horizontalScrollBar;
    JScrollBar verScrollBar;

    public MyScrollPane(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        System.out.println(mainPanel.getPreferredSize());
        setLayout(new BorderLayout());
        panel = new JPanel();

        horizontalScrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        horizontalScrollBar.addAdjustmentListener(e -> {
            mainPanel.setLocation(-e.getValue(), mainPanel.getY());
            System.out.println(mainPanel.getX());
            panel.repaint();
        });

        verScrollBar = new JScrollBar(Adjustable.VERTICAL);
        verScrollBar.addAdjustmentListener(e -> {
            mainPanel.setLocation(mainPanel.getX(), -e.getValue());
            System.out.println(mainPanel.getX());
            panel.repaint();
        });
        panel.setLayout(null);
        panel.add(mainPanel);
        addComponentListener(this);
        add(panel, BorderLayout.CENTER);
        add(horizontalScrollBar, BorderLayout.SOUTH);
        add(verScrollBar, BorderLayout.WEST);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        int height = (int) mainPanel.getPreferredSize().getHeight();
        int width = (int) mainPanel.getPreferredSize().getWidth();
        if(height < panel.getSize().height)
            height = panel.getSize().height;
        if(width < panel.getSize().width)
            width = panel.getSize().width;
        mainPanel.setSize(new Dimension(width, height));

        verScrollBar.setMaximum((int) mainPanel.getSize().getHeight() - panel.getHeight() + horizontalScrollBar.getSize().height);
        horizontalScrollBar.setMaximum((int) mainPanel.getSize().getWidth() - panel.getWidth() + verScrollBar.getSize().width);

        horizontalScrollBar.setVisible(panel.getWidth() < mainPanel.getPreferredSize().getWidth());
        verScrollBar.setVisible(panel.getHeight() < mainPanel.getPreferredSize().getHeight());

        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
