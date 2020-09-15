package Modelo;

public class Datagrama {
	private String longitudTotal;
	private String flags;
	private String offsetBin;
	private String offsetDec;
	private String bits16;
	
	public Datagrama(String longitudTotal, String flags, String offsetBin, String offsetDec, String bits16) {
		this.longitudTotal = longitudTotal;
		this.flags = flags;
		this.offsetBin = offsetBin;
		this.offsetDec = offsetDec;
		this.bits16 = bits16;
	}

	public String getLongitudTotal() {
		return longitudTotal;
	}

	public void setLongitudTotal(String longitudTotal) {
		this.longitudTotal = longitudTotal;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getOffsetBin() {
		return offsetBin;
	}

	public void setOffsetBin(String offsetBin) {
		this.offsetBin = offsetBin;
	}

	public String getOffsetDec() {
		return offsetDec;
	}

	public void setOffsetDec(String offsetDec) {
		this.offsetDec = offsetDec;
	}

	public String getBits16() {
		return bits16;
	}

	public void setBits16(String bits16) {
		this.bits16 = bits16;
	}
}