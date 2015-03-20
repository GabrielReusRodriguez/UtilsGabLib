package utilsGabLib.encode;

public enum CharEncode {

	UNKNOWN(0), UTF8(1), ISO_8859_1(2);

	private int value;

	private CharEncode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		String encode = "UNKNOWN";
		switch (value) {
		case 1:
			encode = "UTF-8";
			break;
		case 2:
			encode ="ISO-8859-1";
			break;
		case 0:
		default:
			break;
		}
		return encode;
	}
}
