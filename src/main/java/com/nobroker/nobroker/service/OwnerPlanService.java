package com.nobroker.nobroker.service;

import com.nobroker.nobroker.payload.entity.OwnerPlanDto;

import java.util.List;

public interface OwnerPlanService {
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto);

    List<OwnerPlanDto>  getAllOwnerPlans();
}
