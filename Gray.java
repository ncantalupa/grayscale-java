/*----------------------
Author: Nick Cantalupa
email: nmcant21@g.holycross.edu
Written: 9/28/19

This program converts a color image to a grayscale image and then saves it.

java Gray change.jpg

-----------------------------*/

import java.awt.Color;


public class Gray {

	public static void main(String[ ] args) {


        if (args.length != 1){
            System.out.println("You did not enter the correct number of arguements. Try again.");
            System.exit(0);
        }
                                          // Confirms the correct number of
                                          //arguements are entered.
                                          //Quits program otherwise. 
        

        Picture change = new Picture (args[0]);           //opens the image                   

        int w = change.width();                           //image width
        int h = change.height();                          //image height
        System.out.println("Your image has " + w*h + " pixels.");   //Tells how many pixels
                                                                    //your picture has

        

        for (int x=0; x < w; x++){
            for(int y=0; y < h; y++){
                Color pixel = change.get(x,y);

                int red = pixel.getRed();                    //red intensity
                int green = pixel.getGreen();                //green intensity
                int blue = pixel.getBlue();                  //blue intensity

                double luminance = (0.299 * red) + (0.587 * green) + (0.114 * blue);
                int g = (int)luminance;                      //luminance equation
                    
                Color gray = new Color (g, g, g);            //Creates gray
                change.set(x,y,gray);                        //sets pixel to gray


                }
            }

        change.save("grayscale.jpg");    
        change.show();
        
        

        
    }
}
