
public class Tree
{
	private String data;
	private int vt;
	Tree left;
	Tree right;	
	
	public Tree(String data,int vt)
	{
		this.data = data;
		this.vt=vt;
		this.left = null;
		this.right = null;
	}

	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		this.data = data;
	}

	public int getVt() 
	{
		return vt;
	}

	public void setVt(int vt) 
	{
		this.vt = vt;
	}
	
	
}