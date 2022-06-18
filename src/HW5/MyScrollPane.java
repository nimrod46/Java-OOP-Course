package HW5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyScrollPane extends JPanel implements ComponentListener {
    private final JPanel panel;
    private final JComponent content;
    private final JScrollBar horizontalScrollBar;
    private final JScrollBar verticalScrollBar;

    public MyScrollPane(JComponent content) {
        this.content = content;
        setLayout(new BorderLayout());
        panel = new JPanel();

        horizontalScrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        horizontalScrollBar.addAdjustmentListener(e -> {
            content.setLocation(-e.getValue(), content.getY());
            panel.repaint();
        });

        verticalScrollBar = new JScrollBar(Adjustable.VERTICAL);
        verticalScrollBar.addAdjustmentListener(e -> {
            content.setLocation(content.getX(), -e.getValue());
            panel.repaint();
        });
        panel.setLayout(null);
        panel.add(content);
        add(panel, BorderLayout.CENTER);
        add(horizontalScrollBar, BorderLayout.SOUTH);
        add(verticalScrollBar, BorderLayout.WEST);
        addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        setContentPanelSize();

        verticalScrollBar.setMaximum((int) content.getSize().getHeight() - panel.getHeight() + horizontalScrollBar.getSize().height / 2);
        horizontalScrollBar.setMaximum((int) content.getSize().getWidth() - panel.getWidth() + verticalScrollBar.getSize().width / 2);

        horizontalScrollBar.setVisible(panel.getWidth() <= content.getPreferredSize().getWidth());
        verticalScrollBar.setVisible(panel.getHeight() <= content.getPreferredSize().getHeight());

        repaint();
    }

    private void setContentPanelSize() {
        int width = Math.max(content.getPreferredSize().width,  panel.getSize().width);
        int height = Math.max(content.getPreferredSize().height,  panel.getSize().height);
        content.setSize(new Dimension(width, height));
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
