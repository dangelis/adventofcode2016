package pottyKeyPad;

public class Key {

	String name;
	private Key up;
	private Key rt;
	private Key lt;
	private Key dn;
	
	public Key(String keyNum) {
		name = keyNum;
	}
	
	Key goUp() {
		return up;
	}
	
	void setUp(Key keyAbove) {
		up = keyAbove;
	}
	
	Key goRt() {
		return rt;
	}
	
	void setRt(Key keyAtRight) {
		rt = keyAtRight;
	}
	
	Key goLt() {
		return lt;
	}
	
	void setLt(Key keyAtLeft) {
		lt = keyAtLeft;
	}
	
	Key goDn() {
		return dn;
	}
	
	void setDn(Key keyBelow) {
		dn = keyBelow;
	}

}
