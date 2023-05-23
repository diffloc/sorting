package sorting;

public class CommandLineParser {
    public static String parseDataTypeArgument(String[] args) {
        // Implementation to parse the dataType argument from args
        // Return the dataType value or throw an exception if not found or not valid
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
}
