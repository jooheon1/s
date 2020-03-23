package com.trashteam.web.dto;


import com.trashteam.domain.photo.FacePhoto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacePhotoSaveRequestDto {
    private String facePhotoPrivateKey;
    private String faceImgUrl;
    private String faceImgName;

    @Builder
    public FacePhotoSaveRequestDto(String faceImgName, String faceImgUrl){
        this.faceImgName = faceImgName;
        this.faceImgUrl = faceImgUrl;
    }

    public FacePhoto toEntity(){
        return FacePhoto.builder()
                .imgName(faceImgName)
                .imgUrl(faceImgUrl)
                .privateKey(facePhotoPrivateKey)
                .build();
    }
}
