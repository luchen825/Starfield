Particle [] one;
void setup()
{
	size(600,600);
	one = new Particle[101];
	for(int i=0; i < 99; i++)
	{
		one[i] = new NormalParticle();
	}
	one[99] = new Jumbo();
	one[100] = new OddballParticle();
}
void draw()
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
void mousePressed()
{
	for(int j=0; j < 100; j++)
	{
		((NormalParticle)one[j]).xNPos = mouseX;
		((NormalParticle)one[j]).yNPos = mouseY;
	}
}
class NormalParticle implements Particle
{
	int r1, g1, b1, sizze;
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
		sizze = 20;
	}
	public void move()
	{
		xNPos = xNPos + (Math.cos(angle))*speed;
		yNPos = yNPos + (Math.sin(angle))*speed;
		angle = angle + 0.01;
	}
	public void show()
	{
		noStroke();
		fill(r1,g1,b1);
		ellipse((float)xNPos,(float)yNPos,sizze,sizze);
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
class Jumbo extends NormalParticle
{
	Jumbo()
	{
		sizze = 100;
	}
}


