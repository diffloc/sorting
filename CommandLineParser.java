package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandLineParser {

    public static Map<String, String> parseArguments(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        List<String> knownArgs = Arrays.asList("-dataType", "-sortingType"); // Todo: ENUM

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (!knownArgs.contains(args[i])) {
                    System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
                    continue;
                }
                if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                    arguments.put(args[i], args[i + 1]);
                    i++; // skip the next arg since we've already processed it
                } else {
                    arguments.put(args[i], "");
                }
            }
        }
        return arguments;
    }
}
