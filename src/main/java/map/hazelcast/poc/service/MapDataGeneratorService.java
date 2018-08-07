package map.hazelcast.poc.service;

import java.util.List;

import map.hazelcast.poc.domain.ProgramRow;

public interface MapDataGeneratorService {

    List<ProgramRow> getKp2Data();

    List<ProgramRow> getLyData();

    List<ProgramRow> getBuyData();
}
