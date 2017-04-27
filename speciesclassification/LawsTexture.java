/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciesclassification;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 *
 * @author Matthew Martinez
 */
public class LawsTexture {
    //L5(level), E5(Edge), S5(spot), R5(Ripple), W5(wave)

    double mask1[][] = {//L5L5
    {1, 4, 6, 4, 1},
    {4, 16, 24, 16, 4},
    {6, 24, 36, 24, 6},
    {4, 16, 24, 16, 4},
    {1, 4, 6, 4, 1},};
    
    double mask2[][] = {//L5E5
    {-1, -2, 0, 2, 1},
    {-4, -8, 0, 8, 4},
    {-6, -12, 0, 12, 4},
    {-4, -8, 0, 8, 4},
    {-1, -2, 0, 2, 1},};
    
    double mask3[][] = {//L5S5
    {-1, 0, 2, 0, -1},
    {-4, 0, 8, 0, -4},
    {-6, 0, 12, 0, -6},
    {-4, 0, 8, 0, -4},
    {-1, 0, 2, 0, -1},};
    
    double mask4[][] = {//L5R5
    {1, -4, 6, -4, 1},
    {4, -16, 24, -16, 4},
    {6, -24, 36, -24, 6},
    {4, -16, 24, -16, 4},
    {1, -4, 6, -4, 1},};
    
    double mask5[][] = {//L5W5
    {-1, 2, 0, -2, 1},
    {-4, 8, 0, -8, 4},
    {-6, 12, 0, -12, 6},
    {-4, 8, 0, -8, 4},
    {-1, 2, 0, -2, 1},};
    
    double mask6[][] = {//E5L5
    {-1, -4, -6, -4, -1},
    {-2, -8, -12, -8, -2},
    {0, 0, 0, 0, 0},
    {2, 8, 12, 8, 2},
    {1, 4, 6, 4, 1},};
    
    double mask7[][] = {//E5E5
    {1, 2, 0, -2, -1},
    {2, 4, 0, -4, -2},
    {0, 0, 0, 0, 0},
    {-2, -4, 0, 4, 2},
    {-1, -2, 0, 2, 1},}; 
    
    double mask8[][] = {//E5S5
    {1, 0, -2, 0, 1},
    {2, 0, -4, 0, 2},
    {0, 0, 0, 0, 0},
    {-2, 0, 4, 0, -2},
    {-1, 0, 2, 0, -1},};
    
    double mask9[][] = {//E5R5
    {-1, 4, -6, 4, 1},
    {-2, 8, -12, 8, -2},
    {0, 0, 0, 0, 0},
    {2, -8, 12, -8, 2},
    {1, -4, 6, -4, 1},};
    
    double mask10[][] = {//E5W5
    {1, -2, 0, 2, 1},
    {2, -4, 0, 4, -2},
    {0, 0, 0, 0, 0},
    {-2, 4, 0, -4, 2},
    {-1, 2, 0, -2, 1},};
    
    double mask11[][] = {//S5L5
    {-1, -4, -6, -4, -1},
    {0, 0, 0, 0, 0},
    {2, 8, 12, 8, 2},
    {0, 0, 0, 0, 0},
    {-1, -4, -6, -4, -1},};
    
    double mask12[][] = {//S5E5
    {1, 2, 0, -2, -1},
    {0, 0, 0, 0, 0},
    {-2, -4, 0, 4, 2},
    {0, 0, 0, 0, 0},
    {1, 2, 0, -2, -1},};
    
    double mask13[][] = {//S5S5
    {1, 0, -2, 0, 1},
    {0, 0, 0, 0, 0},
    {-2, 0, 4, 0, -2},
    {0, 0, 0, 0, 0},
    {1, 0, -2, 0, 1},};
    
    double mask14[][] = {//S5R5
    {-1, 4, -6, 4, -1},
    {0, 0, 0, 0, 0},
    {2, 0, 12, 0, 2},
    {0, 0, 0, 0, 0},
    {-1, 4, -6, 4, -1},};
    
    double mask15[][] = {//S5W5
    {1, -2, 0, 2, 1},
    {0, 0, 0, 0, 0},
    {-2, 4, 0, -4, 2},
    {0, 0, 0, 0, 0},
    {1, -2, 0, 2, 1},};
    
    double mask16[][] = {//R5L5
    {1, 4, 6, 4, 1},
    {-4, -16, -24, -16, -4},
    {6, 24, 36, 24, 6},
    {-4, -16, -24, -16, -4},
    {1, 4, 6, 4, 1},};
    
    double mask17[][] = {//R5E5
    {-1, -2, 0, 2, 1},
    {4, 8, 0, -8, -4},
    {-6, -12, 0, 12, 6},
    {4, 8, 0, -8, -4},
    {-1, -2, 0, 2, 1},};
    
    double mask18[][] = {//R5S5
    {-1, 0, 2, 0, -1},
    {4, 0, -8, 0, 4},
    {-6, 0, 12, 0, -6},
    {4, 0, -8, 0, 4},
    {-1, 0, 2, 0, -1}};
    
    double mask19[][] = {//R5R5
    {1, -4, 6, -4, 1},
    {-4, 16, -24, 16, -4},
    {6, -24, 36, -24, 6},
    {-4, 16, -24, 16, -4},
    {1, -4, 6, -4, 1},};
    
    double mask20[][] = {//R5W5
    {-1, 2, 0, -2, 1},
    {4, -8, 0, 8, -4},
    {-6, 12, 0, -12, 6},
    {4, -8, 0, 8, -4},
    {-1, 2, 0, -2, 1},};
    
    double mask21[][] = {//W5L5
    {-1, -4, -6, -4, -1},
    {2, 8, 12, 8, 2},
    {0, 0, 0, 0, 0},
    {-2, -8, -12, -8, -2},
    {1, 4, 6, 4, 1},};
    
    double mask22[][] = {//W5E5
    {1, 2, 0, -2, -1},
    {-2, -4, 0, 4, 2},
    {0, 0, 0, 0, 0},
    {2, 4, 0, -4, -2},
    {-1, -2, 0, 2, 1},};
    
    double mask23[][] = {//W5S5
    {1, 0, -2, 0, 1},
    {-2, 0, 4, 0, -2},
    {0, 0, 0, 0, 0},
    {2, 0, -4, 0, 2},
    {-1, 0, 2, 0, -1},};
    
    double mask24[][] = {//W5R5
    {-1, 4, -6, 4, 1},
    {2, -8, 12, -8, 2},
    {0, 0, 0, 0, 0},
    {-2, 8, -12, 8, 2},
    {1, -4, 6, -4, 1},};
            
    double mask25[][] = {//W5W5
    {1, -2, 0, 2, -1},
    {-2, 4, 0, -4, 2},
    {0, 0, 0, 0, 0},
    {2, -4, 0, 4, -2},
    {-1, 2, 0, -2, 1},};
    
    double gaussMask1[][] = {//Sigma 1, Kernal 5
    {0.003765, 0.015019, 0.023792, 0.015019, 0.003765},
    {0.015019, 0.059912, 0.0944907, 0.059912, 0.015019},
    {0.023792, 0.094907, 0.150342, 0.094907, 0.023792},
    {0.015019, 0.059912, 0.0944907, 0.059912, 0.015019},
    {0.003765, 0.015019, 0.023792, 0.015019, 0.003765},};


    double gaussMask2[][] = {//Sigma 1, Kernal 7
    {0.000036, 0.000363, 0.001446, 0.002291, 0.001446, 0.000363, 0.000036},
    {0.000363, 0.003676, 0.014662, 0.023226, 0.014662, 0.003676, 0.000363},
    {0.001446, 0.014662, 0.058488, 0.092651, 0.058488, 0.014662, 0.001446},
    {0.002291, 0.023226, 0.092651, 0.146768, 0.092651, 0.023226, 0.002291},
    {0.001446, 0.014662, 0.058488, 0.092651, 0.058488, 0.014662, 0.001446},
    {0.000363, 0.003676, 0.014662, 0.023226, 0.014662, 0.003676, 0.000363},
    {0.000036, 0.000363, 0.001446, 0.002291, 0.001446, 0.000363, 0.000036},};

    double gaussMask3[][] = {//Sigma 1, Kernal 9
    {0, 0.000001, 0.000014, 0.000055, 0.000088, 0.000055, 0.000014, 0.000001, 0},
    {0.000001, 0.000036, 0.000362, 0.001445, 0.002289, 0.001445, 0.000362, 0.000036, 0.000001},
    {0.000014, 0.000362, 0.003672, 0.014648, 0.023205, 0.014648, 0.003672, 0.000362, 0.000014},
    {0.000055, 0.001445, 0.014648, 0.058434, 0.092566, 0.058434, 0.014648, 0.001445, 0.000055},
    {0.000088, 0.002289, 0.023205, 0.092566, 0.146634, 0.092566, 0.023205, 0.002289, 0.000088},
    {0.000055, 0.001445, 0.014648, 0.058434, 0.092566, 0.058434, 0.014648, 0.001445, 0.000055},
    {0.000014, 0.000362, 0.003672, 0.014648, 0.023205, 0.014648, 0.003672, 0.000362, 0.000014},
    {0.000001, 0.000036, 0.000362, 0.001445, 0.002289, 0.001445, 0.000362, 0.000036, 0.000001},
    {0, 0.000001, 0.000014, 0.000055, 0.000088, 0.000055, 0.000014, 0.000001, 0},};
    
    double gaussMask4[][] = {//Sigma 1, Kernal 11
    {0, 0, 0, 0, 0.000001, 0.000001, 0.000001, 0, 0, 0, 0},
    {0, 0, 0.000001, 0.000014, 0.000055, 0.000088, 0.000055, 0.000014, 0.000001, 0, 0},
    {0, 0.000001, 0.000036, 0.000362, 0.001445, 0.002289, 0.001445, 0.000362, 0., 0.000036, 0.000001, 0},
    {0, 0.000014, 0.000362, 0.003672, 0.014648, 0.023204, 0.014648, 0.003672, 0.000362, 0.000014, 0},
    {0.000001, 0.000055, 0.001445, 0.014648, 0.058433, 0.092564, 0.058433, 0.014648, 0.001445, 0.000055, 0.000001},
    {0.000001, 0.000088, 0.002289, 0.023204, 0.092564, 0.146632, 0.092564, 0.023204, 0.002289, 0.000088, 0.000001},
    {0.000001, 0.000055, 0.001445, 0.014648, 0.058433, 0.092564, 0.058433, 0.014648, 0.001445, 0.000055, 0.000001},
    {0, 0.000014, 0.000362, 0.003672, 0.014648, 0.023204, 0.014648, 0.003672, 0.000362, 0.000014, 0},
    {0, 0.000001, 0.000036, 0.000362, 0.001445, 0.002289, 0.001445, 0.000362, 0., 0.000036, 0.000001, 0},
    {0, 0, 0.000001, 0.000014, 0.000055, 0.000088, 0.000055, 0.000014, 0.000001, 0, 0},
    {0, 0, 0, 0, 0.000001, 0.000001, 0.000001, 0, 0, 0, 0},};
    
    double gaussMask5[][] = {//Sigma 1, Kernal 13
    {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 , 0, 0},
    {0, 0, 0, 0, 0, 0.000001, 0.000001, 0.000001, 0, 0, 0, 0, 0},
    {0, 0, 0, 0.000001, 0.000014, 0.000055, 0.000088, 0.000055, 0.000014, 0.000001 , 0, 0, 0},
    {0, 0, 0.000001, 0.000036, 0.000362, 0.001445, 0.002289, 0.001445, 0.000362, 0.000036, 0.000001, 0, 0},
    {0, 0, 0.000014, 0.000362, 0.03672, 0.014648, 0.023204, 0.014648, 0.03672, 0.000362, 0.000014, 0, 0},
    {0.000001, 0.000055, 0.001445, 0.014648, 0.058433, 0.092564, 0.058433, 0.092564, 0.058433, 0.014648, 0.001445, 0.000055, 0.000001},
    {0.000001, 0.000088, 0.002289, 0.023204, 0.092564, 0.146632, 0.092564, 0.146632, 0.092564, 0.023204, 0.002289, 0.000088, 0.000001},
    {0.000001, 0.000055, 0.001445, 0.014648, 0.058433, 0.092564, 0.058433, 0.092564, 0.058433, 0.014648, 0.001445, 0.000055, 0.000001},
    {0, 0, 0.000014, 0.000362, 0.03672, 0.014648, 0.023204, 0.014648, 0.03672, 0.000362, 0.000014, 0, 0},
    {0, 0, 0.000001, 0.000036, 0.000362, 0.001445, 0.002289, 0.001445, 0.000362, 0.000036, 0.000001, 0, 0},
    {0, 0, 0, 0.000001, 0.000014, 0.000055, 0.000088, 0.000055, 0.000014, 0.000001 , 0, 0, 0},
    {0, 0, 0, 0, 0, 0.000001, 0.000001, 0.000001, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 , 0, 0},};
    
    private double min = Double.POSITIVE_INFINITY;
    private double max = 0;
    
   /*Preprocess. Remove effects of illumination by moving a small
        window around the image, and subtracting the local average from each pixel, to produce
        a preprocessed image, in which the average intensity of each neighborhood is near to zero*/   
    public double[][] lawsPreprocess(byte[][] grayByteData, int windowSize)
    {
        double[][] preprocessedImg = new double[grayByteData.length][grayByteData[0].length];    
        for(int i = 0; i < grayByteData.length; i += windowSize)
        {
            for(int j = 0; j < grayByteData[0].length; j += windowSize)
            {   
                double sum = 0;
                double average = 0;

                //Calculate sum of the window
                for(int x = i; x < i + windowSize; x++)
                {
                    for(int y = j; y < j + windowSize; y++)
                    {       
                        sum += (grayByteData[x][y] & 0xFF);         
                        //System.out.println((grayByteData[x][y]& 0xFF) + ": Position " + x +" "+ y);                       
                    }
                }   
                //Average the sum
                average = sum/(windowSize*windowSize);
                //System.out.println("Sum: " + sum);
                //System.out.println("Average: " + average);   

                //Subtract the average and place into a new byte array
                for(int n = i; n < i + windowSize; n++)
                {
                    for(int m = j; m < j + windowSize; m++)
                    {       
                        preprocessedImg[n][m] = ((grayByteData[n][m] & 0xFF) - average);  
                        //System.out.println(newByteImage[n][m] + ": Position " + n +" "+ m);    
                    }
                }   
            }
        }   
        return preprocessedImg;
    }
    
    public double[][] applyMask(double[][] preprocessedImg, double[][] mask)
    { 
        double[][] convolvedImage = new double[146][146];
        //double[][] convolvedImage = new double[preprocessedImg.length-mask.length+1][preprocessedImg[0].length-mask[0].length+1];

        //Run mask over image
        for(int i = 2; i < preprocessedImg.length - 2; i++)
        {
            for(int j = 2; j < preprocessedImg[0].length - 2; j++)
            {
                double sum = 0;

                for(int x = 0; x < mask.length; x++)
                {
                    for(int y = 0; y < mask[0].length; y++)
                    {       
                        sum += mask[x][y] * preprocessedImg[i-2+x][j-2+y];
                        //System.out.println(newByteImage[x][y] + ": Position " + x +" "+ y);
                        //numCheck = mask1[x][y] * newImgData[i-2+x][j-2+y];
                    }
                }
                convolvedImage[i-2][j-2] = sum;
            }
        }
        return convolvedImage;    
    }
    
    public double[][] lawsPostProcessGauss(double[][] preImg, double[][] mask)
    {
        min = Double.POSITIVE_INFINITY;
        max = 0;
                
        int m = mask.length/2;
        int n = mask[0].length/2;
        
        double[][] postProc = new double [146-mask.length +1][146-mask.length+1];

        //Run mask over image
        for(int i = m; i < preImg.length - n; i++)
        {
            for(int j = m; j < preImg[0].length - n; j++)
            {
                double sum = 0;
                double num = 0;

                for(int x = 0; x < mask.length; x++)
                {
                    for(int y = 0; y < mask[0].length; y++)
                    {       
                        sum += mask[x][y] * preImg[i-m+x][j-n+y];
                    }
                }

                num = Math.abs(sum);
                postProc[i-m][j-n] = num;
                
                if(num < min)
                    min = num;
                if(num > max)
                    max = num; 
            }
        }
 
        //System.out.println("Min: " + min + ", Max: " + max);
        return postProc;
    }
    
    public byte[][] normalize(double[][] postImg)
    {
        byte[][] byteImg = new byte[postImg.length][postImg[0].length];
        double r=max-min;
        
        for(int i = 0; i < postImg.length; i++)
        {
            for(int j = 0; j < postImg[0].length; j++)
            { 
                byteImg[i][j] = (byte)(((postImg[i][j] - min)/r)*255);
                //System.out.println((((postImg[i][j] - min)/r)*255));
            }
        }
        return byteImg;
    }
    
    public int lawsRecognition(double[][] newPrototype, double[][][] prototypes, spider newSpider, int totalPics, int numMasksUsed)
    {
        double[][] distances  =  new double[newSpider.postProcessedImg.length * newSpider.postProcessedImg[0].length][totalPics];//MXN, Total images in D.B.
        
        for(int i = 0; i < totalPics ; i++)
        {
            for(int m = 0; m < newPrototype.length; m++)
            {
                for(int n = 0; n < numMasksUsed; n++)
                {        
                    distances[m][i] += ((newPrototype[m][n] - prototypes[m][n][i]) * (newPrototype[m][n] - prototypes[m][n][i]));
                }
            }
        }
         
        //SquareRoot the distances
        for(int i = 0; i < distances.length; i++)
        {
            for(int j =0; j < distances[0].length; j++)
            {
                distances[i][j] = Math.sqrt(distances[i][j]);
                //System.out.println("Distances: " + distances[i][j]);
            }
            
           //System.out.println("\n");           
        }   
        
        double min = Double.POSITIVE_INFINITY;
        int index = 0;
        int[] spiderIndexes = new int[totalPics];

        for(int i = 0; i < distances.length; i++)
        {
            min = Double.POSITIVE_INFINITY;
            for(int j =0; j < distances[0].length; j++)
            {
                if(distances[i][j] < min)
                {
                    min = distances[i][j];
                    index = j;
                }              
            }            
            spiderIndexes[index] +=1;
        }
       
//        System.out.println("\nPixels from black widow[0]: " + spiderIndexes[0]);
//        System.out.println("Pixels from brown recluse[1]: " + spiderIndexes[1]);
//        System.out.println("Pixels from brown widow[2]: " + spiderIndexes[2]);
//        System.out.println("Pixels from red widow[3]: " + spiderIndexes[3]);
//        System.out.println("Pixels from spiny orb weaver[4]: " + spiderIndexes[4]);
        
        index = 0;
        int max = spiderIndexes[0];
        for(int i =0; i < spiderIndexes.length; i++)
        {
            if(spiderIndexes[i] > max)
            {
                max = spiderIndexes[i];
                index = i;
            }
        }
        
        return index;
      //  System.out.println("\nMost Pixels are from index: " + index);
      //  System.out.println("Total Pixels is: " + spiderIndexes[index]);
    }
        
    
    public double[][] lawsProcessNewImg(spider newSpider, BufferedImage testImage, double[][] gaussianMask, int[] chooseMasks, int numMasksUsed)
    {
        newSpider.bGrayImage = ImageIo.toGray(testImage);//Convert to Gray
        newSpider.grayByteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(newSpider.bGrayImage);//Extract gray byte data
        newSpider.preProcessedImg = lawsPreprocess(newSpider.grayByteData, 15);   
        newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask1);//This one used for initialization
        newSpider.postProcessedImg = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);//This one used for initilization
        

        if(chooseMasks[0] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask1);
            newSpider.postProcessedImg1 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[1] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask2);
            newSpider.postProcessedImg2 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[2] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask3);
            newSpider.postProcessedImg3 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[3] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask4);
            newSpider.postProcessedImg4 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask); 
        }
        if(chooseMasks[4] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask5);
            newSpider.postProcessedImg5 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[5] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask6);
            newSpider.postProcessedImg6 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[6] == 1){                   
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask7);
            newSpider.postProcessedImg7 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[7] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask8);
            newSpider.postProcessedImg8 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[8] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask9);
            newSpider.postProcessedImg9 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask); 
        }
        if(chooseMasks[9] == 1){          
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask10);
            newSpider.postProcessedImg10 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[10] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask11);
            newSpider.postProcessedImg11 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[11] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask12);
            newSpider.postProcessedImg12 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[12] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask13);
            newSpider.postProcessedImg13 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[13] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask14);
            newSpider.postProcessedImg14 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[14] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask15);
            newSpider.postProcessedImg15 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }if(chooseMasks[15] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask16);
            newSpider.postProcessedImg16 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[16] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask17);
            newSpider.postProcessedImg17 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[17] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask18);
            newSpider.postProcessedImg18 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[18] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask19);
            newSpider.postProcessedImg19 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[19] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask20);
            newSpider.postProcessedImg20 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[20] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask21);
            newSpider.postProcessedImg21 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[21] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask22);
            newSpider.postProcessedImg22 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[22] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask23);
            newSpider.postProcessedImg23 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[23] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask24);
            newSpider.postProcessedImg24 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        if(chooseMasks[24] == 1){
            newSpider.convolvedImage = applyMask(newSpider.preProcessedImg, mask25);
            newSpider.postProcessedImg25 = lawsPostProcessGauss(newSpider.convolvedImage, gaussianMask);
        }
        
        double[][] newPrototype =  new double[newSpider.postProcessedImg.length * newSpider.postProcessedImg[0].length][numMasksUsed];       
        int position = 0;
        for(int m = 0; m < newSpider.postProcessedImg.length; m++)
        {
            for(int n = 0; n < newSpider.postProcessedImg[0].length; n++)
            {
                position = ((m*newSpider.postProcessedImg[0].length) + n);
                    
                int numPrototypes = 0;

                if(chooseMasks[0] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg1[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[1] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg2[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[2] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg3[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[3] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg4[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[4] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg5[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[5] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg6[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[6] == 1){                   
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg7[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[7] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg8[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[8] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg9[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[9] == 1){          
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg10[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[10] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg11[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[11] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg12[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[12] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg13[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[13] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg14[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[14] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg15[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[15] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg16[m][n];
                }
                if(chooseMasks[16] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg17[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[17] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg18[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[18] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg19[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[19] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg20[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[20] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg21[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[21] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg22[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[22] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg23[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[23] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg24[m][n];
                    numPrototypes += 1;
                }
                if(chooseMasks[24] == 1){
                    newPrototype[position][numPrototypes] = newSpider.postProcessedImg25[m][n];
                    numPrototypes += 1;
                }
            }
        }
        return newPrototype;
    }
    
    public void lawsFileProcessing(File[] files,int count, spider[] iArray, int num, LawsTexture lt, double[][] gaussianMask, int[] chooseMasks,int print) 
    {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                lawsFileProcessing(file.listFiles(),num,iArray,num, lt, gaussianMask, chooseMasks, print);
                num += file.listFiles().length;
            } else {
                System.out.println("File: " + file.getName());
                System.out.println("The Count is: " + count);
                    iArray[count] = new spider();//Create object, store in array
                    iArray[count].name = file.getName();
                    iArray[count].id = count;
                    iArray[count].bImg = ImageIo.readImage(file.getPath());//Store bufferedImage
                    iArray[count].bGrayImage = ImageIo.toGray(iArray[count].bImg);//Convert to gray                    
                    iArray[count].grayByteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(iArray[count].bGrayImage);//extract gray byte data                   
                    iArray[count].preProcessedImg = lt.lawsPreprocess(iArray[count].grayByteData, 15);
                    iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask1);//This one used for initialization
                    iArray[count].postProcessedImg = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);//This one used for initilization
                    
                    if(chooseMasks[0] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask1);
                        iArray[count].postProcessedImg1 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg1);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "1.jpg"); 
                        }
                    }
                    if(chooseMasks[1] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask2);
                        iArray[count].postProcessedImg2 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg2);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "2.jpg");
                        }
                    }
                    if(chooseMasks[2] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask3);
                        iArray[count].postProcessedImg3 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg3);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "3.jpg");
                        }
                    }
                    if(chooseMasks[3] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask4);
                        iArray[count].postProcessedImg4 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg4);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "4.jpg");
                        }
                    }
                    if(chooseMasks[4] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask5);
                        iArray[count].postProcessedImg5 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1)
                        {
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg5);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "5.jpg");
                        }
                    }
                    if(chooseMasks[5] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask6);
                        iArray[count].postProcessedImg6 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg6);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "6.jpg");
                        }
                    }
                    if(chooseMasks[6] == 1){                   
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask7);
                        iArray[count].postProcessedImg7 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg7);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "7.jpg");
                        }
                    }
                    if(chooseMasks[7] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask8);
                        iArray[count].postProcessedImg8 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg8);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "8.jpg");
                        }
                    }
                    if(chooseMasks[8] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask9);
                        iArray[count].postProcessedImg9 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg9);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "9.jpg");   
                        }
                    }
                    if(chooseMasks[9] == 1){          
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask10);
                        iArray[count].postProcessedImg10 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg10);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "10.jpg");
                        }
                    }
                    if(chooseMasks[10] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask11);
                        iArray[count].postProcessedImg11 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg11);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "11.jpg");
                        }
                    }
                    if(chooseMasks[11] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask12);
                        iArray[count].postProcessedImg12 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg12);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "12.jpg");
                        }
                    }
                    if(chooseMasks[12] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask13);
                        iArray[count].postProcessedImg13 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg13);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "13.jpg");
                        }
                    }
                    if(chooseMasks[13] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask14);
                        iArray[count].postProcessedImg14 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg14);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "14.jpg");
                        }
                    }
                    if(chooseMasks[14] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask15);
                        iArray[count].postProcessedImg15 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg15);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "15.jpg");
                        }
                    }if(chooseMasks[15] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask16);
                        iArray[count].postProcessedImg16 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg16);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "16.jpg");
                        }
                    }
                    if(chooseMasks[16] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask17);
                        iArray[count].postProcessedImg17 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg17);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "17.jpg");
                        }
                    }
                    if(chooseMasks[17] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask18);
                        iArray[count].postProcessedImg18 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg18);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "18.jpg"); 
                        }
                    }
                    if(chooseMasks[18] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask19);
                        iArray[count].postProcessedImg19 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg19);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "19.jpg");
                        }
                    }
                    if(chooseMasks[19] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask20);
                        iArray[count].postProcessedImg20 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg20);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "20.jpg");
                        }
                    }
                    if(chooseMasks[20] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask21);
                        iArray[count].postProcessedImg21 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg21);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "21.jpg");
                        }
                    }
                    if(chooseMasks[21] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask22);
                        iArray[count].postProcessedImg22 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg22);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "22.jpg");
                        }
                    }
                    if(chooseMasks[22] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask23);
                        iArray[count].postProcessedImg23 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg23);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "23.jpg");
                        }
                    }
                    if(chooseMasks[23] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask24);
                        iArray[count].postProcessedImg24 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg24);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "24.jpg");
                        }
                    }
                    if(chooseMasks[24] == 1){
                        iArray[count].convolvedImage = lt.applyMask(iArray[count].preProcessedImg, lt.mask25);
                        iArray[count].postProcessedImg25 = lt.lawsPostProcessGauss(iArray[count].convolvedImage, gaussianMask);
                        if(print == 1){
                            iArray[count].normalizedImg = lt.normalize(iArray[count].postProcessedImg25);
                            iArray[count].outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(iArray[count].normalizedImg);
                            ImageIo.writeImage(iArray[count].outImage, "jpg", iArray[count].name + "25.jpg");
                        }
                    }
                    count++;
            }
        }
    }
}
