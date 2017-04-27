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
public class HaralickTexture {
    
    //Generate the coccurance matrix using [i,j] for comparison
    public double[][] generateCoocurrance(byte[][] grayByteData)
    {
        double[][] coMatrix = new double[8][8];
        
        for(int i = 0; i < grayByteData.length; i++)
        {
            for(int j = 0; j < grayByteData[0].length - 1; j++)
            {
                int x = (int)(grayByteData[i][j] & 0xff);
                int y = (int)(grayByteData[i][j+1] & 0xff);
                
                x = checkCase(x);
                y = checkCase(y);
                              
                coMatrix[x][y] += 1.0;       
            }
        }
        
        //Normalize the Cooccurence Matrix. Step 1
        double sum = 0;
        for(int i = 0; i < coMatrix.length; i++)
        {
            for(int j = 0; j < coMatrix.length - 1; j++)
            {
                sum += coMatrix[i][j];   
            }
        }
        
//        System.out.println("The sum is: " + sum);
//        System.out.println("output: " + (1/sum));
        
        //Normalize Step 2
        for(int i = 0; i < coMatrix.length; i++)
        {
            for(int j = 0; j < coMatrix.length - 1; j++)
            {
                coMatrix[i][j] = coMatrix[i][j] * (1/sum);   
            }
        }    
        return coMatrix;
    }
    
    //Reduce the Cooccurance Matrix from a 256x256 to an 8X8
    public int checkCase(int num)
    {
        if(num >= 0 && num <= 31)
            num = 0;
        else if(num >= 32 && num <= 63)
            num = 1;
        else if(num >= 64 && num <= 95)
            num = 2;
        else if(num >= 96 && num <= 127)
            num = 3;
        else if(num >= 128 && num <= 159)
            num = 4;
        else if(num >= 160 && num <= 191)
            num = 5;
        else if(num >= 192 && num <= 224)
            num = 6;
        else if(num >= 225 && num <= 255)
            num = 7;

        return num;
    }
    
    public double getContrast(double[][] coMatrix)
    {
        //Contrast
        double contrastSum = 0;    
        for(int i = 0; i < coMatrix.length; i++)
        {
            for(int j = 0; j < coMatrix[0].length; j++)
            {
                contrastSum += ((i-j)*(i-j))*coMatrix[i][j];
            }
        }        
        //System.out.println("Contrast: " + contrastSum);
        return contrastSum;
    }
    
    public double getUniformity(double[][] coMatrix)
    {
        double uniformitySum = 0;
        for(int i = 0; i < coMatrix.length; i++)
        {
            for(int j = 0; j < coMatrix[0].length; j++)
            {
                uniformitySum += coMatrix[i][j] * coMatrix[i][j];
            }
        }
        //System.out.println("Uniformity: " + uniformitySum);
        return uniformitySum;
    }
    
    public double getHomogeneity(double[][] coMatrix)
    {
        //Homogeneity
        double homogeneitySum = 0;
        for(int i = 0; i < coMatrix.length; i++)
        {
            for(int j = 0; j < coMatrix[0].length; j++)
            {
                homogeneitySum += coMatrix[i][j]/(1 + Math.abs(i-j));
            }
        }      
        //System.out.println("Homogeneity: " + homogeneitySum);
        return homogeneitySum;
    }
    
    public double getEntropy(double[][] coMatrix)
    {
        double entropySum = 0;
        double num = 0;
        double num2;
        for(int i = 0; i < coMatrix.length; i++)
        {
            for(int j = 0; j < coMatrix[0].length; j++)
            {
                //System.out.println("[i][j]: " + coMatrix[i][j]);
                if(coMatrix[i][j] != 0)
                {
                    num = Math.log(coMatrix[i][j]);
                    //System.out.println("Num: " + num);
                    num2 = Math.log(coMatrix[i][j])/Math.log(2);
                    //System.out.println("Num2: " + num2);

                    entropySum += -coMatrix[i][j] * (Math.log(coMatrix[i][j])/Math.log(2));
                }
            }
        }
        //System.out.println("Entropy: " + entropySum);
        return entropySum;
    }
    
    public int haralickRecognition(spider spiderUnknown, BufferedImage unknownImage, double[][] features)
    {
        
        //Analyize new Spider
        spiderUnknown.bGrayImage = ImageIo.toGray(unknownImage);//Convert to Gray
        spiderUnknown.grayByteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(spiderUnknown.bGrayImage);//Extract gray byte data      
        spiderUnknown.coMatrix = generateCoocurrance(spiderUnknown.grayByteData);
        spiderUnknown.contrast = getContrast(spiderUnknown.coMatrix);
        spiderUnknown.homogeneity = getHomogeneity(spiderUnknown.coMatrix);
        spiderUnknown.uniformity = getUniformity(spiderUnknown.coMatrix);
        spiderUnknown.entropy = getEntropy(spiderUnknown.coMatrix);
        
        double [] newFeature = {spiderUnknown.contrast,spiderUnknown.homogeneity,spiderUnknown.uniformity,spiderUnknown.entropy};
         
        //Recognize Image by taking Euclidean Distance
        double[] distancesHaralick =  new double[features[0].length];

        for(int i = 0; i < features[0].length; i++)
        {
            for(int j = 0; j < newFeature.length; j++)
            {
                distancesHaralick[i] += ((newFeature[j] - features[j][i]) * (newFeature[j] - features[j][i]));
                //distances[i] += ((newFeature[j] - features[j][i]));
                //System.out.println("Distance = " + distances[i] + " NewFeature: " + newFeature[j] + " Features: " + features[j][i]); 
            }
        }  
        
        //SquareRoot the distances
        System.out.println("\n");
        for(int i = 0; i < distancesHaralick.length; i++)
        {
            distancesHaralick[i] = Math.sqrt(distancesHaralick[i]);
            //System.out.println(distances[i]);
        }        
        
        double minHaralick = distancesHaralick[0];
        int indexHaralick = 0;
        for(int i = 0; i < distancesHaralick.length; i++)
        {
            if(distancesHaralick[i] < minHaralick)
            {
                minHaralick = distancesHaralick[i];
                indexHaralick = i;
            }
        }
        
        return indexHaralick;
    }
    
    public void haralickFileProcessing(File[] files,int count, spider[] iArray, int num, HaralickTexture ht) 
    {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                haralickFileProcessing(file.listFiles(),num,iArray,num, ht);
                num += file.listFiles().length; 
            } else {
                System.out.println("File: " + file.getName());
                System.out.println("The Count is: " + count);
                iArray[count] = new spider();//Create object, store in array

                iArray[count].bImg = ImageIo.readImage(file.getPath());//Store bufferedImage
                iArray[count].bGrayImage = ImageIo.toGray(iArray[count].bImg);//Convert to gray                    
                iArray[count].grayByteData = ImageIo.getGrayByteImageArray2DFromBufferedImage(iArray[count].bGrayImage);//extract gray byte data

                iArray[count].coMatrix = ht.generateCoocurrance(iArray[count].grayByteData);
                iArray[count].contrast = ht.getContrast(iArray[count].coMatrix);
                iArray[count].homogeneity = ht.getHomogeneity(iArray[count].coMatrix);
                iArray[count].uniformity = ht.getUniformity(iArray[count].coMatrix);
                iArray[count].entropy = ht.getEntropy(iArray[count].coMatrix);

                iArray[count].name = file.getName();
                iArray[count].id = count;
                count++;
            }
        }
    }
   
}




