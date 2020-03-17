package web.dto;

import domain.photo.FacePhoto;
import lombok.Builder;

public class FacePhotoResponseDto {

    private String privateKey;
    private String facePhotoUrl;

    @Builder
    public FacePhotoResponseDto(FacePhoto entity){
        this.privateKey = entity.getPrivateKey();
        this.facePhotoUrl = entity.getFacePhotoUrl();

    }
}
