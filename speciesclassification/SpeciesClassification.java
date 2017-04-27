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
public class SpeciesClassification {
    static{ System.load("D:\\Matthew\\Documents\\opencv\\build\\java\\x64\\opencv_java310.dll");}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Load the files of the directory
        File[] files = new File("D:\\OneDrive\\Documents\\NetBeansProjects\\speciesClassification\\spiderDB").listFiles();
        //File[] files = new File("D:\\OneDrive\\Documents\\NetBeansProjects\\speciesClassification\\spidersCopy").listFiles();
        
        //Total images in database
        int totalPics = countFilesOnly(files,0);//Get the amount of files in the DB 
        
        spider[] spiders = new spider[totalPics];
        System.out.println("Total Imgs: " + totalPics);

        BufferedImage unknownImage = ImageIo.readImage("testRecluse3.jpg");//Read Image
        spider spiderUnknown = new spider();

//-------------------------------------HSV COLOR------------------------------------------------------------------------

    HSVColor hsvc = new HSVColor();
    Distances dist = new Distances();
    
    //Create HSV Color Histrograms for images in database
    hsvc.hsvFileProcessing(files,0,spiders,0);

    //Create HSV color histogram for new image
    spiderUnknown.histogram = hsvc.getNormalizedHistogram(unknownImage);
    
    //Recognize
    int indexHSV = 0;
    
    indexHSV = hsvc.hsvRecognition(spiderUnknown,spiders);

    //Recognize by getting the Minkowski Distance
//    float[] distancesHSV = new float[totalPics];
//       
//    for(int i = 0 ; i < totalPics; i ++)
//    {
//        distancesHSV[i] = dist.minkowskiDist(spiderUnknown.histogram, spiders[i].histogram);
//    }
//    
//    float minHSV = distancesHSV[0];
//    int indexHSV2 = 0;
//    
//    for(int i = 0; i < distancesHSV.length; i++)
//    {
//        //System.out.println(distances[i]);
//        if(distancesHSV[i] < minHSV)
//        {
//            minHSV = distancesHSV[i];
//            indexHSV2 = i;
//        }
//    }
//    
//    //Relative Deviatian distance
//    float[] distancesRealtiveDeviation = new float[totalPics];
//       
//    for(int i = 0 ; i < totalPics; i ++)
//    {
//        distancesRealtiveDeviation[i] = dist.relativeDeviationDist(spiderUnknown.histogram, spiders[i].histogram);
//    }
//    
//    float minHSV2 = distancesRealtiveDeviation[0];
//    int indexHSV3 = 0;
//    
//    for(int i = 0; i < distancesRealtiveDeviation.length; i++)
//    {
//        //System.out.println(distances[i]);
//        if(distancesRealtiveDeviation[i] < minHSV2)
//        {
//            minHSV2 = distancesRealtiveDeviation[i];
//            indexHSV3 = i;
//        }
//    }


//--------------------------------------LAWS METHOD-----------------------------------------------------------------

        LawsTexture lt = new LawsTexture();
        
        //Select postprocess mask
        double[][] gaussianMask = lt.gaussMask1;
        
        //Select masks to use by settings array index to 1;         
                           //1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5
        int[] chooseMasks = {0,1,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0};
        
        //How many masks are being used
        int numMasksUsed = 0;
        for(int i = 0; i < chooseMasks.length; i++)
        {   
            if(chooseMasks[i] == 1)
            numMasksUsed +=1;
        }    
        
        //Apply seleceted masks to images in database. Final Parameter: 1 to print or 0 otherwise
        lt.lawsFileProcessing(files, 0, spiders, 0, lt, gaussianMask, chooseMasks, 0);
        double[][][] prototypes = new double[(spiders[0].postProcessedImg.length * spiders[0].postProcessedImg[0].length)][numMasksUsed][totalPics];//MXN Vector, n masks, 5 protoypes
                        
        int position = 0;  
        //Create the prototypes
        for(int i = 0; i < totalPics; i++)
        {
            for(int m = 0; m < spiders[0].postProcessedImg.length; m++)
            {
                for(int n = 0; n < spiders[0].postProcessedImg[0].length; n++)
                {
                    position = ((m*spiders[i].postProcessedImg[0].length) + n);

                    int numPrototypes = 0;
                    
                    if(chooseMasks[0] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg1[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[1] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg2[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[2] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg3[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[3] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg4[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[4] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg5[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[5] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg6[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[6] == 1){                   
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg7[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[7] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg8[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[8] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg9[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[9] == 1){          
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg10[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[10] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg11[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[11] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg12[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[12] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg13[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[13] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg14[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[14] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg15[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[15] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg16[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[16] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg17[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[17] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg18[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[18] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg19[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[19] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg20[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[20] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg21[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[21] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg22[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[22] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg23[m][n];
                        numPrototypes += 1;
                    }
                    if(chooseMasks[23] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg24[m][n];
                         numPrototypes += 1;
                    }
                    if(chooseMasks[24] == 1){
                        prototypes[position][numPrototypes][i] = spiders[i].postProcessedImg25[m][n];
                        numPrototypes += 1;
                    }
                    
                }
            }
        }             
        
        //Print ProtoTypes
//        double[][] singleProtoWithMasks = new double[spiders[0].postProcessedImg.length][spiders[0].postProcessedImg[0].length];
//        byte[][] singleProtoWithMasksNorm = new byte[spiders[0].postProcessedImg.length][spiders[0].postProcessedImg[0].length];
//        double tot = 0;
//        int indexI = 0;
//        int indexJ = 0;
//        
//        for(int i = 0; i < totalPics; i++)
//        {
//            for(int m = 0; m < (spiders[0].postProcessedImg.length * spiders[0].postProcessedImg[0].length); m++)
//            {
//                tot = 0;
//                for(int n = 0; n < numMasksUsed; n++)
//                {
//                    tot += prototypes[m][n][i];
//                }
//                //Turn 1D to 2D
//                indexI = m/spiders[0].postProcessedImg[0].length;
//                indexJ = m%spiders[0].postProcessedImg[0].length;
//
//                //singleProtoWithMasks[indexI][indexJ] = (tot/numMasksUsed);
//                singleProtoWithMasks[indexI][indexJ] = tot;
//            }
//            
//            singleProtoWithMasksNorm = normalizeMM(singleProtoWithMasks);
//
//            //Write out image as a file
//            BufferedImage outImage = ImageIo.setGrayByteImageArray2DToBufferedImage(singleProtoWithMasksNorm);
//            ImageIo.writeImage(outImage, "jpg", "protoType" + i + ".jpg");
//        }
        
 
        //Process the new image
        double[][] newPrototype = lt.lawsProcessNewImg(spiderUnknown, unknownImage, gaussianMask, chooseMasks, numMasksUsed);
        
        //Identify the new image. Function returns the index of the image
        int indexLAWS;
        indexLAWS = lt.lawsRecognition(newPrototype, prototypes, spiderUnknown, totalPics, numMasksUsed);
          
        
//------------------------------------HARALICK METHOD----------------------------------------------------------------------------------

        HaralickTexture ht = new HaralickTexture();
        
        ht.haralickFileProcessing(files, 0, spiders, 0, ht);
        
        double[][] features =  new double[4][totalPics];//4 Features. # different species
        
        //Calculate centroids
        int start = 0;
        double avg = 0;
        double totalContrast = 0;
        double totalHomogeneity = 0;
        double totalUniformity = 0;        
        double totalEntropy = 0;

        for(int j = 0; j < totalPics; j++)
        {
            features[0][j] = spiders[j].contrast;
            features[1][j] = spiders[j].homogeneity;
            features[2][j] = spiders[j].uniformity;             
            features[3][j] = spiders[j].entropy;
        }
        
        //Recognize Image
        int indexHaralick = 0;
        indexHaralick = ht.haralickRecognition(spiderUnknown, unknownImage, features);

//------------------------------------------------------------------------------------------------------------------------------
    
        System.out.println("\n-------------------------Results------------------------------\n");
        System.out.println("HSV");     
        System.out.println("Intersection Index: " + indexHSV);
        System.out.println("Spider: " + spiders[indexHSV].name);
        
//        System.out.println("\nMinkowski Index: " + indexHSV2);
//        System.out.println("Spider: " + spiders[indexHSV2].name);
//        
//        System.out.println("\nRelative Index: " + indexHSV3);
//        System.out.println("Spider: " + spiders[indexHSV3].name);
//        
        System.out.println("\nHARALICK");
        System.out.println("Closest Index Is: " + indexHaralick);
        System.out.println("Spider: " + spiders[indexHaralick].name);

        System.out.println("\nLAWS");   
        System.out.println("Closest Index Is: " + indexLAWS);
        System.out.println("Spider: " + spiders[indexLAWS].name);
              
    }//End Main
    
    public static byte[][] normalizeMM(double[][] postImg)
    {
        double min = Double.POSITIVE_INFINITY;
        double max = 0;
        
        for(int i = 0; i < postImg.length; i++)
        {
            for(int j = 0; j < postImg[0].length; j++)
            {
                if(postImg[i][j] < min)
                    min = postImg[i][j];
                if(postImg[i][j] > max)
                    max = postImg[i][j]; 
            }
        }
        //System.out.println("Min: " + min + ", Max: " + max);
        
        byte[][] byteImg = new byte[postImg.length][postImg[0].length];
        double r=max-min;
        
        for(int i = 0; i < postImg.length; i++)
        {
            for(int j = 0; j < postImg[0].length; j++)
            {
                //System.out.println((((postImg[i][j] - min)/r)*255));
                byteImg[i][j] = (byte)(((postImg[i][j] - min)/r)*255);
            }
        }
        return byteImg;
    }
   
    //Returns the total of all files in a directory and its subdirectories
    public static int countFilesOnly(File[] files, int num) 
    {
        for (File file : files) {
            if (file.isDirectory()) {
                //System.out.println("Directory: " + file.getName());
                countFilesOnly(file.listFiles(),num);
                num += file.listFiles().length;
            }
        }
        return num;
    }
}//End class
