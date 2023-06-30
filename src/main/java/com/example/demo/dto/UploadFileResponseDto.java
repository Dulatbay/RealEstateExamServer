package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponseDto {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}