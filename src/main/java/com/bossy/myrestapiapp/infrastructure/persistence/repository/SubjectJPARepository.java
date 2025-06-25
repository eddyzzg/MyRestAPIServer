package com.bossy.myrestapiapp.infrastructure.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bossy.myrestapiapp.domain.model.SubjectPOJO;
import com.bossy.myrestapiapp.domain.repository.SubjectRepository;
import com.bossy.myrestapiapp.infrastructure.persistence.entity.SubjectJPAEntity;

//interface Spring Data JPA
interface springRepo extends JpaRepository<SubjectJPAEntity, String> {
}

@Repository
public class SubjectJPARepository implements SubjectRepository {

	private final springRepo springRepo;

	public SubjectJPARepository(final springRepo springRepo) {
		this.springRepo = springRepo;
	}

	@Override
	public Optional<SubjectPOJO> findById(final String id) {
		return springRepo.findById(id).map(SubjectJPAEntity::toDomain);
	}

	@Override
	public SubjectPOJO save(final SubjectPOJO subject) {
		SubjectJPAEntity entity = SubjectJPAEntity.fromDomain(subject);
		SubjectJPAEntity savedEntity = springRepo.save(entity);
		return savedEntity.toDomain();
	}

	@Override
	public void deleteById(final String id) {
		springRepo.deleteById(id);
	}

	@Override
	public ArrayList<Optional<SubjectPOJO>> findAll() {
		List<SubjectJPAEntity> all = springRepo.findAll();
		List<SubjectPOJO> pojos = all.stream().map(SubjectJPAEntity::toDomain).collect(Collectors.toList());

		ArrayList<Optional<SubjectPOJO>> optionalPojosList = pojos.stream().map(Optional::ofNullable)
				.collect(Collectors.toCollection(ArrayList::new));

		return optionalPojosList;
	}
}
