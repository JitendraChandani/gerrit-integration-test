import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MyStringListMap extends HashMap<String, List<String>> {

	public String put(String key, String value) {
		if (!this.containsKey(key)) {
			this.put(key, new ArrayList<String>(Arrays.asList(value)));
		} else {
			this.get(key).add(value);
		}
		return null;
	}

}
