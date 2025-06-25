package com.bossy.myrestapiapp.application;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bossy.myrestapiapp.application.dto.SubjectRequestDto;
import com.bossy.myrestapiapp.application.dto.SubjectResponseDto;
import com.bossy.myrestapiapp.domain.model.SubjectPOJO;
import com.bossy.myrestapiapp.domain.repository.SubjectRepository;

@Service
public class SubjectApplicationService {

	private final SubjectRepository subjetRepo;

	public SubjectApplicationService(SubjectRepository subjectRepo) {
		this.subjetRepo = subjectRepo;
	}

	public SubjectResponseDto createSubject(SubjectRequestDto request) {
		SubjectPOJO subject = SubjectPOJO.createNew(request.getValue(), request.getLabel());
		SubjectPOJO savedPojo = subjetRepo.save(subject);

		SubjectResponseDto response = new SubjectResponseDto(savedPojo.getId(), savedPojo.getValue(),
				savedPojo.getLabel(), savedPojo.getCreationDate(), savedPojo.getLastUpdatedDate());

		return response;
	}

	public SubjectResponseDto[] getAllSubjects() {
		ArrayList<Optional<SubjectPOJO>> subjects = subjetRepo.findAll();
		ArrayList<SubjectResponseDto> responseList = new ArrayList<>();

		for (Optional<SubjectPOJO> subject : subjects) {
			if (subject.isPresent()) {
				SubjectPOJO subjectPOJO = subject.get();
				SubjectResponseDto pojo = new SubjectResponseDto(subjectPOJO.getId(), subjectPOJO.getValue(),
						subjectPOJO.getLabel(), subjectPOJO.getCreationDate(), subjectPOJO.getLastUpdatedDate());

				responseList.add(pojo);
			}
		}
		if (responseList.isEmpty()) {
			return new SubjectResponseDto[0];
		}
		return responseList.toArray(new SubjectResponseDto[0]);
	}
}
