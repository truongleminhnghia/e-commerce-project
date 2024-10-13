package org.project.ecommerce.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponse {
    private String id;
    private String name;
    private boolean status;
}
