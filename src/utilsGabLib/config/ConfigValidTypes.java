package utilsGabLib.config;

public enum ConfigValidTypes {
	String("String"), Integer("Integer"), Float("Float"), Double("Double");
	
	private String value;
	
	private ConfigValidTypes(String value){
		this.value = value;
	}
}
