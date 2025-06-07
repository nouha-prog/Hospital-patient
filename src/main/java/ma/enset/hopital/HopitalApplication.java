package ma.enset.hopital;

import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import ma.enset.hopital.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
public class HopitalApplication {

	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

/*    @Override
    public void run(String... args) throws Exception {
*//*        patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 134));
        patientRepository.save(new Patient(null, "Hanane", new Date(), false, 432));
        patientRepository.save(new Patient(null, "Imane", new Date(), true, 156));*//*

	 *//*        Patient patient = new Patient();
        patient.setId(null);
        patient.setNom("Mohammed");
        patient.setDateNaissance(new Date());
        patient.setMalade(false);
        patient.setScore(23);

        Patient patient2 = new Patient(null, "Yassine", new Date(), false, 123);

        Patient patient3 = Patient.builder().nom("Imane").dateNaissance(new Date()).malade(true).score(56).build();*//*
    }*/

	//@Bean
	CommandLineRunner start(PatientRepository patientRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				patientRepository.save(new Patient(null, "Mohammed", new Date(), false, 134));
				patientRepository.save(new Patient(null, "Hanane", new Date(), false, 432));
				patientRepository.save(new Patient(null, "Imane", new Date(), true, 156));
				patientRepository.save(new Patient(null, "Yassine", new Date(), false, 123));
			}
		};
	}
}