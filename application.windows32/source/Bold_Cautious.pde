wall[] walls;
int playerXR = 20;
int playerYR = 20;
int isStart = 0;
int isGameOver = 0;
int isFirst = 1;
int isWin = 0;

void setup() {
  size(500, 500);
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

void mouseClicked() {
  if(mouseX >= 20 && mouseX <= 40 && mouseY >= 20 && mouseY <= 40) {
    isStart = 1;
  }
  if(isWin == 1) {
    isWin = 0;
    isFirst = 1;
  }
    
  }
void draw() {
  background(0); 
  noStroke();
  PFont myFont = createFont("草泥马体", 32);
  println(mouseX,mouseY);
  //win window
     
     for(int i = 0; i < walls.length; i++){
    walls[i].draw();
  }
  
  fill(255);
  textSize(18);
  text("目的地",438,20);
  if (isStart == 1 && isGameOver == 0 && isWin == 0) {
    isFirst = 0;
    //NO.1
    if(mouseX >= walls[0].x+walls[0].w && mouseX <= walls[1].x) {
      playerXR = 20;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("去目的地喽～",25,450);
      println("NO.1");
    }
    //NO.2
    if(mouseX >= walls[1].x+walls[1].w && mouseX <= walls[2].x) {
      playerXR = 20;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("真简单！",25,450);
      println("NO.2");
    }
    //NO.3
    if(mouseX >= walls[2].x+walls[2].w && mouseX <= walls[3].x) {
      playerXR = 35;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("安乐使人..….我变胖了！",25,450);
      println("NO.3");
    }
    //NO.4
    if(mouseX >= walls[3].x+walls[3].w && mouseX <= walls[4].x) {
      playerXR = 58;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("更胖了.....走路好困难啊……",25,450);
      println("NO.4");
    }
    //NO.5
    if(mouseX >= walls[4].x+walls[4].w && mouseX <= walls[5].x && mouseY <= 200) {
      playerXR = 56;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("我要减肥！！！!",25,450);
      println("NO.5");
    }
    if(mouseX >= walls[4].x+walls[4].w && mouseX <= walls[5].x && mouseY > 200 && mouseY < 250) {
      playerXR = 50;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("我要减肥！！！!",25,450);
      println("NO.5");
    }
    if(mouseX >= walls[4].x+walls[4].w && mouseX <= walls[5].x && mouseY > 250) {
      playerXR = 45;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("我要减肥！！！!",25,450);
      println("NO.5");
    }
    //NO.6
    if(mouseX >= walls[5].x+walls[5].w && mouseX <= 500) {
      playerXR = 20;
      playerYR = 20;
      textSize(20);
      fill(255,255,0);
      text("减肥成功！同样的路，走起来都更轻松了！",25,450);
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
      text("我是小紫，我要到达目的地！点击我开始！",25,460);
    } else {
      text("再来一次吧！不要碰到墙壁哦！",25,460);
    }
    isGameOver = 0;
    isStart = 0;
  }else if (isWin == 1) {
    fill(0);
    rect(0,0,500,500);
    textSize(20);
    fill(255,255,0);
    text("恭喜你胜利了！\n\n不管怎样\n祝愿大家可以拥有一个健康的身体！",25,150);
    textSize(11);
    fill(255,255,0);
    text("点击再玩一次",25,460);
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
  void draw() {
    fill(255);
    rect(x,y,w,h);
  }
}

void judge() {
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