package com.trashteam.web;

import com.trashteam.block.UserBlock;
import com.trashteam.service.idCard.IdCardService;
import com.trashteam.web.dto.FacePhotoSaveRequestDto;
import com.trashteam.web.dto.FingerPrintSaveRequestDto;
import com.trashteam.web.dto.UserInformationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class IdCardApiController {
   private final IdCardService idCardService;

    @PostMapping("/api/idCard/user")
    public UserBlock saveUser(@RequestBody UserInformationSaveRequestDto requestDto){
        return idCardService.save(requestDto); }

    @PostMapping("/api/idCard/fingerPrint")
    public String saveFingerPrint(@RequestBody FingerPrintSaveRequestDto requestDto){
        return idCardService.save(requestDto); }

    @PostMapping("/api/idCard/facePhoto")
    public long saveFacePhoto(@RequestBody FacePhotoSaveRequestDto requestDto){
        System.out.println(requestDto.getImgName());
        idCardService.save(requestDto);
        return 1l;
    }
}
