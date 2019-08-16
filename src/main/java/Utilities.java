final class Utilities {
    /**
     * Pass a string array containing numbers and
     * @return an array containing values parsed from strings
     */
    static int[] convertStringArrayToIntArray(String[] strings) {
        int[] arrayOfIntsBasedOnStringArray = new int[strings.length];
        int i = 0;
        for (String str : strings) {
            arrayOfIntsBasedOnStringArray[i] = Integer.parseInt(str.trim());
            i++;
        }
        return arrayOfIntsBasedOnStringArray;
    }
}
