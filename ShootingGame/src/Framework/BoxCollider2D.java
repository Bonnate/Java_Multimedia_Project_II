package Framework;

import Utility.Rect;

public class BoxCollider2D 
{
	private Rect mColliderRect;
	
	public BoxCollider2D(float xPos, float yPos, float width, float height)
	{
		mColliderRect = new Rect(xPos, yPos, width, height);
	}
	
	public BoxCollider2D(Rect rect)
	{
		mColliderRect = rect;
	}

	public Rect GetBox()
	{
		return mColliderRect;
	}

	public float[] GetBoxVertex()
	{
		float vertex[] = new float[4];
		
		vertex[0] = mColliderRect.x;
		vertex[1] = mColliderRect.y;
		vertex[2] = mColliderRect.x + mColliderRect.width;
		vertex[3] = mColliderRect.y + mColliderRect.height;
		
		return vertex;
	}
	
	public void GetVertexBox(float[] x, float[] y, float[] width, float[] height)
	{
		x[0] = mColliderRect.x;
		y[0] = mColliderRect.y;
		width[0] = mColliderRect.x + mColliderRect.width;
		height[0] = mColliderRect.y + mColliderRect.height;
	}
	
	public void Translate(double x, double y)
	{
		this.mColliderRect.x += x;
		this.mColliderRect.y += y;
	}
	
	public void SetPosition(float x, float y)
	{
		this.mColliderRect.x = x;
		this.mColliderRect.y = y;
	}
}
