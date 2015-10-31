package bookIndexPipe;

import transferObject.LineWithLineNumber;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by manue on 31.10.2015.
 */
public static class ReadLineFromRessourcePipe {

    private static ReadLineFromRessourcePipe _instance;
    private ArrayList<LineWithLineNumber> _list;
    private Queue<LineWithLineNumber> _queue;

    private ReadLineFromRessourcePipe(){

        _list = new ArrayList<>();
    }

    public static ReadLineFromRessourcePipe getInstance(){

        if(_instance == null) {
            _instance = new ReadLineFromRessourcePipe();
        }
            return _instance;
    }


    public Queue<LineWithLineNumber> getQueue() {
        return _queue;
    }

    public void setQueue(Queue<LineWithLineNumber> queue) {
        this._queue = queue;
    }
}
