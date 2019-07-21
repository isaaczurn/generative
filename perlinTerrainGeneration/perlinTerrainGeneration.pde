float zoff = 0.0;

void setup() {
  size(640,360);
  generateNoise();
  noiseDetail(6);
}

void generateNoise() {
  loadPixels();
  
  float xoff = 0.0;
  
  for (int x = 0; x < width; x++) {
    float yoff = 0.0;
    for (int y = 0; y < height; y++) {
      float bright = map(noise(xoff,yoff, zoff), 0,1,0,4);
      if (bright < 1.6) { // water
        pixels[x+y*width] = color(103,200,224);
      } else if (bright >= 1.6 && bright < 1.8) { // sand
        pixels[x+y*width] = color(229,234,180);
      } else if (bright >= 1.8 && bright < 2.3) { // greenery
        pixels[x+y*width] = color(58,178,80);  
      } else if (bright >= 2.3 && bright < 2.7) { // mountain brown
        pixels[x+y*width] = color(68,71,56);  
      } else { // snowline
        pixels[x+y*width] = color(255);  
      }
      //pixels[x+y*width] = color(bright);
      yoff += 0.01;
    }
    xoff += 0.01;
  }
  updatePixels();
}

void draw() {
 zoff += 0.01;
 generateNoise();
}
