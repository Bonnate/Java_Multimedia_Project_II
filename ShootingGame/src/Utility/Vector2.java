package Utility;

public class Vector2
{
	public float x;
	public float y;
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Vector2 Normalize(Vector2 vector)
	{
	    float length = (float) Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2));
	    return new Vector2(vector.x/length, vector.y/length);
	}
}
