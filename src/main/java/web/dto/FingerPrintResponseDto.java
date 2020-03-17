package web.dto;

import domain.fingerPrint.FingerPrint;
import lombok.Builder;

public class FingerPrintResponseDto {
    private String privateKey;
    private String fingerPrintPhotoUrl;

    @Builder
    public FingerPrintResponseDto(FingerPrint entity){
        this.privateKey = entity.getPrivateKey();
        this.fingerPrintPhotoUrl = entity.getFingerPrintPhotoUrl();
    }
}
