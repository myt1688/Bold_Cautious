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

public class Bold_Cautious extends PApplet {

wall[] walls;
int playerXR = 20;
int playerYR = 20;
int isStart = 0;
int isGameOver = 0;
int isFirst = 1;
int isWin = 0;

public void setup() {
  
  frameRate(100);
  walls = new wall[8];
  walls[0] = new wall(0,0,10,400);//left 1
  walls[1] = new wall(50,0,30,350);//left 2
  walls[2] = new wall(120,35,30,365);//left 3
  walls[3] = new wall(200,0,30,360);// left 4
  walls[4] = new wall(300,35,30,365);// left 5
  walls[5] = new wall(400,0,30,360);// left 6
  walls[6] = new wall(0,400,500,10);//down 1
  walls[7] = new wall(50,0,370,2);//up 1
}

public void mouseClicked() {
  if(mouseX >= 20 && mouseX <= 40 && mouseY >= 20 && mouseY <= 40) {
    isStart = 1;
  }
  if(isWin == 1) {
    isWin = 0;
    isFirst = 1;
  }
    
  }
public void draw() {
  background(0); 
  noStroke();
  PFont myFont = createFont("\u8349\u6ce5\u9a6c\u4f53", 32);
  println(mouseX,mouseY);
  //win window
     
     for(int i = 0; i < walls.length; i++){
    walls[i].draw();
  }
  
  fill(255);
  textSize(18);
  text("\u76ee\u7684\u5730",438,20);
  if (isStart == 1 && isGameOver == 0 && isWin == 0) {
    isFirst = 0;
    //NO.1
    if(mouseX >= walls[0].x+walls[0].w && mouseX <= walls[1].x) {
      playerXR = 20;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u53bb\u76ee\u7684\u5730\u55bd\uff5e",25,450);
      println("NO.1");
    }
    //NO.2
    if(mouseX >= walls[1].x+walls[1].w && mouseX <= walls[2].x) {
      playerXR = 20;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u771f\u7b80\u5355\uff01",25,450);
      println("NO.2");
    }
    //NO.3
    if(mouseX >= walls[2].x+walls[2].w && mouseX <= walls[3].x) {
      playerXR = 35;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u5b89\u4e50\u4f7f\u4eba..\u2026.\u6211\u53d8\u80d6\u4e86\uff01",25,450);
      println("NO.3");
    }
    //NO.4
    if(mouseX >= walls[3].x+walls[3].w && mouseX <= walls[4].x) {
      playerXR = 58;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u66f4\u80d6\u4e86.....\u8d70\u8def\u597d\u56f0\u96be\u554a\u2026\u2026",25,450);
      println("NO.4");
    }
    //NO.5
    if(mouseX >= walls[4].x+walls[4].w && mouseX <= walls[5].x && mouseY <= 200) {
      playerXR = 56;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u6211\u8981\u51cf\u80a5\uff01\uff01\uff01!",25,450);
      println("NO.5");
    }
    if(mouseX >= walls[4].x+walls[4].w && mouseX <= walls[5].x && mouseY > 200 && mouseY < 250) {
      playerXR = 50;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u6211\u8981\u51cf\u80a5\uff01\uff01\uff01!",25,450);
      println("NO.5");
    }
    if(mouseX >= walls[4].x+walls[4].w && mouseX <= walls[5].x && mouseY > 250) {
      playerXR = 45;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u6211\u8981\u51cf\u80a5\uff01\uff01\uff01!",25,450);
      println("NO.5");
    }
    //NO.6
    if(mouseX >= walls[5].x+walls[5].w && mouseX <= 500) {
      playerXR = 20;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("\u51cf\u80a5\u6210\u529f\uff01\u540c\u6837\u7684\u8def\uff0c\u8d70\u8d77\u6765\u90fd\u66f4\u8f7b\u677e\u4e86\uff01",25,450);
      println("NO.6");
    }
      
    fill(138,43,226);
    ellipse(mouseX,mouseY,playerXR,playerYR);
    judge();
    if (mouseX > 450 && mouseY < 19 && isStart == 1) {
      //textSize(40);
      //fill(255);
      //text("win!",320,450);
      isStart = 0;
      isWin = 1;
   }
  } else if (isWin == 0) {                                            // not start status
    fill(138,43,226);
    ellipse(30,30,playerXR,playerYR);
    textFont(myFont);
    textSize(20);
    fill(255,255,0);
    if(isFirst == 1) {
      text("\u6211\u662f\u5c0f\u7d2b\uff0c\u6211\u8981\u5230\u8fbe\u76ee\u7684\u5730\uff01\u70b9\u51fb\u6211\u5f00\u59cb\uff01",25,460);
    } else {
      text("\u518d\u6765\u4e00\u6b21\u5427\uff01\u4e0d\u8981\u78b0\u5230\u5899\u58c1\u54e6\uff01",25,460);
    }
    isGameOver = 0;
    isStart = 0;
  }else if (isWin == 1) {
    fill(0);
    rect(0,0,500,500);
    textSize(20);
    fill(255,255,0);
    text("\u606d\u559c\u4f60\u80dc\u5229\u4e86\uff01\n\n\u4e0d\u7ba1\u600e\u6837\n\u795d\u613f\u5927\u5bb6\u53ef\u4ee5\u62e5\u6709\u4e00\u4e2a\u5065\u5eb7\u7684\u8eab\u4f53\uff01",25,150);
    textSize(11);
    fill(255,255,0);
    text("\u70b9\u51fb\u518d\u73a9\u4e00\u6b21",25,460);
  }
  
  
}
   
  
  
 
class wall {
  float x;
  float y;
  float w;
  float h;
  wall(float _x, float _y, float _w, float _h) {
    x = _x;
    y = _y;
    w = _w;
    h = _h;
  }
  public void draw() {
    fill(255);
    rect(x,y,w,h);
  }
}

public void judge() {
  for(int i = 0; i < walls.length; i++){
    if (mouseX+playerXR/2 >= walls[i].x && mouseX-playerXR/2 <= walls[i].x+walls[i].w && mouseY+playerYR/2 >= walls[i].y && mouseY-playerYR/2 <= walls[i].y+walls[i].h) {
      println("touch!!!");
      textSize(40);
      fill(255);
      text("touch!!!",220,450);
      isGameOver = 1;
      playerXR = 20;
      playerYR = 20;
    }
  }
}
  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Bold_Cautious" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
