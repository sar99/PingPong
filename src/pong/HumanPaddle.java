package pong;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {

	
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double DEACC = 0.94;
	
	public HumanPaddle(int player)
	{
		upAccel = false;
		downAccel = false;
		y = 210;
		yVel=0;
		
		if(player==1)
		{
			x = 20;
		}
		else
		{
			x = 660;
		}
	}
	
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
	}

	@Override
	public void move() {
		if(upAccel)
		{
			yVel -= 1;
		}
		else if(downAccel)
		{
			yVel+=1;
		}
		else
		{
			yVel*=DEACC;
		}
		if(yVel>=5)
		{
			yVel = 5;
		}
		if(yVel<=-5)
		{
			yVel = -5;
		}
		y += yVel;
		
		if(y<0) y = 0;
		if(y>420) y = 420;
	}

	public void setUpAccel(Boolean input)
	{
		upAccel = input;
	}
	
	public void setDownAccel(Boolean input)
	{
		downAccel = input;
	}
	
	
	@Override
	public int getY() {
		return (int)y;
	}

}
