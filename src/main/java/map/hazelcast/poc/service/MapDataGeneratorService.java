package map.hazelcast.poc.service;

import map.hazelcast.poc.domain.ProgramRow;

import java.util.List;

public interface MapDataGeneratorService {

    List<ProgramRow> getKp2Data(int numberOfPrograms, int numberOfWeeks);

    List<ProgramRow> getLyData(int numberOfPrograms, int numberOfWeeks);

    List<ProgramRow> getBuyData(int numberOfPrograms, int numberOfWeeks);
}
