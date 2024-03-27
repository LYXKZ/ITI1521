public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
	      boolean valid = true; // True if the pre-conditions are satistified

      	// Testing pre-conditions

      	if ( in == null || what == null || with == null ) {
      	    valid = false;
      	} else {
      	    if (what.length == with.length) {
                boolean x = true;
                for (int i = 0; i < in.length; i++) {
                    if (in[i] == null) {
                        x = false;
                    }
                }
                for (int i = 0; i < what.length; i++) {
                    if (what[i] == null) {
                        x = false;
                    }
                }
                for (int i = 0; i < with.length; i++) {
                    if (with[i] == null) {
                        x = false;
                    }
                }
                if (x) {
                    valid = true;
                } else {
                    valid = false;
                }
            } else {
                valid = false;
            }
      	}

      	if ( valid ) {
      	    out = new String[ in.length ];
      	    for ( int i=0; i<in.length; i++ ) {
                String x = in[i];
                boolean y = true;
                for (int j = 0; j < what.length; j++) {
                    if (x.equals(what[j])) {
                        out[i] = with[j];
                        y = false;
                        break;
                    }
                }
                if (y) {
                    out[i] = in[i];
                }
      	    }
      	}
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }
}
