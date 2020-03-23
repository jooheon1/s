package com.trashteam.web;

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
    public void saveUser(@RequestBody UserInformationSaveRequestDto requestDto){
        idCardService.save(requestDto);
    }

    @PostMapping("/api/idCard/fingerPrint")
    public void saveFingerPrint(@RequestBody FingerPrintSaveRequestDto requestDto){idCardService.save(requestDto); }

    @PostMapping("/api/idCard/facePhoto")
    public void saveFacePhoto(@RequestBody FacePhotoSaveRequestDto requestDto){
        idCardService.save(requestDto);
    }
}
