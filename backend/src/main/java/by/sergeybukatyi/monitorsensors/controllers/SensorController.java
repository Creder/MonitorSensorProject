package by.sergeybukatyi.monitorsensors.controllers;

import by.sergeybukatyi.monitorsensors.entities.Sensor;
import by.sergeybukatyi.monitorsensors.services.SensorService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensors")
@CrossOrigin("*")
public class SensorController {

  private final SensorService sensorService;

  @Autowired
  public SensorController(SensorService sensorService) {

    this.sensorService = sensorService;
  }

  @GetMapping(path = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
  public ArrayList<Sensor> allSensors() {

    return sensorService.getAllSensors();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Sensor oneSensor(@PathVariable("id") Long sensorId) {
    return sensorService.getSensor(sensorId);
  }

  @PostMapping(value = "/create")
  public boolean createNewSensor(@RequestBody Sensor sensor) {

    return sensorService.saveSensor(sensor);
  }
//
  @PutMapping(value = "/{id}/edit")
  public boolean updateSensor(@PathVariable("id") Long id, @RequestBody Sensor sensor) {

    return sensorService.updateSensor(id, sensor);
  }

  @DeleteMapping(value = "/{id}/delete")
  public boolean deleteSensor(@PathVariable("id") Long id) {
    return sensorService.deleteSensor(id);
  }
}
