package com.shashwat.crickscores.services;

import java.util.List;

import com.shashwat.crickscores.models.dtos.ScheduleDto;

public interface TeamIndiaService {

	List<ScheduleDto> getScheduleForTeamIndia();
}
