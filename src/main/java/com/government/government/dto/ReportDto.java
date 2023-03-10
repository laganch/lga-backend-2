package com.government.government.dto;

import lombok.Data;

@Data
public class ReportDto {
    private int totalApplications;
    private int totalApprovedApplications;
    private int totalPendingApplication;
    private int totalQueriedApplication;
    private int totalRejectedApplication;
}
