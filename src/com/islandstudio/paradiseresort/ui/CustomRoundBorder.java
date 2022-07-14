package com.islandstudio.paradiseresort.ui;

import java.awt.*;

public class CustomRoundBorder implements javax.swing.border.Border {
    /* This class is mainly used for create custom rounded border */

    private final int borderRadius;

    public CustomRoundBorder(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.drawRoundRect(x, y, width - 1, height - 1, borderRadius, borderRadius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(borderRadius, borderRadius, borderRadius, borderRadius );
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
