package com.io.tmall_springboot.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    public static BufferedImage change2jpg(File f){
        try{
            Image i =Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
            PixelGrabber pg = new PixelGrabber(i,0,0,-1,-1,true);
            pg.grabPixels();
            int width = pg.getWidth(),height = pg.getHeight();
            final int[] RBG_MASKS = { 0XFF0000,0XFF00,0XFF };
            final ColorModel RGB_OPAQUE = new DirectColorModel(32,RBG_MASKS[0],RBG_MASKS[1],RBG_MASKS[2]);
            DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(),pg.getWidth()*pg.getHeight());
            WritableRaster raster = Raster.createPackedRaster(buffer,width,height,width,RBG_MASKS,null);
            BufferedImage img = new BufferedImage(RGB_OPAQUE,raster,false,null);
            return img;
        }catch(InterruptedException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void resizeImage(File srcFile,int width,int height,File destFile){
        try{
            if(!destFile.getParentFile().exists())
                destFile.getParentFile().mkdir();
            Image i = ImageIO.read(srcFile);
            i = resizeImage(i,width,height);
            ImageIO.write((RenderedImage) i,"ipg",destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Image resizeImage(Image srcImage,int width,int heigth){
        try {
            BufferedImage buffImg = null;
            buffImg = new BufferedImage(width,heigth,BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width,heigth,Image.SCALE_SMOOTH),0,0,null);
            return buffImg;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
