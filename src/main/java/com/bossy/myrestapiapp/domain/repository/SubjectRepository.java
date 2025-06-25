package com.bossy.myrestapiapp.domain.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.bossy.myrestapiapp.domain.model.SubjectPOJO;

public interface SubjectRepository {

	Optional<SubjectPOJO> findById(String id);

	ArrayList<Optional<SubjectPOJO>> findAll();

	SubjectPOJO save(SubjectPOJO subject);

	void deleteById(String id);

}
