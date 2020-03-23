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
    private String issueDate;
    private String issuer;


    @Builder
    public UserInformationSaveRequestDto(String name, String address, String residentNumber,
                                         String issueDate, String issuer)
    {
        this.name=name;
        this.address=address;
        this.residentNumber=residentNumber;
        this.issueDate=issueDate;
        this.issuer=issuer;
    }

    public UserBlock userBlockObject(){
        return UserBlock.builder()
                .facePhotoPrivateKey(facePhotoPrivateKey)
                .fingerPrintPrivateKey(fingerPrintPrivateKey)
                .address(address)
                .name(name)
                .residentNumber(residentNumber)
                .issueDate(issueDate)
                .issuer(issuer)
                .build();
    }
}
