package com.cip;

import com.cip.creators.AddressCreator;
import com.cip.creators.DepartmentCreator;
import com.cip.creators.HospitalCreator;
import com.cip.creators.PatientCreator;
import com.cip.creators.UserCreator;
import com.cip.enums.GenderEnum;
import com.cip.enums.PriorityEnum;
import com.cip.enums.RoleEnum;
import com.cip.service.DepartmentService;
import com.cip.service.HospitalService;
import com.cip.service.PatientService;
import com.cip.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
@Slf4j
public class PatientServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(HospitalService hospitalService, DepartmentService departmentService, PatientService patientService, UserService userService) {
        return args -> {
            log.info("Started adding test data to database");
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                hospitalService.createHospital(new HospitalCreator(
                        "Hospital" + i,
                        new AddressCreator(
                                "City" + i,
                                "Street" + i,
                                "StreetNumber" + i,
                                "postalCode" + i,
                                "Country" + i,
                                10.0 + i,
                                20.0 + i)));
                for (int j = 0; j < 10; j++) {
                    departmentService.createDepartment(new DepartmentCreator(
                            "Department" + j,
                            1L + i,
                            10L + random.nextInt(200)));

                    for (int k = 0; k < 30; k++) {
                        LocalDateTime dateOfBirth = LocalDateTime.now().minusYears(random.nextInt(100)).minusDays(random.nextInt(365));
                        patientService.createPatient(new PatientCreator(
                                "FirstName" + i,
                                "LastName" + i,
                                "PESEL" + i,
                                dateOfBirth,
                                random.nextBoolean() ? GenderEnum.MALE : GenderEnum.FEMALE,
                                random.nextBoolean() ? PriorityEnum.LOW : PriorityEnum.HIGH,
                                null,
                                (long) (LocalDateTime.now().getYear() - dateOfBirth.getYear()),
                                1L + j + (i * 10)));
                    }
                }
            }
            userService.createUser(new UserCreator(
                    "admin@gmail.com",
                    "admin",
                    "admin",
                    RoleEnum.ADMIN));
            userService.createUser(new UserCreator(
                    "dispatcher@gmail.com",
                    "dispatcher",
                    "dispatcher",
                    RoleEnum.DISPATCHER));
            userService.createUser(new UserCreator(
                    "paramedic@gmail.com",
                    "paramedic",
                    "paramedic",
                    RoleEnum.PARAMEDIC));
            userService.createUser(new UserCreator(
                    "doctor@gmail.com",
                    "doctor",
                    "doctor",
                    RoleEnum.DOCTOR));
            log.info("Ended adding test data to database.");
        };
    }
}