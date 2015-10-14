package processing.test.android_3;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ketai.ui.*; 
import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Android_3 extends PApplet {



ControlP5 cp5;

int[] positionsX = new int[100];
int[] positionsY = new int [100];
int sliderValue =0;

Slider slide;

int i = 0;
KetaiList selectionList;
ArrayList<String> colorlist = new ArrayList<String>();
int back = color(0,0,0);

public void setup(){
  orientation(PORTRAIT);
  textSize(28);
  textAlign(CENTER);
  colorlist.add("Yellow");
  colorlist.add("Green");
  colorlist.add("White");
  colorlist.add("Red");
  colorlist.add("Blue");
  background(0xff000000);   

}
public void draw(){
  drawUI();
   positionsX = append(positionsX, mouseX);
   positionsY = append(positionsY, mouseY);
   
  for(int j=0; j < positionsX.length; j++){
      int distance = PApplet.parseInt(dist(positionsX[j], positionsY[j],mouseX, mouseY));
      float r = random(0, 100);
      if(distance < 100 && r < 80)  line(positionsX[j],positionsY[j],mouseX, mouseY);
  }
}

public void mousePressed()
{
  if (mouseY < 100)
  {
    if (mouseX < width/3)
     selectionList = new KetaiList(this, colorlist);
    else if (mouseX > width/3 && mouseX < width-(width/3))
     erase();
  }
    
}

public void drawUI(){
  pushStyle();
  textAlign(LEFT);
  fill(0);
  stroke(255);
  rect(0, 0, width/3, 100);
  rect(width/3, 0, width/3, 100);
  fill(255);
  text("Stroke Color",5, 60); 
  text("Clear", width/3 + 5, 60); 
  popStyle();
}
public void onKetaiListSelection(KetaiList klist)
{
  String selection = klist.getSelection();
  if (selection == "Yellow")
   stroke(255,255,0,7);    
  else if (selection == "Green")
    stroke(131,280,37,7);
  else if (selection == "White")
    stroke(255,255,255,7);
  else if (selection == "Red")
   stroke(255,0,0,7);
  else if (selection == "Blue")
    stroke(51,153,255,7);
}
public void erase(){
  background(back);
}


  

  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Android_3" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
