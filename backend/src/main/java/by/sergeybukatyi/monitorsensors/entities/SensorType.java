package by.sergeybukatyi.monitorsensors.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "sensor_types")
public class SensorType implements Serializable {

  private static final long serialVersionUID = 883606959201686324L;
  @Id
  @Column(name = "type_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", length = 40, nullable = false, unique = true)
  private String typeName;

  @JsonIgnore
  @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
  private List<Sensor> sensors;

  public SensorType() {
  }

  public SensorType(String typeName) {
    this.typeName = typeName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorType that = (SensorType) o;
    return typeName.equals(that.typeName);
  }

  @Override
  public String toString() {
    return typeName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeName);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long sensorTypeId) {
    this.id = sensorTypeId;
  }
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
