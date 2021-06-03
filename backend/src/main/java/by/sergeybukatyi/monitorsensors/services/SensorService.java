package by.sergeybukatyi.monitorsensors.services;

import by.sergeybukatyi.monitorsensors.entities.Sensor;
import by.sergeybukatyi.monitorsensors.persistence.JpaSensorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class SensorService {
    private final JpaSensorRepository jpaSensorRepository;

    @Autowired
    public SensorService(JpaSensorRepository jpaSensorRepository){
      this.jpaSensorRepository = jpaSensorRepository;
    }

    public ArrayList<Sensor> getAllSensors(){
      return jpaSensorRepository.getAll();
    }

    public Sensor getSensor(Long id) { return  jpaSensorRepository.getOne(id);}

    public boolean saveSensor(Sensor sensor) {
        sensor.setId(null);
        return jpaSensorRepository.saveOrUpdate(sensor);}
//
    public boolean updateSensor(Long id, Sensor newSensor) {
            return jpaSensorRepository.saveOrUpdate(newSensor);
    }

    public boolean deleteSensor(Long id) { return jpaSensorRepository.delete(id);}
}
