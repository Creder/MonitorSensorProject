package by.sergeybukatyi.monitorsensors.services;

import by.sergeybukatyi.monitorsensors.entities.SensorUnit;
import by.sergeybukatyi.monitorsensors.persistence.JpaSensorUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SensorUnitService {
    JpaSensorUnitRepository jpaSensorUnitRepository;

    @Autowired
    SensorUnitService(JpaSensorUnitRepository jpaSensorUnitRepository){
        this.jpaSensorUnitRepository = jpaSensorUnitRepository;
    }
    public ArrayList<SensorUnit> getAllSensorUnits() {
        return jpaSensorUnitRepository.getAll();
    }
}
