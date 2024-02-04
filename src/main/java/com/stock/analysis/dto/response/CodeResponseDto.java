package com.stock.analysis.dto.response;

import com.stock.analysis.application.code.repository.CodeRepository;
import com.stock.analysis.domain.entity.Code;
import com.stock.analysis.utils.Utils;

import java.util.Set;
import java.util.stream.Collectors;

public record CodeResponseDto(
        Long id,
        String name,
        Long parentId,
        Set<CodeResponseDto> children,
        String createdAt,
        String createdBy,
        String modifiedAt,
        String modifiedBy
) {
    public static CodeResponseDto of(Long id,
                                     String name,
                                     Long parentId,
                                     Set<CodeResponseDto> children,
                                     String createdAt,
                                     String createdBy,
                                     String modifiedAt,
                                     String modifiedBy
    ) {
        return new CodeResponseDto(id, name, parentId, children, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static CodeResponseDto from(Code code) {
        return CodeResponseDto.of(
                code.getId(),
                code.getName(),
                code.getParentId(),
                code.getChildren().stream()
                        .map(CodeResponseDto::from)
                        .collect(Collectors.toUnmodifiableSet()),
                Utils.ConvertDate(code.getCreatedAt()),
                code.getCreatedBy(),
                Utils.ConvertDate(code.getModifiedAt()),
                code.getModifiedBy()
        );
    }
}
