package in.happy.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenBindApp {
	
	private String name;
	private String mail;
	private Long number;
	private LocalDate doB;
	private String gender;
	private Long ssn;

}
