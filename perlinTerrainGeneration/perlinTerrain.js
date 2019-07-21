var zoff = 0.0;

function setup() {
  createCanvas(window.innerWidth, window.innerHeight);
  // createCanvas(640,360);
  generateNoise();
}

function draw() {
  // background(0);
  zoff += 0.01;
  // generateNoise();
}

// fun

function generateNoise() {
  var xoff = 0.0;

  let x,y;
  for (x = 0; x < width; x++ ) {
    var yoff = 0.0;
    for (y = 0; y < height; y++ ) {
      var bright = map(noise(xoff,yoff,zoff), 0, 1, 0, 4);
    
      if (bright < 1.6) { // water
        //pixels[x+y*width] = color(103,200,224);
        stroke(103,200,224);
        point(x, y);
      } else if (bright >= 1.6 && bright < 1.8) { // sand
        //pixels[x+y*width] = color(229,234,180);
        stroke(229,234,180);
        point(x, y);
      } else if (bright >= 1.8 && bright < 2.3) { // greenery
        //pixels[x+y*width] = color(58,178,80);
        stroke(58,178,80);
        point(x, y);
      } else if (bright >= 2.3 && bright < 2.7) { // mountain brown
        //pixels[x+y*width] = color(68,71,56);
        stroke(68,71,56);
        point(x, y);
      } else { // snowline
        //pixels[x+y*width] = color(255);
        stroke(255);
        point(x, y);
      }
      yoff += 0.01;
    }
    xoff += 0.01;
  }
}
