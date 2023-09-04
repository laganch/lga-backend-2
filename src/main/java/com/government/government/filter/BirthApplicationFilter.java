package com.government.government.filter;

import com.government.government.entity.applications.QDeathApplications;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public class BirthApplicationFilter extends BaseSearchDto  implements QuerydslBinderCustomizer<QDeathApplications> {
    @Override
    public void customize(QuerydslBindings bindings, QDeathApplications root) {

        bindings.bind(root.applicationId).as("applicationId").first((path, value) -> path.containsIgnoreCase(value));
        bindings.bind(root.status).as("approvalstatus").first((path, value) -> path.eq(value));
        bindings.bind(root.paymentStatus).as("paymentStatus").first((path, value) -> path.eq(value));
        bindings.bind(root.applicantFirstName).as("applicant").first((path, value) -> path.containsIgnoreCase(value));
        bindings.bind(root.deceasedFirstName).as("deceased").first((path, value) -> path.containsIgnoreCase(value));
        bindings.including(root.applicationId, root.status,root.paymentStatus,root.applicantFirstName, root.deceasedFirstName);
    }
}
