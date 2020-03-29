
public class Proc {
	
	private String procLabel;
	private int vt;
	
	public Proc(String procLabel, int vt) {
		this.procLabel = procLabel;
		this.vt = vt;
	}
	
	public void setProcLabel(String newLabel) {
		this.procLabel = newLabel;
	}
	
	public String getProcLabel() {
		return this.procLabel;
	}
	
	public void setVT(int newVT) {
		this.vt = newVT;
	}
	
	public int getVT() {
		return this.vt;
	}	

}
