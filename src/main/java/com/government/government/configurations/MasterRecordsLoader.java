//package com.government.government.configurations;
//
//
//import com.anambra.irs.enums.Account;
//import com.anambra.irs.dto.RegisterDto;
//import com.anambra.irs.dto.RoleDto;
//import com.anambra.irs.entity.Roles;
//import com.anambra.irs.enums.GenericStatus;
//import com.anambra.irs.repository.UserRepository;
//import com.anambra.irs.services.usermanagement.UsermanagementService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.support.TransactionTemplate;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class MasterRecordsLoader {
//
//    private final TransactionTemplate transactionTemplate;
//    private final UsermanagementService userManagementService;
//    private final UserRepository userRepository;
//
//    @EventListener(ContextRefreshedEvent.class)
//    public void init() {
//        log.info("CREATING MASTER USER...........");
//        transactionTemplate.execute(tx -> {
//            try {
//                loadDefaults();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        });
//    }
//
//    private void loadDefaults(){
//
//        var roleDto = RoleDto.builder()
//                .Permissions("CREAT_ADMIN, ALL_PERMISSIONS, CREATE_MDA")
//                .name("SUPER_ADMIN")
//                .description("This role is given to the system administrator from whom all other roles are created from")
//                .build();
//
//        Roles role = userManagementService.CreateRole(roleDto);
//
//        var dto = RegisterDto.builder()
//                .role("SUPER_ADMIN")
//                .email("tax@oasismgt.net")
//                .firstname("Tax")
//                .lastname("Admin")
//                .password("password")
//                .tinNumber("12345678")
//                .account(Account.AIRS)
//                .build();
//
//        createSuperAdminUser(dto);
//    }
//
//    private void createSuperAdminUser(RegisterDto dto) {
//        userRepository.findByUsernameIgnoreCaseAndStatus(dto.getEmail(), GenericStatus.ACTIVE)
//            .orElseGet(() -> {
//                log.info("=========== CREATING SUPER_ADMIN {} ============", dto.getEmail());
//                try {
//                   userManagementService.Register(dto);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return null;
//            });
//    }
//}
