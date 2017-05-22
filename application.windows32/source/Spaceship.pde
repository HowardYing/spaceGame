class Spaceship {
  //Class Variables
  int x, y;

  //Constructor
  Spaceship(int x, int y) {
    this.x=x;
    this.y=y;
  }

  //Display Method
  void display(int x, int y) {
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
    stroke(#0525A2);
    line(x-35, y, x-35, y-10);
    line(x+35, y, x+35, y-10);
    strokeWeight(1);
    stroke(0);
  }

  void shoot() {
    x=mouseX;
    y=mouseY;
    strokeWeight(2);
    stroke(#FFB700);
    line(x-35, y-10, x-35, y-110);
    line(x+35, y-10, x+35, y-110);
  }
}