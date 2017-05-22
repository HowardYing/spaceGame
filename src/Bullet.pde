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
  void display() {
    fill(#FFAB03);
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