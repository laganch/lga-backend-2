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
import com.government.government.secuity.JwtService;
import com.government.government.service.UserManagementService;
import com.government.government.utils.JWTUtils;
import com.government.government.utils.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagementImpl implements UserManagementService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository repository;
    private JwtService jwtService;
    @Autowired
    private JWTUtils jwtUtil;
    private final PasswordService passwordService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LgaRepository lgaRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AreaRepository areaRepository;


    @Override
    public Users CreateUser(UserDto user) {

        Users users = new Users();
        State state = stateRepository.findById(user.getState()).get();
        Lga lga = lgaRepository.findById(user.getLga()).get();
        Area area = areaRepository.findById(user.getArea()).get();

        users.setCreatedAt(LocalDateTime.now());
//        users.setCreatedBy(jwtService.getLoggedInUser());
        users.setStatus(GenericStatusConstant.ACTIVE);
        users.setRoles(user.getRole());
        users.setGeneratedPassword(passwordService.hashPassword(user.getPassword()));
        users.setState(state);
        users.setLga(lga);
        users.setArea(area);
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
        LoginResponse response = new LoginResponse();
        try {
            String password = userRepository.findByUsernameIgnoreCase(dto.getUserName()).getGeneratedPassword();
            Boolean passwordMatch = passwordService.comparePassword(password, dto.getPassword());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getUserName(),
                            passwordMatch ? password : dto.getPassword()
                    ));
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }

        Users users = userRepository.findByUsernameIgnoreCase(dto.getUserName());
        String token =  jwtUtil.generateToken(dto.getUserName());
        response.setToken(token);
        response.setName(users.getDisplayName());
        response.setLga(users.getLga().getName());
        response.setState(users.getState().getName());
        response.setRole(users.getRoles());

        return response;
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
