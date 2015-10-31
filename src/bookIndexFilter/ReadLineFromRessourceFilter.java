package bookIndexFilter;

import bookIndexPipe.ReadLineFromRessourcePipe;
import filter.DataEnrichmentFilter;
import interfaces.*;
import interfaces.Readable;
import transferObject.LineWithLineNumber;

import java.io.*;
import java.security.InvalidParameterException;

/**
 * Created by manue on 31.10.2015.
 */
public class ReadLineFromRessourceFilter /*extends DataEnrichmentFilter< in, out>*/ {

    LineWithLineNumber _lineWithLineNumber;
    FileReader _file;
    int _lineNumber = 0;
    ReadLineFromRessourcePipe _pipe;

    // public ReadLineFromRessourceFilter(interfaces.Readable<in> input, Writeable<out> output) throws InvalidParameterException {
    //   super(input, output);
    // _pipe = ReadLineFromRessourcePipe.getInstance();
    //    try {
    //      _file = new FileReader("\\res\\aliceInWonderland.txt");
    //} catch (FileNotFoundException e) {
    //        System.out.println("File existiert nicht.");
    //       e.printStackTrace();

    //   }
    //}

    public ReadLineFromRessourceFilter() {
        _pipe = ReadLineFromRessourcePipe.getInstance();
        try {
            _file = new FileReader("\\res\\aliceInWonderland.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File existiert nicht.");
            e.printStackTrace();
        }
    }


    public void readLine() {

        BufferedReader br = new BufferedReader(_file);
        StringBuffer sb = new StringBuffer();
        String s = new String();
        LineWithLineNumber lineEntity;

        int r;

        char c;

        try {
            while ((r = br.read()) != -1) {

                while ((r != 10) || (r != 13)) {
                    try {
                        c = (char) r;
                        sb.append(c);

                        r = br.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                _lineNumber++;
                s = sb.toString();
                System.out.println(s);
                if (!s.isEmpty()) {
                    lineEntity = new LineWithLineNumber(s, _lineNumber);
                    //die Zeile wird an die Pipe "ReadLineFromRessourcePipe" �bergeben
                    _pipe.getQueue().add(lineEntity);

                }
                sb.delete(0, sb.length());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
