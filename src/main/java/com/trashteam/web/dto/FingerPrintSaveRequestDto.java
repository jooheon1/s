package com.trashteam.web.dto;

import com.trashteam.domain.fingerPrint.FingerPrint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FingerPrintSaveRequestDto {

    private String fingerPrintPrivateKey;
    private String fingerPrintImgUrl;
    private String fingerPrintImgName;

    @Builder
    public FingerPrintSaveRequestDto(String fingerPrintImgName, String fingerPrintImgUrl){
        this.fingerPrintImgName = fingerPrintImgName;
        this.fingerPrintImgUrl = fingerPrintImgUrl;
    }

    public FingerPrint toEntity(){
        return FingerPrint.builder()
                .imgName(fingerPrintImgName)
                .imgUrl(fingerPrintImgUrl)
                .privateKey(fingerPrintPrivateKey)
                .build();
    }
}
