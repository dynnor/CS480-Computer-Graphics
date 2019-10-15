//****************************************************************************
// SketchBase.  
//****************************************************************************
// Comments : 
//   Subroutines to manage and draw points, lines an triangles
//
// History :
//   Aug 2014 Created by Jianming Zhang (jimmie33@gmail.com) based on code by
//   Stan Sclaroff (from CS480 '06 poly.c)



// Dynnor Shebshaievitz (dynnor@bu.edu)
// CS480 PA1
// Due: September 24th, 2019 



import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SketchBase 
{
	public SketchBase()
	{
		// deliberately left blank
	}
	
	// draw a point
	public static void drawPoint(BufferedImage buff, Point2D p)
	{
		buff.setRGB(p.x, buff.getHeight()-p.y-1, p.c.getBRGUint8());
	}
	
	//////////////////////////////////////////////////
	//	Implement the following two functions
	//////////////////////////////////////////////////
	
	// draw a line segment
	public static void drawLine(BufferedImage buff, Point2D p1, Point2D p2)
	{
		// replace the following line with your implementation
				//drawPoint(buff, p2);
				
				//want to implement Bresham's line algorithm 
				//declare all variables for the equation: need x and y (start and end)
				/*
				 * Basic plan:
				 * need a variable for each color r,g,b have a start and end 
				 * need slope of the line m 
				 * need to know the direction of the line going up, down, left or right 
				 * change of all the variables (delta)
				 * once declare all the variables we need then can implement all the 
				 * possible cases/algorithm
				 * - use floats for the pixel colors 
				 * have a couple of equations- slope (m) and then the actual algo
				 */
				//
				
		int start_x = p1.x; //first point of x 
		int end_x = p2.x; //end point of x
		int start_y = p1.y; //start of y 
		int end_y = p2.y;//end of y 
		
		//need to use float points for the r,g,b values 
		//need start and end values because we need to keep track of the change in their values 
		//will be using these for delta 
		float start_r = p1.c.r; 
		float end_r = p2.c.r;
		float start_g = p1.c.g;
		float end_g = p2.c.g;
		float start_b = p1.c.b;
		float end_b = p2.c.b;
		
		//m will be the slope for the lines 
		float slope = ((float)(end_y - start_y)/(float)(end_x - start_x));
		
		//use boolean values to denote the nature of the line
		//is the line going up, down, to the right left... etc 
		boolean up = (end_y < start_y); //if it's going up 
		boolean right = (end_x > start_x); //line is going to the right 
		boolean large_slope = (Math.abs(slope)>1); 
		//when have a large slope harder to have that stair effect (have to keep that in mind) 
		
		
		if (!large_slope && right) {
			//have to keep track of our error 
			//will have an error for each case 
			float error = 0;
			int x = start_x;
			int y = start_y;
			float len = end_x - start_x;
			float delta_r = (end_r - start_r)/len; //change in r 
			float delta_g = (end_g - start_g)/len; //change in g
			float delta_b = (end_b - start_b)/len;//change in b 
			ColorType c = new ColorType(start_r, start_g, start_b);
			
			while (x <= end_x) {
				Point2D p = new Point2D(x, y, c);
				drawPoint(buff, p);
				x++;
				c.r += delta_r;
				c.g += delta_g;
				c.b += delta_b;
				
				if (error+Math.abs(slope)<0.5) {
					error = error+Math.abs(slope);
				} else {
					if (up) {
						y--;
					} else {
						y++;
					}
					error = error+Math.abs(slope)-1;
				}	
			}
		} else if (!large_slope && !right) {
			//need to use the abs function to account for a negative slope 
			//because in this case the line will be going to the left 
				float error=0;
				int x = start_x;
				int y = start_y;
				float len = end_x - start_x;
				float delta_r = (end_r - start_r)/Math.abs(len);
				float delta_g = (end_g - start_g)/Math.abs(len);
				float delta_b = (end_b - start_b)/Math.abs(len);
				ColorType c = new ColorType(start_r, start_g, start_b);
				while (x >= end_x) {
					Point2D p = new Point2D(x, y, c);
					drawPoint(buff, p);
					x--;
					c.r += delta_r;
					c.g += delta_g;
					c.b += delta_b;
					if (error+Math.abs(slope)<0.5) {
						error = error+Math.abs(slope);
					} else {
						if (up) {
							y--;
						} else {
							y++;
						}
						error = error+Math.abs(slope)-1;
					}	
				}
		} else if (large_slope && !up) {
			float error=0;
			int x = start_x;
			int y = start_y;
			float len = end_y - start_y;
			float delta_r = (end_r - start_r)/Math.abs(len);
			float delta_g = (end_g - start_g)/Math.abs(len);
			float delta_b = (end_b - start_b)/Math.abs(len);
			ColorType c = new ColorType(start_r, start_g, start_b);
			while (y <= end_y) {
				Point2D p = new Point2D(x, y, c);
				drawPoint(buff, p);
				y++;
				c.r += delta_r;
				c.g += delta_g;
				c.b += delta_b;
				if (error+(1/Math.abs(slope))<0.5) {
					error = error+(1/Math.abs(slope));
				} else {
					if (right) {
						x++;
					} else {
						x--;
					}
					error = error+(1/Math.abs(slope))-1;
				}	
			}
		} else if (large_slope && up) {
			float error=0;
			int x = start_x;
			int y = start_y;
			float len = end_y - start_y;
			float delta_r = (end_r - start_r)/Math.abs(len);
			float delta_g = (end_g - start_g)/Math.abs(len);
			float delta_b = (end_b - start_b)/Math.abs(len);
			ColorType c = new ColorType(start_r, start_g, start_b);
			while (y >= end_y) {
				Point2D p = new Point2D(x, y, c);
				drawPoint(buff, p);
				y--;
				c.r += delta_r;
				c.g += delta_g;
				c.b += delta_b;
				if (error+(1/Math.abs(slope))<0.5) {
					error = error+(1/Math.abs(slope));
				} else {
					if (right) {
						x++;
					} else {
						x--;
					}
					error = error+(1/Math.abs(slope))-1;
				}	
			}
		}
	}

	private static Point2D Point2D(int x, int y, ColorType c) {
		// TODO Auto-generated method stub
		return null;
	}

	
	// draw a triangle
	public static void drawTriangle(BufferedImage buff, Point2D p1, Point2D p2, Point2D p3, boolean do_smooth)
	{
		// replace the following line with your implementation
				//drawPoint(buff, p3);
				/*
				 * Basic Plan:
				 * There are two types of triangles - there are regular 
				 * triangles and then special cases (equilateral triangle) . 
				 * have to calculate the slope and fill different parts of the triangle 
				 * (will comment more throughout the code)
				 * need to cut triangle for interpolation 
				 *  
				 */
				
				//declare the variables that we will need 

		int x1, x2, x3, y1, y2, y3;
		ColorType c = p1.c;
		
		//The first case we want to consider is regular triangles 
		//for regular triangles
		
		if (p1.y!=p2.y && p1.y!=p3.y && p2.y!=p3.y && p1.x!=p2.x && p1.x!=p3.x && p2.x!=p3.x) {
			
			//order vertices so that "bottom" will be  p1, "middle" will be p2, and "top" will be p3
			Point2D bottom, middle, top;
			
			//6 possible cases we need to consider 
			
			if ((p1.y < p2.y) && (p2.y < p3.y)) {
				bottom = p3;
				middle = p2;
				top = p1;
			} else if ((p2.y < p1.y) && (p1.y < p3.y)) {
				bottom = p3;
				middle = p1;
				top = p2;
			} else 	if ((p3.y < p2.y) && (p2.y < p1.y)) {
				bottom = p1;
				middle = p2;
				top = p3;
			} else if ((p2.y < p3.y) && (p3.y < p1.y)) {
				bottom = p1;
				middle = p3;
				top = p2;
			} else if ((p1.y < p3.y) && (p3.y < p2.y)) {
				bottom = p2;
				middle = p3;
				top = p1;
			} else {
				bottom = p2;
				middle = p1;
				top = p3;
			}
			
			x1 = bottom.x;
			y1 = bottom.y;
			
			x2 = middle.x;
			y2 = middle.y;
			
			x3 = top.x;
			y3 = top.y;
			
			//rgb values in relationship to the vertices 
			float r_1= bottom.c.r;
			float g_1 = bottom.c.g;
			float b_1 = bottom.c.b;
			
			float r_2= middle.c.r;
			float g_2 = middle.c.g;
			float b_2 = middle.c.b;
			
			float r_3= top.c.r;
			float g_3 = top.c.g;
			float b_3 = top.c.b;
			
			//calculate slopes of all lines
			
			//slope for points (x1, y1) and (x3, y3)
			float slope1and3 = ((float)(y3 - y1)/(float)(x3 - x1));
			
			//slope for points (x2, y2) and (x1, y1)
			float slope1and2 = ((float)(y2 - y1)/(float)(x2 - x1));
			
			//slope for points (x3, y3) and (x2, y2)
			float slope2and3 = ((float)(y3 - y2)/(float)(x3 - x2));
			
			//now we can fill in the triangle (do the bottom and then the top) 
			
			//fill in the bottom half of the triangle 
			//for all the triangles need to consider the change in rgb colors
			//because we are filling the triangle and then we also need to 
			//consider the lengths of the line- because they are the boundaries 
			//of where we are going to fill 
			
			for (int y = y1; y>=y2; y--){ //y1 is the bottom and y2 is the middle
				
				int startx = Math.round((y-y1+slope1and2*x1)/slope1and2);
				int endx = Math.round((y-y1+slope1and3*x1)/slope1and3);
				
				if (do_smooth) {
					//do smooth is what helps us fill in the triangle behavior 
					//if do_smooth is true then we do smooth bilinear interpolation 
					float len_1and2 = y1-y2;
					
					float delta_r1and2 = (r_2 - r_1)/len_1and2;
					float delta_g1and2 = (g_2 - g_1)/len_1and2;
					float delta_b1and2 = (b_2 - b_1)/len_1and2;
					
					float start_r = r_1 + delta_r1and2*(y1-y);
					float start_g = g_1 + delta_g1and2*(y1-y);
					float start_b = b_1 + delta_b1and2*(y1-y);
					
					float len_1and3 = y1-y3;
					
					float delta_r1and3 = (r_3 - r_1)/len_1and3;
					float delta_g1and3 = (g_3 - g_1)/len_1and3;
					float delta_b1and3 = (b_3 - b_1)/len_1and3;
					
					float end_r = r_1 + delta_r1and3*(y1-y);
					float end_g = g_1 + delta_g1and3*(y1-y);
					float end_b = b_1 + delta_b1and3*(y1-y);
					
					ColorType start_c = new ColorType(start_r, start_g, start_b);
					ColorType end_c = new ColorType(end_r, end_g, end_b);
					
					drawLine(buff, new Point2D(startx,y,start_c), new Point2D(endx,y,end_c));				
				} else {
					drawLine(buff, new Point2D(startx,y,c), new Point2D(endx,y,c));
				}
			}
			//fill in the top half
			for (int y = y2-1; y>=y3; y--) { //y2 is the middle and y3 is the top
				
				if (do_smooth) {
					
					float len_2and3 = y2-y3;
					
					float delta_r2and3 = (r_3 - r_2)/len_2and3;
					float delta_g2and3 = (g_3 - g_2)/len_2and3;
					float delta_b2and3 = (b_3 - b_2)/len_2and3;
					
					float start_r = r_2 + delta_r2and3*(y2-1-y);
					float start_g = g_2 + delta_g2and3*(y2-1-y);
					float start_b = b_2 + delta_b2and3*(y2-1-y);
					
					float len_1and3 = y1-y3;
					
					float delta_r1and3 = (r_3 - r_1)/len_1and3;
					float delta_g1and3 = (g_3 - g_1)/len_1and3;
					float delta_b1and3 = (b_3 - b_1)/len_1and3;
					
					float end_r = r_1 + delta_r1and3*(-1-y+y1);
					float end_g = g_1 + delta_g1and3*(-1-y+y1);
					float end_b = b_1 + delta_b1and3*(-1-y+y1);
					
					ColorType start_c = new ColorType(start_r, start_g, start_b);
					ColorType end_c = new ColorType(end_r, end_g, end_b);
					
					drawLine(buff, new Point2D(Math.round((y-y2+slope2and3*x2)/slope2and3),y,start_c), new Point2D(Math.round((y-y1+slope1and3*x1)/slope1and3),y,end_c));	
				
				} else {
					drawLine(buff, new Point2D(Math.round((y-y2+slope2and3*x2)/slope2and3),y,c), new Point2D(Math.round((y-y1+slope1and3*x1)/slope1and3),y,c));
				}
			}
		}
		//special case triangles
		//think about: points are the same, consider right triangles, equialateral? 
		
		//very similar to the bottom, top and middle but this time lable based
		//on the sides of the triangle 
		
		// will have the "right side" because of the angle, "long side"= hypot 
		//and then the last side will be the shorter side 
		
		else if (p1.x==p2.x || p2.x==p3.x || p1.x==p3.x) {
			//vertical line
			if (p1.y==p2.y || p2.y==p3.y || p1.y==p3.y) {
				//right angle
				int rx, ry, sx, sy, lx, ly;
				Point2D right, short_side, long_side;
				if (p1.x==p2.x && p1.y==p3.y) {
					right=p1;
					short_side = p2;
					long_side = p3;
				} else if (p1.x==p2.x && p2.y==p3.y) {
					right = p2;
					short_side = p1;
					long_side = p3;
				} else if (p2.x==p3.x && p1.y==p3.y) {
					right = p3;
					short_side = p2;
					long_side = p1;
				} else {
					right = p2;
					short_side = p3;
					long_side = p1;
				}
				
				rx=right.x;
				ry=right.y;
				
				sx=short_side.x;
				sy=short_side.y;
				
				lx=long_side.x;
				ly=long_side.y;
				
				float r_r= right.c.r;
				float g_r = right.c.g;
				float b_r = right.c.b;
				
				float r_s= short_side.c.r;
				float g_s = short_side.c.g;
				float b_s = short_side.c.b;
				
				float r_l= long_side.c.r;
				float g_l = long_side.c.g;
				float b_l = long_side.c.b;
				
				//calculate slope
				float slope = ((float)(ly - sy)/(float)(lx - sx));
				
				//fill in triangle
				if (ry>ly) { //if the length of the "right side" is larger than or equal to  "the long side"
					for (int y=ry; y>=ly; y--) {
						if (do_smooth) {
							
							float len = ry-ly;
							
							float delta_r_randl = (r_l - r_r)/len; 
							float delta_g_randl = (g_l - g_r)/len;
							float delta_b_randl = (b_l - b_r)/len;
							
							float start_r = r_r + delta_r_randl*(ry-y);
							float start_g = g_r + delta_g_randl*(ry-y);
							float start_b = b_r + delta_b_randl*(ry-y);
							
							float delta_rsl = (r_l - r_s)/len; //now have to use the short side 
							float delta_gsl = (g_l - g_s)/len; //so we can see the comparison 
							float delta_bsl = (b_l - b_s)/len;// when we draw a new line 
							
							float end_r = r_s + delta_rsl*(ry-y);
							float end_g = g_s + delta_gsl*(ry-y);
							float end_b = b_s + delta_bsl*(ry-y);
							
							ColorType start_c = new ColorType(start_r, start_g, start_b);
							ColorType end_c = new ColorType(end_r, end_g, end_b);
							
							drawLine(buff, new Point2D(rx,y,start_c), new Point2D(Math.round((y-sy+slope*sx)/slope),y,end_c));	
						} else {
							drawLine(buff, new Point2D(rx,y,c), new Point2D(Math.round((y-sy+slope*sx)/slope),y,c));
						}
					}
				} else {
					for (int y=ry; y<=ly; y++) { //right side is less than or equal to the longest side 
						if (do_smooth) {
							
							float len = ry-ly;
							
							float delta_r_randl = (r_l - r_r)/len;
							float delta_g_randl = (g_l - g_r)/len;
							float delta_b_randl = (b_l - b_r)/len;
							
							float start_r = r_r + delta_r_randl*(y-ry);
							float start_g = g_r + delta_g_randl*(y-ry);
							float start_b = b_r + delta_b_randl*(y-ry);
							
							float delta_r_sandl = (r_l - r_s)/len;
							float delta_g_sandl = (g_l - g_s)/len;
							float delta_b_sandl = (b_l - b_s)/len;
							
							float end_r = r_s + delta_r_sandl*(y-ry);
							float end_g = g_s + delta_g_sandl*(y-ry);
							float end_b = b_s + delta_b_sandl*(y-ry);
							
							ColorType start_c = new ColorType(start_r, start_g, start_b);
							ColorType end_c = new ColorType(end_r, end_g, end_b);
							
							drawLine(buff, new Point2D(rx,y,start_c), new Point2D(Math.round((y-sy+slope*sx)/slope),y,end_c));	
						} else {
						drawLine(buff, new Point2D(rx,y,c), new Point2D(Math.round((y-ly+slope*lx)/slope),y,c));
					}
				}
			}
		} else {
			
			//another case we need to consider is a triangle that's a "vertical line"
			//2 points have to be the same 
			//vertical line, but not a right triangle
			
			Point2D bottom, middle, top;
			
			if (p1.x==p2.x) {
				middle = p3;
				if (p1.y>p2.y) {
					bottom = p1;
					top = p2;
				} else {
					top = p1;
					bottom = p2;
				}
			} else if (p1.x==p3.x) {
				middle = p2;
				if (p1.y>p3.y) {
					bottom = p1;
					top = p3;
				} else {
					top = p1;
					bottom = p3;
				}
			} else {
				middle = p1;
				if (p3.y>p2.y) {
					bottom = p3;
					top = p2;
				} else {
					top = p3;
					bottom = p2;
				}
			}
			
			x1 = bottom.x;
			y1 = bottom.y;
			
			x2 = middle.x;
			y2 = middle.y;
			
			x3 = top.x;
			y3 = top.y;
			
			float r_1 = bottom.c.r;
			float g_1 = bottom.c.g;
			float b_1 = bottom.c.b;
			
			float r_2 = middle.c.r;
			float g_2 = middle.c.g;
			float b_2 = middle.c.b;
			
			float r_3 = top.c.r;
			float g_3 = top.c.g;
			float b_3 = top.c.b;
			
			//calculate slope
			float slope1and2 = ((float)(y2 - y1)/(float)(x2 - x1));
			float slope2and3 = ((float)(y3 - y2)/(float)(x3 - x2));
			
			//fill in the bottom half
			
			for (int y = y1; y>=y2; y--){
				
				int end_x = Math.round((y-y1+slope1and2*x1)/slope1and2);
				int start_x = x1;
				
				if (do_smooth) {
					
					float len_1and2 = y1-y2; //subtracting the "bottom" from the "middle"
					
					float delta_r_1and2 = (r_2 - r_1)/len_1and2;
					float delta_g_1and2 = (g_2 - g_1)/len_1and2;
					float delta_b_1and2 = (b_2 - b_1)/len_1and2;
					
					float start_r = r_1 + delta_r_1and2*(y1-y);
					float start_g = g_1 + delta_g_1and2*(y1-y);
					float start_b = b_1 + delta_b_1and2*(y1-y);
					
					float len_1and3 = y1-y3; //subtracting "bottom" from the "top"
					
					float delta_r_1and3 = (r_3 - r_1)/len_1and3;
					float delta_g_1and3 = (g_3 - g_1)/len_1and3;
					float delta_b_1and3 = (b_3 - b_1)/len_1and3;
					
					float end_r = r_1 + delta_r_1and3*(y1-y);
					float end_g = g_1 + delta_g_1and3*(y1-y);
					float end_b = b_1 + delta_b_1and3*(y1-y);
					
					ColorType start_c = new ColorType(start_r, start_g, start_b);
					ColorType end_c = new ColorType(end_r, end_g, end_b);
					
					drawLine(buff, new Point2D(start_x,y,end_c), new Point2D(end_x,y,start_c));				
				} else {
					drawLine(buff, new Point2D(start_x,y,c), new Point2D(end_x,y,c));
				}
			}
			
			//fill in the top half
			
			for (int y = y2-1; y>=y3; y--) { 
				if (do_smooth) {
					
					float len_2and3 = y2-y3; //subtracting "middle" from the "top" 
					
					float delta_r_2and3 = (r_3 - r_2)/len_2and3;
					float delta_g_2and3 = (g_3 - g_2)/len_2and3;
					float delta_b_2and3 = (b_3 - b_2)/len_2and3;
					
					float start_r = r_2 + delta_r_2and3*(y2-1-y);
					float start_g = g_2 + delta_g_2and3*(y2-1-y);
					float start_b = b_2 + delta_b_2and3*(y2-1-y);
					
					float len_1and3 = y1-y3;//subtracting "middle" from the "top" 
					
					float delta_r_1and3 = (r_3 - r_1)/len_1and3;
					float delta_g_1and3 = (g_3 - g_1)/len_1and3;
					float delta_b_1and3 = (b_3 - b_1)/len_1and3;
					
					float end_r = r_1 + delta_r_1and3*(-1-y+y1);
					float end_g = g_1 + delta_g_1and3*(-1-y+y1);
					float end_b = b_1 + delta_b_1and3*(-1-y+y1);
					
					ColorType start_c = new ColorType(start_r, start_g, start_b);
					ColorType end_c = new ColorType(end_r, end_g, end_b);
					
					drawLine(buff, new Point2D(x1,y,end_c), new Point2D(Math.round((y-y2+slope2and3*x2)/slope2and3),y,start_c));	
				} else {
					drawLine(buff, new Point2D(x1,y,c), new Point2D(Math.round((y-y2+slope2and3*x2)/slope2and3),y,c));
				}
			}
		}
		}
	}	

	
	
	/////////////////////////////////////////////////
	// for texture mapping (Extra Credit for CS680)
	/////////////////////////////////////////////////
	public static void triangleTextureMap(BufferedImage buff, BufferedImage texture, Point2D p1, Point2D p2, Point2D p3)
	{
		// replace the following line with your implementation
		drawPoint(buff, p3);
	}
}
