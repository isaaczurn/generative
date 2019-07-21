import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class perlinTerrainGeneration extends PApplet {

float zoff = 0.0f;

public void setup() {
  
  generateNoise();
  noiseDetail(6);
}

public void generateNoise() {
  loadPixels();
  
  float xoff = 0.0f;
  
  for (int x = 0; x < width; x++) {
    float yoff = 0.0f;
    for (int y = 0; y < height; y++) {
      float bright = map(noise(xoff,yoff, zoff), 0,1,0,4);
      if (bright < 1.6f) { // water
        pixels[x+y*width] = color(103,200,224);
      } else if (bright >= 1.6f && bright < 1.8f) { // sand
        pixels[x+y*width] = color(229,234,180);
      } else if (bright >= 1.8f && bright < 2.3f) { // greenery
        pixels[x+y*width] = color(58,178,80);  
      } else if (bright >= 2.3f && bright < 2.7f) { // mountain brown
        pixels[x+y*width] = color(68,71,56);  
      } else { // snowline
        pixels[x+y*width] = color(255);  
      }
      //pixels[x+y*width] = color(bright);
      yoff += 0.01f;
    }
    xoff += 0.01f;
  }
  updatePixels();
}

public void draw() {
 zoff += 0.01f;
 generateNoise();
}
  public void settings() {  size(640,360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "perlinTerrainGeneration" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
