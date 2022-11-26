/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlbatdongsan.utils;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author HO VAN DAT
 */
public class ImageAvatar extends JComponent{
    private Icon icon;

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }
    private  int  borderSize;
    @Override
    protected void paintComponent(Graphics grphcs) {
        if (icon!=null) {
            int width = getWidth();
            int height = getHeight();
            int diameter = Math.min(width, height);
            int x =  width/2 - diameter/2;
            int y = height/2 - diameter/2;
            int border = borderSize*2;
            diameter-=border; 
            Dimension size = getAutoSize(icon, diameter);
            BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2_img = img.createGraphics();
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_img.fillOval(0, 0, diameter, diameter);
            Composite composite = g2_img.getComposite();
            g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(ToImage(icon),0,0, size.width,size.height,null);
            g2_img.setComposite(composite);
            g2_img.dispose();
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (borderSize >0) {
                diameter+= border;
                g2.setColor(getForeground());
                g2.fillOval(x, y, diameter, diameter);
            }
            if (isOpaque()) {
                g2.setColor(getBackground());
                diameter-=border;
                g2.fillOval(x+borderSize, y+border, diameter, diameter);
            }
            g2.drawImage(img, x+borderSize, y=borderSize,null);
        }
        super.paintComponent(grphcs); 
    }
    
    private Image ToImage(Icon icon ) {
        return ((ImageIcon)icon).getImage();
    }
    private  Dimension getAutoSize(Icon image, int size){
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double)w/iw;
        double yScale = (double)h/ih;
        double scale = Math.max(yScale, yScale);
        int width = (int) (scale *iw);
        int height = (int)(scale*ih);
        if (width<1) {
            width=1;
        }
        if (height<1) {
            height=1;
        }
        return new Dimension(width, height);
    }
}
