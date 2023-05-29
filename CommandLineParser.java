package sorting;

import java.util.HashMap;
import java.util.Map;

public class CommandLineParser {
    public static String parseDataTypeArgument(String[] args) {
        for (String arg: args) {
            if (arg.equals("-sortIntegers")) {
                return "sortItOut";
            }
        }

        String dataType = "";
        if (args.length > 1 && args[0].equals("-dataType")) {
            dataType = args[1];
        }
        boolean validArg = (dataType.equals("long") || dataType.equals("line") || dataType.equals("word"));
        if (!validArg) {
            throw new IllegalArgumentException("Data type argument \"" + dataType + "\" not found or not valid.");
        }
        return dataType;
    }

    public static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        for (int i = 0; i < args.length - 1; i++) {
            String arg = args[i];
            if (arg.startsWith("-")) {
                if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                    arguments.put(arg.substring(1), args[i + 1]);
                } else {
                    arguments.put(arg.substring(1), "");
                }
            }
        }
        return arguments;
    }
}
