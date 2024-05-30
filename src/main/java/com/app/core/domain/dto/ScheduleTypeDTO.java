package com.app.core.domain.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleTypeDTO {
    private Long id;
    private String typeName;
}
