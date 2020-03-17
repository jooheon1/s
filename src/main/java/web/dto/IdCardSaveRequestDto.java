package web.dto;

import domain.fingerPrint.FingerPrint;
import domain.photo.FacePhoto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IdCardSaveRequestDto {
    private String fingerPrintPrivateKey;
    private String facePhotoPrivateKey;
    private String fingerPrintPhotoUrl;
    private String facePhotoUrl;

    @Builder
    public IdCardSaveRequestDto(String title, String content, String author) {
        this.fingerPrintPrivateKey = title;
        this.facePhotoPrivateKey = content;
    }

    public FingerPrint toFingerPEntity() {
        return FingerPrint.builder()
                .privateKey(fingerPrintPrivateKey)
                .fingerPrintPhotoUrl(fingerPrintPhotoUrl)
                .build();
    }

    public FacePhoto toFacePEntity(){
        return FacePhoto.builder()
                .privateKey(facePhotoPrivateKey)
                .facePhotoUrl(facePhotoUrl)
                .build();
    }
}