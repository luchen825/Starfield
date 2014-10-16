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

public class Starfield extends PApplet {

Particle [] one;
public void setup()
{
	size(600,600);
	one = new Particle[101];
	for(int i=0; i < 100; i++)
	{
		one[i] = new NormalParticle();
	}
	//one[99] = new Jumbo();
	one[100] = new OddballParticle();
}
public void draw()
{
	fill(0,30);
	rectMode(LEFT);
	rect(0,0,600,600);
	for(int i=0; i < one.length; i++)
	{
		one[i].move();
		one[i].show();
	}
	
}
public void mousePressed()
{
	for(int j=0; j < 100; j++)
	{
		((NormalParticle)one[j]).xNPos = mouseX;
		((NormalParticle)one[j]).yNPos = mouseY;
		//((NormalParticle)one[j]).angle = ((NormalParticle)one[j]).angle + 1;
	}
}
class NormalParticle implements Particle
{
	int r1, g1, b1;
	double xNPos, yNPos, speed, angle;
	NormalParticle()
	{
		xNPos = 300;
		yNPos = 300;
		speed = Math.random()*3;
		angle = Math.random()*2*PI;
		r1 = (int)(Math.random()*256);
		g1 = (int)(Math.random()*256);
		b1 = (int)(Math.random()*256);
	}
	public void move()
	{
		xNPos = xNPos + (Math.cos(angle))*speed;
		yNPos = yNPos + (Math.sin(angle))*speed;
		angle = angle + 0.01f;
	}
	public void show()
	{
		noStroke();
		fill(r1,g1,b1);
		ellipse((float)xNPos,(float)yNPos,20,20);
	}

}
interface Particle
{
	public void move();
	public void show();		
}
class OddballParticle implements Particle
{
	int r2, g2, b2;
	double xOPos, yOPos, speedO, angleO;
	OddballParticle()
	{
		r2 = (int)(Math.random()*256);
		g2 = (int)(Math.random()*256);
		b2 = (int)(Math.random()*256);
		xOPos = 300;
		yOPos = 300;;
	}
	public void move()
	{
		xOPos = mouseX;
		yOPos = mouseY;
	}
	public void show()
	{
		noStroke();
		fill(r2,g2,b2);
		rectMode(CENTER);
		rect((float)xOPos,(float)yOPos,30,30);
	}
}
// class Jumbo implements Particle
// {
// 	int r1, g1, b1;
// 	double xNPos, yNPos, speed, angle;
// 	Jumbo()
// 	{
// 		xNPos = 300;
// 		yNPos = 300;
// 		speed = Math.random()*2;
// 		angle = Math.random()*2*PI;
// 		r1 = (int)(Math.random()*256);
// 		g1 = (int)(Math.random()*256);
// 		b1 = (int)(Math.random()*256);
// 	}
// 	public void move()
// 	{
// 		xNPos = xNPos + (Math.cos(angle))*speed;
// 		yNPos = yNPos + (Math.sin(angle))*speed;
// 		angle = angle + 0.01;
// 	}
// 	public void show()
// 	{
// 		noStroke();
// 		fill(r1,g1,b1);
// 		ellipse((float)xNPos,(float)yNPos,100,100);
// 	}
// }


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
