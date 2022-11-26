
package com.mycompany.qlbatdongsan.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author HO VAN DAT
 */
public class PanelRound extends JPanel{
    private  int roundTopLeft = 0;
    int roundTopRight = 0;
    int RoundBottonLeft = 0;
    int RoundBottonRight = 0;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }

    public int getRoundBottonLeft() {
        return RoundBottonLeft;
    }

    public void setRoundBottonLeft(int RoundBottonLeft) {
        this.RoundBottonLeft = RoundBottonLeft;
        repaint();
    }

    public int getRoundBottonRight() {
        return RoundBottonRight;
    }

    public void setRoundBottonRight(int RounfBottonRight) {
        this.RoundBottonRight = RounfBottonRight;
        repaint();
    }
    public PanelRound() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight>0) {
            area.intersect(new Area(createRoundTopRight()));
        }
         if (RoundBottonLeft>0) {
            area.intersect(new Area(createRoundBottonLeft()));
        }
          if (RoundBottonRight>0) {
            area.intersect(new Area(createRoundBottonRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }
    private  Shape createRoundTopRight(){
        int width= getWidth();
        int height= getHeight();
        int roundX= Math.min(width, roundTopRight);
        int roundy= Math.min(height, roundTopRight);
        Area area= new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundy));
        area.add(new Area(new Rectangle2D.Double(0, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundy/2, width, height-roundy/2)));
        
        return area;
        
    }
    private  Shape createRoundTopLeft(){
        int width= getWidth();
        int height= getHeight();
        int roundX= Math.min(width, roundTopLeft);
        int roundy= Math.min(height, roundTopLeft);
        Area area= new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundy));
        area.add(new Area(new Rectangle2D.Double(roundX/2, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundy/2, width, height-roundy/2)));
        
        return area;
        
    }
    private  Shape createRoundBottonLeft(){
        int width= getWidth();
        int height= getHeight();
        int roundX= Math.min(width, RoundBottonLeft);
        int roundy= Math.min(height, RoundBottonLeft);
        Area area= new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundy));
        area.add(new Area(new Rectangle2D.Double(roundX/2, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height-roundy/2)));
        
        return area;
        
    }
     private  Shape createRoundBottonRight(){
        int width= getWidth();
        int height= getHeight();
        int roundX= Math.min(width, RoundBottonRight);
        int roundy= Math.min(height, RoundBottonRight);
        Area area= new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundy));
        area.add(new Area(new Rectangle2D.Double(0, 0, width-roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height-roundy/2)));
        
        return area;
        
    }
    
}
