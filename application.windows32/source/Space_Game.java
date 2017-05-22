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

public class Space_Game extends PApplet {

PImage earth;
PImage alienShip;
int fired, points;
int lx1, lx2, ly1, ly2;
Spaceship s1;
Bullet[] b = new Bullet[150];

public void setup() {
  
  frameRate(60);
  noCursor();
  earth = loadImage("earth.png");
  alienShip = loadImage("UFO.png");
  s1 = new Spaceship(mouseX, mouseY);
  for (int i = 0; i<b.length; i++) {
    b[i] = new Bullet(PApplet.parseInt(random(width)), PApplet.parseInt(random(-30000, 100)), 5);
    fired=1;
  }
}

public void draw() {
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

public void mousePressed() {
  s1.shoot();
  fired++;
}

public void display() {
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
  text("Lasers Fired: " + PApplet.parseInt(fired), 0, 790);
  text("Missiles Destroyed: " + PApplet.parseInt(points), 375, 790);
}

public void gameOver() {
  background(0xff2140B7);
  textSize(24);
  textAlign(CENTER, CENTER);
  text("Congratulations!", 250, 300);
  textSize(12);
  text("You have successfully defended Earth!", 250, 400);
  text("Times laser was fired: " + PApplet.parseInt(fired), 250, 600);
  text("Enemy missiles destroyed: " + PApplet.parseInt(points), 250, 625);
  text("Giving you an ammo efficiency ratio of: " + PApplet.parseInt(points/fired), 250, 650);
  noLoop();
}
class Bullet {
  //Class Variables
  int xpos, ypos, hp, speed;
  boolean inPlay;

  //Constructor
  Bullet(int xpos, int ypos, int speed) {
    this.xpos=xpos;
    this.ypos=ypos;
    hp = 2;
    this.speed = speed;
    inPlay=true;
  }

  //Display Method
  public void display() {
    fill(0xffFFAB03);
    ellipse(xpos+5, ypos, 5, 20);
    fill(128);
    rect(xpos, ypos, 10, 40);
    fill(255, 0, 0);
    stroke(0);
    triangle(xpos, ypos+40, xpos+10, ypos+40, xpos+5, ypos+50);
    triangle(xpos, ypos, xpos-5, ypos, xpos, ypos+10);
    triangle(xpos+10, ypos, xpos+15, ypos, xpos+10, ypos+10);
    for (int i = 0; i<b.length; i++) {
    }
  }

  //boolean destroy() {
  //  boolean isDestroyed = false;
  //  if () {
  //    inPlay = false;
  //    speed = 0;
  //    xpos=-1000000;
  //    ypos=-1000000;
  //    points++;
  //  }
  //  return isDestroyed;
  //}
}
class Spaceship {
  //Class Variables
  int x, y;

  //Constructor
  Spaceship(int x, int y) {
    this.x=x;
    this.y=y;
  }

  //Display Method
  public void display(int x, int y) {
    strokeWeight(1);
    fill(100, 0, 0);
    quad(x-15, y-15, x+15, y+15, x-15, y+15, x+15, y-15);
    fill(0, 200, 150);
    stroke(8);
    triangle(x+15, y+15, x+30, y+15, x+17, y-50);
    triangle(x-15, y+15, x-30, y+15, x-17, y-50);
    fill(0, 255, 232);
    quad(x-10, y+15, x-10, y+20, x+10, y+20, x+10, y+15);
    fill(255, 0, 0);
    triangle(x, y-25, x+7, y-15, x-7, y-15);
    fill(150);
    quad(x-40, y, x+40, y, x-10, y+25, x+10, y+25);
    point(x-35, y-10);
    strokeWeight(3);
    stroke(0xff0525A2);
    line(x-35, y, x-35, y-10);
    line(x+35, y, x+35, y-10);
    strokeWeight(1);
    stroke(0);
  }

  public void shoot() {
    x=mouseX;
    y=mouseY;
    strokeWeight(2);
    stroke(0xffFFB700);
    line(x-35, y-10, x-35, y-110);
    line(x+35, y-10, x+35, y-110);
  }
}
  public void settings() {  size (500, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Space_Game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
