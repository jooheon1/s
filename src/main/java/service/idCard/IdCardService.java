package service.idCard;

import domain.fingerPrint.FingerPrint;
import domain.fingerPrint.FingerPrintRepository;
import domain.photo.FacePhoto;
import domain.photo.FacePhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dto.FacePhotoResponseDto;
import web.dto.FingerPrintResponseDto;
import web.dto.IdCardSaveRequestDto;

@RequiredArgsConstructor
@Service
public class IdCardService {
    private final FingerPrintRepository fingerPrintRepository;
    private final FacePhotoRepository facePhotoRepository;

    @Transactional
    public void save(IdCardSaveRequestDto requestDto){
        fingerPrintRepository.save(requestDto.toFingerPEntity());
        facePhotoRepository.save(requestDto.toFacePEntity());
    }

    @Transactional
    public FacePhotoResponseDto facePhotoFindByPrivateKey(String facePhotoPrivateKey){
        FacePhoto facePhotoEntity = facePhotoRepository.findByPrivateKey(facePhotoPrivateKey).orElseThrow(() -> new IllegalArgumentException("해당 사진이 없습니다."));
        return new FacePhotoResponseDto(facePhotoEntity);
    }

    @Transactional
    public FingerPrintResponseDto fingerPrintFindByPrivateKey(String fingerPrintPrivateKey){
        FingerPrint fingerPrintEntity = fingerPrintRepository.findByPrivateKey(fingerPrintPrivateKey).orElseThrow(() -> new IllegalArgumentException("해당 지문이 없습니다."));
        return new FingerPrintResponseDto(fingerPrintEntity);
    }

    @Transactional
    public void delete (String fingerPrintPrivateKey, String facePhotoPrivateKey){
        FingerPrint fingerPrint = fingerPrintRepository.findByPrivateKey(fingerPrintPrivateKey).orElseThrow(()
                -> new IllegalArgumentException("해당 지문이 없습니다"));
        FacePhoto facePhoto = facePhotoRepository.findByPrivateKey(facePhotoPrivateKey).orElseThrow(()
                -> new IllegalArgumentException("해당 사진이 없습니다"));
        fingerPrintRepository.delete(fingerPrint);
        facePhotoRepository.delete(facePhoto);
    }
}