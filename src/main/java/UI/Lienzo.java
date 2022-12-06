/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author raulv
 */
public class Lienzo extends JPanel
{
    private BufferedImage imagen = null;
    private BufferedImage logo = null;
    private int xLogo;
    private int yLogo;

    public Lienzo() {
        try {
            imagen = ImageIO.read(new File("..\\src\\imagenes\\imagen.jpg"));
            logo = ImageIO.read(new File("..\\src\\imagenes\\logo.png"));
            this.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, null);
        g.drawImage(logo, xLogo, yLogo, null);
    }

    public void setFilters(boolean redButton, boolean greenButton, boolean blueButton) {
        try {
            imagen = ImageIO.read(new File("src\\imagenes\\imagen.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagen = UtilsPractica5.seleccionarComponentes(imagen, redButton, greenButton, blueButton);
        this.paintComponent(this.getGraphics());
    }

    void moveLogo(int x, int y) {
        this.xLogo = x;
        this.yLogo = y;
        this.paintComponent(this.getGraphics());
    }
    
    public Dimension getImageDimensions(){
        Dimension dimensionImagen = new Dimension();
        dimensionImagen.height = this.imagen.getHeight();
        dimensionImagen.width = this.imagen.getWidth();
        return dimensionImagen;
    }
    
    public Dimension getLogoDimensions(){
        Dimension dimensionLogo = new Dimension();
        dimensionLogo.height = this.logo.getHeight();
        dimensionLogo.width = this.logo.getWidth();
        return dimensionLogo;
    }
}
