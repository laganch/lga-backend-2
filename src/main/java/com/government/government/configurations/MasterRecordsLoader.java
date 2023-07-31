package com.government.government.configurations;

import com.government.government.dto.UserDto;
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
//
//        var roleDto = RoleDto.builder()
//                .Permissions("CREAT_ADMIN, ALL_PERMISSIONS, CREATE_MDA")
//                .name("SUPER_ADMIN")
//                .description("This role is given to the system administrator from whom all other roles are created from")
//                .build();
//
//        Roles role = userManagementService.CreateRole(roleDto);

        var dto = UserDto.builder()
                .role("ADMIN")
                .email("lga@gmail.com")
                .firstName("LGA")
                .lastName("Admin")
                .password("password")
                .state(6L)
                .lga(1L)
                .address("Ebonyi")
                .area(2L)
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
