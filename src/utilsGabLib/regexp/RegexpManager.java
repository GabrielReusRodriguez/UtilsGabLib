/**
 * 
 */
package utilsGabLib.regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gabriel
 *
 */
public class RegexpManager {

	private Pattern pattern =null;
	private Matcher matcher = null;
	private int nHits=0;
	
	public RegexpManager(String pattern,int flags){
		initPattern(pattern,flags);
	}
	
	public RegexpManager(String pattern){
		initPattern(pattern);
	}

	
	private void initPattern(String str_pattern){
		  pattern = Pattern.compile(str_pattern);
	}
	
	private void initPattern(String str_pattern,int flags){
		  pattern = Pattern.compile(str_pattern,flags);
	}
	
	public void setPattern(String str_pattern,int nHits,int flags){
		
		this.nHits = nHits;
		initPattern(str_pattern,flags);
	} 
		
	public List<String> find(String text){
			List<String> hits = new ArrayList<String>();
			this.matcher = pattern.matcher(text);
			if(matcher.find()){
				for(int i =0;i<this.nHits;i++){
					hits.add(matcher.group(i));
				}
			}
			return hits;
	}
	
	public boolean matches(String text){
		
		this.matcher = pattern.matcher(text);
		return this.matches(text);
		
	}
	
	
	public Matcher getMatcher(){
		return this.matcher;
	}
}
