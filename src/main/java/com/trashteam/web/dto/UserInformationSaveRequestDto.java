package com.trashteam.web.dto;

import com.trashteam.block.UserBlock;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInformationSaveRequestDto {

    private String name;
    private String address;
    private String residentNumber;
    private String fingerPrintPrivateKey;
    private String facePhotoPrivateKey;
    private String publishDate;
    private String publisher;


    @Builder
    public UserInformationSaveRequestDto(String name, String address, String residentNumber,
                                         String publishDate, String publisher)
    {
        this.name=name;
        this.address=address;
        this.residentNumber=residentNumber;
        this.publishDate = publishDate;
        this.publisher = publisher;
    }

    public UserBlock userBlockObject(){
        return UserBlock.builder()
                .facePhotoPrivateKey(facePhotoPrivateKey)
                .fingerPrintPrivateKey(fingerPrintPrivateKey)
                .address(address)
                .name(name)
                .residentNumber(residentNumber)
                .publishDate(publishDate)
                .publisher(publisher)
                .build();
    }
}
