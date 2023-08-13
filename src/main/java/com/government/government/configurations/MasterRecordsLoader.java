package com.government.government.configurations;

import com.government.government.dto.AreaDto;
import com.government.government.dto.LgaDto;
import com.government.government.dto.UserDto;
import com.government.government.entity.Area;
import com.government.government.entity.Lga;
import com.government.government.entity.State;
import com.government.government.repository.AreaRepository;
import com.government.government.repository.LgaRepository;
import com.government.government.repository.StateRepository;
import com.government.government.repository.UserRepository;
import com.government.government.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class MasterRecordsLoader {

    private final TransactionTemplate transactionTemplate;
    private final UserManagementService userManagementService;
    private final UserRepository userRepository;
    private final LgaRepository lgaRepository;
    private final StateRepository stateRepository;
    private final AreaRepository areaRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        log.info("CREATING MASTER USER...........");
        transactionTemplate.execute(tx -> {
            try {
                loadDefaults();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    private void loadDefaults(){

        State state = State.builder()
                .name("Ebonyi State")
                .code("001")
                .build();

        userManagementService.CreateState(state);

        State state1 = stateRepository.findByNameIgnoreCase("Ebonyi State").orElse(null);

        var lgaDto = LgaDto.builder()
                .name("Abakaliki")
                .code("001")
                .stateId(state1.getId())
                .build();

        userManagementService.CreateLga(lgaDto);

        Lga lga = lgaRepository.findByNameIgnoreCase("Abakaliki").orElse(null);

        AreaDto area = AreaDto.builder()
                .name("Abakpa")
                .code("001")
                .lgaId(lga.getId())
                .build();

        userManagementService.CreateArea(area);

        Area area1 = areaRepository.findByNameIgnoreCase("Abakpa").orElse(null);



        var dto = UserDto.builder()
                .role("ADMIN")
                .email("lga@gmail.com")
                .firstName("LGA")
                .lastName("Admin")
                .password("password")
                .state(state1.getId())
                .lga(lga.getId())
                .address("Ebonyi")
                .area(area1.getId())
                .gender("MALE")
                .phoneNumber("08063014314")
                .build();

        createSuperAdminUser(dto);
    }

    private void createSuperAdminUser(UserDto dto) {
        userRepository.findByUsernameIgnoreCase(dto.getEmail())
            .orElseGet(() -> {
                log.info("=========== CREATING THE SUPER_ADMIN {} ============", dto.getEmail());
                try {
                   userManagementService.CreateUser(dto);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            });
    }
}
