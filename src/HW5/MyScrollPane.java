package HW5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MyScrollPane extends JPanel implements ComponentListener {
    private final JPanel panel;
    private final JPanel contentPanel;
    private final JScrollBar horizontalScrollBar;
    private final JScrollBar verScrollBar;

    public MyScrollPane(JPanel contentPanel) {
        this.contentPanel = contentPanel;
        System.out.println(contentPanel.getPreferredSize());
        setLayout(new BorderLayout());
        panel = new JPanel();

        horizontalScrollBar = new JScrollBar(Adjustable.HORIZONTAL);
        horizontalScrollBar.addAdjustmentListener(e -> {
            contentPanel.setLocation(-e.getValue(), contentPanel.getY());
            panel.repaint();
        });

        verScrollBar = new JScrollBar(Adjustable.VERTICAL);
        verScrollBar.addAdjustmentListener(e -> {
            contentPanel.setLocation(contentPanel.getX(), -e.getValue());
            panel.repaint();
        });
        panel.setLayout(null);
        panel.add(contentPanel);
        add(panel, BorderLayout.CENTER);
        add(horizontalScrollBar, BorderLayout.SOUTH);
        add(verScrollBar, BorderLayout.WEST);
        addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        setContentPanelSize();

        verScrollBar.setMaximum((int) contentPanel.getSize().getHeight() - panel.getHeight() + horizontalScrollBar.getSize().height);
        horizontalScrollBar.setMaximum((int) contentPanel.getSize().getWidth() - panel.getWidth() + verScrollBar.getSize().width);

        horizontalScrollBar.setVisible(panel.getWidth() < contentPanel.getPreferredSize().getWidth());
        verScrollBar.setVisible(panel.getHeight() < contentPanel.getPreferredSize().getHeight());

        repaint();
    }

    private void setContentPanelSize() {
        int width = (int) contentPanel.getPreferredSize().getWidth();
        int height = (int) contentPanel.getPreferredSize().getHeight();

        if(width < panel.getSize().width)
            width = panel.getSize().width;
        if(height < panel.getSize().height)
            height = panel.getSize().height;
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
