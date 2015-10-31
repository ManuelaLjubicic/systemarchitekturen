package bookIndexFilter;

import bookIndexPipe.LineInWordsPipe;
import transferObject.LineWithLineNumber;

/**
 * Created by Karin on 31.10.2015.
 */
public class LineToWordFilter {
    LineWithLineNumber _line;
    LineInWordsPipe _pipe;
    public LineToWordFilter(LineWithLineNumber line){
        _line = line;
    }
    // TODO implement methods for dividing the Line in words and building an ArrayList of Words
}
