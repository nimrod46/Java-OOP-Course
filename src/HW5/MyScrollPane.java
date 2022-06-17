package HW5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyScrollPane extends JPanel implements ComponentListener {
    private final JPanel panel;
    private final JPanel contentPanel;
    private final JScrollBar horizontalScrollBar;
    private final JScrollBar verticalScrollBar;

    public MyScrollPane(JPanel contentPanel) {
        this.contentPanel = contentPanel;
        setLayout(new BorderLayout());
        panel = new JPanel();

        horizontalScrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        horizontalScrollBar.addAdjustmentListener(e -> {
            contentPanel.setLocation(-e.getValue(), contentPanel.getY());
            panel.repaint();
        });

        verticalScrollBar = new JScrollBar(Adjustable.VERTICAL);
        verticalScrollBar.addAdjustmentListener(e -> {
            contentPanel.setLocation(contentPanel.getX(), -e.getValue());
            panel.repaint();
        });
        panel.setLayout(null);
        panel.add(contentPanel);
        add(panel, BorderLayout.CENTER);
        add(horizontalScrollBar, BorderLayout.SOUTH);
        add(verticalScrollBar, BorderLayout.WEST);
        addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        setContentPanelSize();

        verticalScrollBar.setMaximum((int) contentPanel.getSize().getHeight() - panel.getHeight() + horizontalScrollBar.getSize().height / 2);
        horizontalScrollBar.setMaximum((int) contentPanel.getSize().getWidth() - panel.getWidth() + verticalScrollBar.getSize().width / 2);

        horizontalScrollBar.setVisible(panel.getWidth() <= contentPanel.getPreferredSize().getWidth());
        verticalScrollBar.setVisible(panel.getHeight() <= contentPanel.getPreferredSize().getHeight());

        repaint();
    }

    private void setContentPanelSize() {
        int width = Math.max(contentPanel.getPreferredSize().width,  panel.getSize().width);
        int height = Math.max(contentPanel.getPreferredSize().height,  panel.getSize().height);
        contentPanel.setSize(new Dimension(width, height));
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
