package bookIndexFilter;

import filter.DataEnrichmentFilter;
import interfaces.*;

import java.security.InvalidParameterException;

/**
 * Created by manue on 31.10.2015.
 */
public class ReadLineFromRessourceFilter extends DataEnrichmentFilter<int, out>{

    public ReadLineFromRessourceFilter(interfaces.Readable<int> input, Writeable<out> output) throws InvalidParameterException {
        super(input, output);
    }

    @Override
    protected boolean fillEntity(int nextVal, out entity) {
        return false;
    }

    @Override
    protected out getNewEntityObject() {
        return null;
    }
}
