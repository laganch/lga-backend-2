package com.government.government.servicesImpl;

import com.government.government.Enum.Gender;
import com.government.government.Enum.GenericStatusConstant;
import com.government.government.dto.AuthRequest;
import com.government.government.dto.LoginResponse;
import com.government.government.dto.UserDto;
import com.government.government.entity.Area;
import com.government.government.entity.Lga;
import com.government.government.entity.State;
import com.government.government.entity.Users;
import com.government.government.repository.AreaRepository;
import com.government.government.repository.LgaRepository;
import com.government.government.repository.StateRepository;
import com.government.government.repository.UserRepository;
import com.government.government.security.JwtService;
import com.government.government.security.PasswordService;
import com.government.government.service.UserManagementService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementImpl implements UserManagementService {

    private final JwtService jwtService;
    private final PasswordService passwordService;
    private final LgaRepository lgaRepository;
    private final StateRepository stateRepository;
    private final UserRepository userRepository;
    private final AreaRepository areaRepository;


    @Override
    public Users CreateUser(UserDto user) {

        Users users = new Users();
//        State state = stateRepository.findById(user.getState()).get();
//        Lga lga = lgaRepository.findById(user.getLga()).get();
//        Area area = areaRepository.findById(user.getArea()).get();

        users.setCreatedAt(LocalDateTime.now());
//        users.setCreatedBy(jwtService.getLoggedInUser());
        users.setStatus(GenericStatusConstant.ACTIVE);
        users.setRoles(user.getRole());
        users.setGeneratedPassword(passwordService.hashPassword(user.getPassword()));
//        users.setState(state);
//        users.setLga(lga);
//        users.setArea(area);
        users.setDateOfBirth(user.getDob());
        users.setEmail(user.getEmail());
        users.setUsername(user.getEmail());
        users.setFirstName(user.getFirstName());
        users.setLastName(user.getLastName());
        users.setOtherNames(user.getOtherNames());
        users.setDisplayName(user.getFirstName() + " " + user.getLastName());
        users.setAddress(user.getAddress());
        if (users.getGender() != null){
            users.setGender(Gender.valueOf(user.getGender().toUpperCase()));
        }
        users.setPhoneNumber(user.getPhoneNumber());
        users.setEmailVerified(false);
        users.setSetupComplete(false);
        users.setUserVerified(false);
        users.setIsActive(true);

        return userRepository.save(users);
    }

    @Override
    public LoginResponse authenticateUser(AuthRequest dto) throws Exception{
        Users user = userRepository.findByUsernameIgnoreCase(dto.getEmail())
                .orElseThrow(() -> new Exception("Invalid Username/Deactivated account- " + dto.getEmail()));
        if (passwordService.comparePassword(user.getGeneratedPassword(), dto.getPassword())) {
            String token = jwtService.generateJwtToken(user.getId());
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setRole(user.getRoles());
            loginResponse.setName(user.getDisplayName());
//            loginResponse.setLga(user.getLga().getName());
//            loginResponse.setState(user.getState().getName());
            return loginResponse;
        } else {
            throw new Exception("Invalid password");
        }
    }

    @Override
    public List<State> getStates() {
        return stateRepository.findAll();
    }

    @Override
    public List<Lga> getLga(Long id) {
        State state = stateRepository.findById(id).get();
        return lgaRepository.findAllByState(state);
    }

    @Override
    public List<Area> getArea(Long id) {
        Lga lga = lgaRepository.findById(id).get();
        return areaRepository.findAllByLga(lga);
    }
}
