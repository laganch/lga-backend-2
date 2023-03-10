package com.government.government.filter;

import com.government.government.entity.applications.QMarriageApplication;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public class MarriageApplicationFilter extends BaseSearchDto implements QuerydslBinderCustomizer<QMarriageApplication> {
    @Override
    public void customize(QuerydslBindings bindings, QMarriageApplication root) {
        bindings.bind(root.applicationId).as("applicationId").first((path, value) -> path.containsIgnoreCase(value));
        bindings.bind(root.status).as("approvalstatus").first((path, value) -> path.eq(value));
        bindings.bind(root.paymentStatus).as("paymentStatus").first((path, value) -> path.eq(value));
        bindings.bind(root.groomFirstName).as("groomFirstname").first((path, value) -> path.containsIgnoreCase(value));
        bindings.bind(root.groomLastName).as("groomLastname").first((path, value) -> path.containsIgnoreCase(value));
        bindings.including(root.applicationId, root.status,root.paymentStatus,root.groomFirstName, root.groomLastName);

    }
}
