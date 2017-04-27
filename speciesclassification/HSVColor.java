/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speciesclassification;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

/**
 *
 * @author bassamarshad
 */
public class HSVColor {
    
     public double[] getNormalizedHistogram(BufferedImage inImage) {

        float[] hsb;

        int argb, r, g, b;
        // int HSBColorArray2D[][] = new int[inImage.getWidth()][inImage.getHeight()];
        int HSBInt[] = new int[inImage.getWidth() * inImage.getHeight()];
        int c = 0;
        double[] NormHisto;
        for (int i = 0; i < inImage.getWidth(); i++) {
            for (int j = 0; j < inImage.getHeight(); j++) {

                argb = inImage.getRGB(i, j);
                //Extract R, G, B individually & negate
                b = ((argb) & 0xFF);
                g = ((argb >> 8) & 0xFF);
                r = ((argb >> 16) & 0xFF);
                hsb = Color.RGBtoHSB(r, g, b, null);
                HSBInt[c++] = quantizeHSB1(hsb);

            }
        }

        //  System.out.println("h " +hsb[0] +"  s  "+ hsb[1]+"  b "+hsb[2]);
//        for(int i=0;i<HSBImage.getWidth();i++){
//            for(int j=0;j<HSBImage.getHeight();j++){
//                HSBImage.setRGB(i, j, HSBColorArray2D[i][j]);
//            }
//        }
//        ImageIo.writeImage(HSBImage, "jpg", "ConvertedUTB.jpg");
        Histogram hist = new Histogram();
        NormHisto = hist.createhistogram(HSBInt);

        return NormHisto;

    }

    public static int quantizeHSB1(float[] hsb) {
        // float[] hsbNew = new float[3];
        int h = Float.floatToIntBits((hsb[0] * 15f) / 4194303f);
        int s = Float.floatToIntBits((hsb[1] * 3f) / 4194303f);
        int b = Float.floatToIntBits((hsb[2] * 3f) / 4194303f);

        h = h & 0x007fffff;
        h = (h >> 19) & 0xF;

        s = s & 0x007fffff;
        s = (s >> 21) & 0x3;

        b = b & 0x007fffff;
        b = (b >> 21) & 0x3;

        int single = 0;

        single += h & 0xF;
        single = (single << 2);
        single += s & 0x3;
        single = (single << 2);
        single += b & 0x3;

        //   System.out.println(" h -- "+h+"s ---"+s+"b ---"+b);
        //  System.out.println(single);
//        System.out.println(" h -- "+Integer.toBinaryString(h)+"s ---"+Integer.toBinaryString(s)+"b ---"+Integer.toBinaryString(b));
//        System.out.println(Integer.toBinaryString(single));
        return single;
    }

    public static float[] convert8bitInttoFloatArray(int num) {
        //System.out.println(num);
        float[] hsbNew = new float[3];
        //
        int b = (num & 0x00000003);
        String DecToFloatb = "." + Integer.toString(b);
        hsbNew[2] = Float.valueOf(DecToFloatb);

        int s = (num & 0x0000000C);
        s = s >> 2;
        String DecToFloats = "." + Integer.toString(s);
        hsbNew[1] = Float.valueOf(DecToFloats);

        int h = (num & 0x000000F0);
        h = h >> 4;
        String DecToFloath = "." + Integer.toString(h);
        hsbNew[0] = Float.valueOf(DecToFloath);
        // System.out.println("h -- "+hsbNew[0] +"  s---- "+hsbNew[1] +"  b--- "+hsbNew[2]);

        return hsbNew;
    }

    public static int[] convert8bitInttoIntArray(int num) {
        //System.out.println(num);
        int[] hsbNew = new int[3];
        //
        int b = (num & 0x00000003);
        //String DecToFloatb = "."+Integer.toString(b); 
        hsbNew[2] = b;

        int s = (num & 0x0000000C);
        s = s >> 2;
        //String DecToFloats = "."+Integer.toString(s); 
        hsbNew[1] = s;

        int h = (num & 0x000000F0);
        h = h >> 4;
        //String DecToFloath = "."+Integer.toString(h); 
        hsbNew[0] = h;
        // System.out.println("h -- "+hsbNew[0] +"  s---- "+hsbNew[1] +"  b--- "+hsbNew[2]);

        return hsbNew;
    }
    
    public void hsvFileProcessing(File[] files,int count, spider[] iArray, int num) 
    {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                hsvFileProcessing(file.listFiles(),num,iArray,num);
                num += file.listFiles().length;
            } else {
                System.out.println("File: " + file.getName());
                System.out.println("The Count is: " + count);
                    iArray[count] = new spider();//Create object, store in array
                    iArray[count].bImg = ImageIo.readImage(file.getPath());//Store bufferedImage
                    iArray[count].histogram = getNormalizedHistogram(iArray[count].bImg);
                    //System.out.println(Arrays.toString(iArray[count].histogram));
                    iArray[count].name = file.getName();
                    iArray[count].id = count;
                    count++;

            }
        }
    }
    
    public int hsvRecognition(spider spiderUnknown,spider[] spiders)
    {
        Distances dist = new Distances();
        int indexHSV;
        //Get the distance sum between the new image and every image in the database
        float[] distanceFloats = new float[spiders.length];
        for(int i = 0 ; i < spiders.length; i ++)
        {
            distanceFloats[i] = dist.histogramIntersectionDist(spiderUnknown.histogram, spiders[i].histogram);
            //System.out.println("Distance Floats: " + distanceFloats[i]);
        }

        //normalize
        //unknown histogram total
        double unknownHistTotal = 0;
        for(int j = 0; j < spiderUnknown.histogram.length; j++)
        {
            unknownHistTotal += spiderUnknown.histogram[j];
        }

        //Histogram totals
        double[] histogramTotals =  new double[spiders.length];  
        for(int i = 0; i < spiders.length; i++)
        {
            for(int j = 0; j < spiders[i].histogram.length; j++)
            {
                histogramTotals[i] += spiders[i].histogram[j];
            }
        }

        double[] actualDistances =  new double[spiders.length];    
        for(int i = 0; i < spiders.length; i++)
        {
            actualDistances[i] = 1 - (distanceFloats[i] / (Math.min(unknownHistTotal, histogramTotals[i])));
            //System.out.println("Acutal Distances: " + actualDistances[i]);
        }

        double minHSV = actualDistances[0];
        indexHSV = 0;

        for(int i = 0; i < actualDistances.length; i++)
        {
            //System.out.println(distances[i]);
            if(actualDistances[i] < minHSV)
            {
                minHSV = actualDistances[i];
                indexHSV = i;
            }
        }
        
        //System.out.println("\nMin Distance: " + minHSV);
        return indexHSV;
    }
    
    //Not Normalized. Returns index with highest value
//    public int hsvRecognition(spider spiderUnknown,spider[] spiders)
//    {
//        Distances dist = new Distances();
//        int indexHSV;
//        //Get the distance sum between the new image and every image in the database
//        float[] distanceFloats = new float[spiders.length];
//        for(int i = 0 ; i < spiders.length; i ++)
//        {
//            distanceFloats[i] = dist.histogramIntersectionDist(spiderUnknown.histogram, spiders[i].histogram);
//            System.out.println("Distance Floats: " + distanceFloats[i]);
//        }
//
//        float maxHSV = distanceFloats[0];
//        indexHSV = 0;
//
//        for(int i = 0; i < distanceFloats.length; i++)
//        {
//            //System.out.println(distances[i]);
//            if(distanceFloats[i] > maxHSV)
//            {
//                maxHSV = distanceFloats[i];
//                indexHSV = i;
//            }
//        }
//        return indexHSV;
//    }
//    

}
    

