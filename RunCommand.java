import java.io.IOException;

public class RunCommand {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String output = execCmd(args[0]);
		MyStringListMap result = new MyStringListMap();
		String[] lines = output.split(System.getProperty("line.separator"));
		for (String s : lines) {
			s.replaceAll("\\n+", "");
			String[] data = s.split(" ", 2);
			String key = data[0];
			String value = data[1].trim();
			if (key.equalsIgnoreCase("Output")
					|| key.equalsIgnoreCase("Duration")) {
				result.put(key, value.trim());
			} else if (key.equalsIgnoreCase("Errors")) {
				result.put(key, value.split(" ", 2)[1].trim());
			}
		}
		System.out.println(result);

	}

	public static String execCmd(String cmd) throws java.io.IOException {
		java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime()
				.exec(cmd).getInputStream()).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}
	

}
