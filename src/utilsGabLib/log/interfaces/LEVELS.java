package utilsGabLib.log.interfaces;

public enum LEVELS {
		UNKNOWN(0), OFF(1), INFO(2), TRACE(3), DEBUG(4), WARNING(5), ERROR(6), FATAL(7), ALL(8);
	
		private int value;

		private LEVELS(int value) {
			this.value = value;
		}
}
