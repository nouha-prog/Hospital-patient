package ma.enset.hopital.service;

import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.AppRole;
import ma.enset.hopital.entities.AppUser;
import ma.enset.hopital.repository.AppRoleRepository;
import ma.enset.hopital.repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmedPassword) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser != null) {
            throw new RuntimeException("User already exists");
        }
        if(!password.equals(confirmedPassword)) {
            throw new RuntimeException("Password mismatch");
        }
        appUser = AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();

        AppUser savedAppUser = appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if(appRole != null) {
            throw new RuntimeException("Role already exists");
        }
        appRole = AppRole.builder()
                .role(role)
                .build();

        AppRole savedAppRole = appRoleRepository.save(appRole);
        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser == null) {
            throw new RuntimeException("User not found");
        }
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if(appRole == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getRoles().add(appRole);
    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser == null) {
            throw new RuntimeException("User not found");
        }
        AppRole appRole = appRoleRepository.findById(role).orElse(null);
        if(appRole == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser == null) {
            throw new RuntimeException("User not found");
        }
        return appUser;
    }
}
