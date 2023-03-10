package com.government.government.servicesImpl;

import com.government.government.Enum.ApprovalStatus;
import com.government.government.dto.ApplicationDto;
import com.government.government.dto.DeathApplDto;
import com.government.government.dto.MarriageDto;
import com.government.government.dto.ReportDto;
import com.government.government.entity.applications.DeathApplications;
import com.government.government.entity.applications.MarriageApplication;
import com.government.government.repository.DeathApplicationRepo;
import com.government.government.repository.MarriageApplicationRepo;
import com.government.government.service.UtilityCtrlService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UtilityCtrlImpl implements UtilityCtrlService {

    private final DeathApplicationRepo deathApplicationRepo;
    private final MarriageApplicationRepo marriageApplicationRepo;

    @Override
    public List<ApplicationDto> getDeathApplicationSearch(List<DeathApplications> results) {
        return results.stream().map(result -> {

            ApplicationDto billsDTO = new ApplicationDto();

            billsDTO.setApplicationId(result.getApplicationId());
            billsDTO.setApprovalStatus(result.getApprovalStatus());
            billsDTO.setPaymentStatus(result.getPaymentStatus());
            billsDTO.setApplicantFirstName(result.getApplicantFirstName());
            billsDTO.setApplicantLastName(result.getApplicantLastName());
            billsDTO.setApplicantPhonenumber(result.getApplicantPhonenumber());
            billsDTO.setDeceasedFirstName(result.getDeceasedFirstName());
            billsDTO.setDeceasedLastName(result.getDeceasedLastName());
            billsDTO.setDeceasedMiddleName(result.getDeceasedMiddleName());
            billsDTO.setTimeCreated(result.getCreatedAt());
            billsDTO.setHospital(result.getHospital());

            return billsDTO;

        }).collect(Collectors.toList());
    }

    @Override
    public List<MarriageDto> getMarriageApplicationSearch(List<MarriageApplication> results) {
        return results.stream().map(result -> {

            MarriageDto billsDTO = new MarriageDto();

            billsDTO.setApplicationId(result.getApplicationId());
            billsDTO.setApprovalStatus(result.getApprovalStatus());
            billsDTO.setPaymentStatus(result.getPaymentStatus());
            billsDTO.setGroomFirstName(result.getGroomFirstName());
            billsDTO.setGroomLastName(result.getGroomLastName());
            billsDTO.setGroomMiddleName(result.getGroomMiddleName());
            billsDTO.setBrideLastName(result.getBrideLastName());
            billsDTO.setBrideFirstName(result.getBrideFirstName());
            billsDTO.setBrideMiddleName(result.getBrideMiddleName());
            billsDTO.setTimeCreated(result.getCreatedAt());

            return billsDTO;

        }).collect(Collectors.toList());
    }

    @Override
    public ReportDto ReportDashboard() {
        ReportDto dto = new ReportDto();

        List<DeathApplications> deathApplications = deathApplicationRepo.findAll();
        List<MarriageApplication> marriageApplications = marriageApplicationRepo.findAll();

        int  totalApprovedApplications=0,totalPendingApplication=0,totalQueriedApplication=0, totatRejectedApplications=0;

        if (deathApplications.size() > 0){
            for (DeathApplications deathApplication : deathApplications) {

                if (deathApplication.getApprovalStatus() == ApprovalStatus.QUERIED){
                    totalQueriedApplication++;
                }
                else  if (deathApplication.getApprovalStatus() == ApprovalStatus.REJECTED){
                    totatRejectedApplications++;
                }else  if (deathApplication.getApprovalStatus().equals(ApprovalStatus.APPROVED)){
                    totalApprovedApplications++;
                }else{
                    totalPendingApplication++;
                }
            }
        }
        if (marriageApplications.size() > 0){
            for (MarriageApplication marriageApplication : marriageApplications) {
                if (marriageApplication.getApprovalStatus() == ApprovalStatus.QUERIED){
                    totalQueriedApplication++;
                }
                else  if (marriageApplication.getApprovalStatus() == ApprovalStatus.REJECTED){
                    totatRejectedApplications++;
                }else  if (marriageApplication.getApprovalStatus() == ApprovalStatus.APPROVED){
                    totalApprovedApplications++;
                }else{
                    totalPendingApplication++;
                }
            }
        }


        dto.setTotalApprovedApplications(totalApprovedApplications);
        dto.setTotalPendingApplication(totalPendingApplication);
        dto.setTotalQueriedApplication(totalQueriedApplication);
        dto.setTotalRejectedApplication(totatRejectedApplications);
        dto.setTotalApplications(deathApplications.size() + marriageApplications.size());

        return dto;
    }

    @Override
    public DeathApplications getDeathApplication(String aid) {
        return deathApplicationRepo.findByApplicationId(aid);
    }

    @Override
    public Object GeneralApproval(String type, String aid) {
        if (type.equalsIgnoreCase("death")){
            DeathApplications applications = deathApplicationRepo.findByApplicationId(aid);
            applications.setApprovalStatus(ApprovalStatus.APPROVED);
            deathApplicationRepo.save(applications);
            return "Approval Successful";
        }
        return null;
    }

    @Override
    public Object GeneralQuery(String type, String aid, String reason) {
        if (type.equalsIgnoreCase("death")){
            DeathApplications applications = deathApplicationRepo.findByApplicationId(aid);
            applications.setApprovalStatus(ApprovalStatus.QUERIED);
            applications.setReason(reason);
            deathApplicationRepo.save(applications);
            return "Application Was Queried Successful";
        }
        return null;
    }
}
