package in.happy.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CITIZEN_APP")
public class CitizenApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	private String name;
	private String mail;
	private Long number;
	private LocalDate doB;
	private String gender;
	private Long ssn;
	private String stateName;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	
	

}
