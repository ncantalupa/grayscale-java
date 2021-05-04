/*----------------------
Author: Nick Cantalupa
email: nmcant21@g.holycross.edu
Written: 10/1/19

This program creates the SMPTE Color Bars screen with a width legth input by the user. Can choose bright or dim colors based on args[2]. 

java Colorbars smpte.png 960 dim 

-----------------------------*/

import java.awt.Color;

public class Colorbars {

	public static void main(String[ ] args) {


        int width = Integer.parseInt(args[1]);        //User width entry

        String light = args[2];                       //User brightness entry
        
        

        if ((width <= 0) || ((width%16) != 0)){
            System.out.println("Sorry, your entry must be a positive multiple of 16.");
            System.out.println("Try one of these: S-320  M-640  L-960");
            System.exit(0);
        }
                                                     //Quits the program if the entry
                                                     //is not a positive multiple of 16

        int w = width;                               //int variable for the width
        double hD= (double)w*(3.0/4.0);              //double variable for the height
        int h = (int)hD;                             //new height rounded to an int
        double wD = (double)w;                       //double width variable
           
        
        Picture colorbar = new Picture(w,h);         //Creates the picture

        

        Color gray = new Color(255,255,255);
        Color yellow = new Color(255,255,0);
        Color cyan = new Color(0,255,255);
        Color green = new Color(0,255,0);
        Color magenta = new Color(255,0,255);
        Color red = new Color(255,0,0);
        Color blue = new Color(0,0,255);
        Color white = new Color(255,255,255);
        Color black = new Color(0,0,0);
        Color darkBlue = new Color(0,33,76);
        Color darkPurple = new Color(50,0,106);      //Bright color variables

        Color grayD = new Color(192,192,192);
        Color yellowD = new Color(192,192,0);
        Color cyanD = new Color(0,192,192);
        Color greenD= new Color(0,192,0);
        Color magentaD = new Color(192,0,192);
        Color redD = new Color(192,0,0);
        Color blueD = new Color(0,0,192);            //Dim color variables


        for(int x=0;x < w;x++){
            for(int y=0;y < h;y++){
                colorbar.set(x,y,black);
            }
        }                                            //Sets the background color to be black


        if (light.equalsIgnoreCase("dim")){
            gray=grayD;
            yellow=yellowD;
            cyan=cyanD;
            green=greenD;
            magenta=magentaD;
            red=redD;
            blue=blueD;
        }else if (light.equalsIgnoreCase("bright")){
            ;
        }else {
            System.out.println("Invalid light intensity input. Try 'dim' or 'bright'.");
            System.exit(0);
        }
        //If the user inputs dim, the color variable
        //will be reassigned to their dim counterparts
        //If they input bright it keeps the variables as they are
        //if they input anything else, it prints an error message iand quits

        int x = 0;                                 //initialize x
        int y = 0;                                 //intitialize y

        for (y=0;y < hD;y++){
            if(y <= (2.0/3.0)*hD){         //Top 2/3 of image
                for(x=0;x < wD;x++){
                    if (x < (1.0/7.0)*wD){
                        colorbar.set(x,y,gray);
                    }else if((x >= (1.0/7.0)*wD) && (x < (2.0/7.0)*wD)){
                        colorbar.set(x,y,yellow);
                    }else if(((x >= (2.0/7.0)*wD) && (x < (3.0/7.0)*wD))){
                        colorbar.set(x,y,cyan);
                    }else if(((x >= (3.0/7.0)*wD) && (x < (4.0/7.0)*wD))){
                        colorbar.set(x,y,green);
                    }else if(((x >= (4.0/7.0)*wD) && (x < (5.0/7.0)*wD))){
                        colorbar.set(x,y,magenta);
                    }else if(((x >= (5.0/7.0)*wD) && (x < (6.0/7.0)*wD))){
                        colorbar.set(x,y,red);
                    }else if(((x >= (6.0/7.0)*wD) && (x < (7.0/7.0)*wD))){
                        colorbar.set(x,y,blue);
                    }    
                }
            }else if (y >= (3.0/4.0)*hD){ //Bottom 1/4 of image
                for (x=0;x < wD;x++){
                    if (x < (1.0/6.0)*wD){
                        colorbar.set(x,y,darkBlue);
                    }else if((x >= (1.0/6.0)*wD) && x < (2.0/6.0)*wD){
                        colorbar.set(x,y,white);
                    }else if((x >= (2.0/6.0)*wD) && x < (3.0/6.0)*wD){
                        colorbar.set(x,y,darkPurple);
                    }else if((x >= (3.0/6.0)*wD)){
                        colorbar.set(x,y,black);
                    }
                }
            }else if((y > (9.0/12.0)) && (y < (10.0/12.0)*wD)){ //Middle 12th of image
                for (x=0;x < wD;x++){
                    if (x < (1.0/7.0)*wD){
                        colorbar.set(x,y,blue);
                    }else if(((x >= (2.0/7.0)*wD) && (x < (3.0/7.0)*wD))){
                        colorbar.set(x,y,magenta);
                    }else if(((x >= (4.0/7.0)*wD) && (x < (5.0/7.0)*wD))){
                        colorbar.set(x,y,cyan);
                    }else if(((x >= (6.0/7.0)*wD) && (x < (7.0/7.0)*wD))){
                        colorbar.set(x,y,gray);
                    }
                
                }
            }
        }//end y for statement
        
        
        colorbar.save(args[0]); 
       colorbar.show();
       


    }//end of main
}//end of Colorbars

