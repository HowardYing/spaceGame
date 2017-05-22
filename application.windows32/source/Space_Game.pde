PImage earth;
PImage alienShip;
int fired, points;
int lx1, lx2, ly1, ly2;
Spaceship s1;
Bullet[] b = new Bullet[150];

void setup() {
  size (500, 800);
  frameRate(60);
  noCursor();
  earth = loadImage("earth.png");
  alienShip = loadImage("UFO.png");
  s1 = new Spaceship(mouseX, mouseY);
  for (int i = 0; i<b.length; i++) {
    b[i] = new Bullet(int(random(width)), int(random(-30000, 100)), 5);
    fired=1;
  }
}

void draw() {
  background(0);
  imageMode(CENTER);
  image(earth, 250, 900);
  if (frameCount<=6000) {
    for (int i = 0; i<b.length; i++) {
      b[i].display();
      b[i].ypos += b[i].speed;
    }
  } else {
    gameOver();
  }
  s1.display(mouseX, mouseY);
  image(alienShip, 250, 30);
  display();
}

void mousePressed() {
  s1.shoot();
  fired++;
}

void display() {
  noStroke();
  fill(50);
  rect(0, 775, 175, 25);
  rect(325, 775, 175, 25);
  triangle(175, 775, 175, 800, 200, 800);
  triangle(325, 775, 325, 800, 300, 800);
  fill(100);
  rect(0, 750, 100, 25);
  rect(400, 750, 175, 25);
  triangle(100, 750, 100, 775, 125, 775);
  triangle(400, 750, 400, 775, 375, 775);
  fill(255);
  text("Lasers Fired: " + int(fired), 0, 790);
  text("Missiles Destroyed: " + int(points), 375, 790);
}

void gameOver() {
  background(#2140B7);
  textSize(24);
  textAlign(CENTER, CENTER);
  text("Congratulations!", 250, 300);
  textSize(12);
  text("You have successfully defended Earth!", 250, 400);
  text("Times laser was fired: " + int(fired), 250, 600);
  text("Enemy missiles destroyed: " + int(points), 250, 625);
  text("Giving you an ammo efficiency ratio of: " + int(points/fired), 250, 650);
  noLoop();
}