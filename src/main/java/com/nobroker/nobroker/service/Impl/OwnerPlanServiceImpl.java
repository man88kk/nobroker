package com.nobroker.nobroker.service.Impl;

import com.nobroker.nobroker.entity.OwnerPlan;
import com.nobroker.nobroker.payload.entity.OwnerPlanDto;
import com.nobroker.nobroker.repository.OwnerPlanRepository;
import com.nobroker.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {
    private OwnerPlanRepository ownerPlanRepository;
    private ModelMapper modelMapper;
    public  OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository,ModelMapper modelMapper){
        this.ownerPlanRepository= ownerPlanRepository;
        this.modelMapper= modelMapper;
    }
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
        OwnerPlan saveOwnerPlan = ownerPlanRepository.save(ownerPlan);
        return  mapToDto(saveOwnerPlan);

}

    @Override
    public List<OwnerPlanDto> getAllOwnerPlans() {
        List<OwnerPlan> ownerPlans = ownerPlanRepository.findAll();
        List<OwnerPlanDto> ownerPlandtos = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());
      return ownerPlandtos;
    }

    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
    OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
    return  ownerPlan ;
}
    OwnerPlanDto mapToDto(OwnerPlan ownerPlan){
        OwnerPlanDto  ownerPlanDto = modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return  ownerPlanDto ;
    }
}
