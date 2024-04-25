package jsoft.objects;

public class LoginFormObejct {
	private String txtName;
	private String txtPass;
	public String getTxtName() {
		return txtName;
	}
	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}
	public String getTxPass() {
		return txtPass;
	}
	public void setTxPass(String txPass) {
		this.txtPass = txPass;
	}
	public LoginFormObejct() {
	
	}
	public LoginFormObejct(String txtName, String txPass) {
		super();
		this.txtName = txtName;
		this.txtPass = txPass;
	}
	
}
