/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciesclassification;

import java.awt.image.BufferedImage;

/**
 *
 * @author Matthew Martinez
 */
public class spider {
    int id;
    String name;
    
    //HARALICK
    double contrast;
    double uniformity;
    double homogeneity;
    double entropy;
    double[][] coMatrix = new double[8][8];
        
    //LAWS
    BufferedImage bImg;
    BufferedImage bGrayImage;
    BufferedImage outImage;
    byte[][] grayByteData;
    double[][] preProcessedImg;
    double[][] convolvedImage;
    byte[][] normalizedImg;
    
    double[][] postProcessedImg;
    double[][] postProcessedImg1;
    double[][] postProcessedImg2;
    double[][] postProcessedImg3;
    double[][] postProcessedImg4;
    double[][] postProcessedImg5;
    double[][] postProcessedImg6;
    double[][] postProcessedImg7;
    double[][] postProcessedImg8;
    double[][] postProcessedImg9;
    double[][] postProcessedImg10;
    double[][] postProcessedImg11;
    double[][] postProcessedImg12;
    double[][] postProcessedImg13;
    double[][] postProcessedImg14;
    double[][] postProcessedImg15;
    double[][] postProcessedImg16;
    double[][] postProcessedImg17;
    double[][] postProcessedImg18;
    double[][] postProcessedImg19;
    double[][] postProcessedImg20;
    double[][] postProcessedImg21;
    double[][] postProcessedImg22;
    double[][] postProcessedImg23;
    double[][] postProcessedImg24;
    double[][] postProcessedImg25;   
    
    //HSV
    public double[] histogram;

}
